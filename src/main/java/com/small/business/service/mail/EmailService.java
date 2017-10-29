package com.small.business.service.mail;

public interface EmailService {

    public void send(String recipient, String subject, String message, EmailContentType contentType);

}
