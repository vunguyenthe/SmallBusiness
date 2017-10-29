package com.small.business.service.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private static Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void send(String recipient, String subject, String message, EmailContentType contentType) {

        MimeMessagePreparator messagePreparator = mimeMessage -> {
            LOGGER.info("--Sending email---");
            LOGGER.info("From:" + from);
            LOGGER.info("Recipient:" + recipient);
            LOGGER.info("Subject:" + subject);
            LOGGER.info("Message:" + message);
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(from);
            messageHelper.setTo(recipient);
            messageHelper.setSubject(subject);
            if (EmailContentType.TEXT_PLAIN.equals(contentType)) {
                messageHelper.setText(message);
            } else {
                messageHelper.setText(message, true);
            }
        };
        try {
            emailSender.send(messagePreparator);
            LOGGER.info("--email sent.---");
        } catch (MailException e) {
            LOGGER.error("Error sending mail to " + recipient + " , message=" + message, e);
            throw e;
        }
    }

}
