package com.small.business.service.cvparser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.small.business.json.JSONParser;
import com.small.business.model.people.Resume.PeopleResume;

@Service("CvParseService")
public class CvParseServiceImpl implements CvParseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CvParseServiceImpl.class);

    private static final String MESSAGE_TYPE = "name";
    private static final String MESSAGE_CONTENT = "content";
    
    @Value("${cvparser.lib.path}")
    private String libPath;

    @Value("${cvparser.lib.process.timeout:10}")
    private long timeoutInMins;

    @Override
    public void parseCv(String cvPath, String jsonPath) {

        renderCv(cvPath, jsonPath, getLibPath(), getTimeout());
    }

    private String getLibPath() {

        return this.libPath;
    }

    private long getTimeout() {

        return this.timeoutInMins;
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        String libPath = "D:\\project\\ResumeParser-master";
        // String cvPath = libPath + "\\ResumeTransducer\\UnitTests\\AntonyDeepakThomas.pdf";
        String cvPath = "D:\\cv\\Resume_LeDoThu.docx";
        // String jsonPath = libPath + "\\ResumeTransducer\\antony_thomas.json";
        String jsonPath = "D:\\cv\\Resume_LeDoThu.json";
        LOGGER.info("Start parsing....");
        renderCv(cvPath, jsonPath, libPath, 10L);
        LOGGER.info("End parsing please check " + jsonPath);
        try
        {
        	InputStream is = new FileInputStream(jsonPath.toString());
        	String content = IOUtils.toString(is);
	    	LOGGER.info("content: " + content);
	        JSONObject messageContent = new JSONObject(content);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(MESSAGE_TYPE, PeopleResume.class.getSimpleName());
			jsonObject.put(MESSAGE_CONTENT, messageContent);
			
			System.out.println(jsonObject.toString());
			LOGGER.info("jsonObject: " + jsonObject.toString());
	        JSONParser.registerType(PeopleResume.class);
	        //PeopleResume obj = (PeopleResume) JSONParser.fromJsonToObject(jsonObject.toString());
	        //LOGGER.info("title: " + jsonObject.toString());
        }
        catch(Exception e) {
        	LOGGER.info("error: " + e.toString());
        }
        System.exit(0);
    }

    private static void renderCv(String cvPath, String jsonPath, String libPath, long timeoutInMins) {

        LOGGER.info("---Processing to parse CV---");
        LOGGER.info("---Parameter>> cvPath=" + cvPath);
        LOGGER.info("---Parameter>> jsonPath=" + jsonPath);
        LOGGER.info("---Parameter>> libPath=" + libPath);
        LOGGER.info("---Parameter>> Timeout=" + timeoutInMins + " in mins");
        LOGGER.info("---Parameter>> Os=" + SystemUtils.OS_NAME);

        String[] commandArr = createCommand(cvPath, jsonPath, libPath);

        Process process = null;
        StreamGobbler outputGobbler = null;
        StreamGobbler errorGobbler = null;
        try {
            ProcessStatus processStatus = new ProcessStatus();
            Object notifyObj = new Object();

            LOGGER.info("---Starting child process for command [" + StringUtils.join(commandArr, " ") + "]");
            process = Runtime.getRuntime().exec(commandArr);

            errorGobbler = new StreamGobbler(process.getErrorStream(), "ERROR", notifyObj, processStatus);
            outputGobbler = new StreamGobbler(process.getInputStream(), "OUTPUT", notifyObj, processStatus);

            // start new thread for reading io stream
            errorGobbler.start();
            outputGobbler.start();

            LOGGER.info("---Waiting for process to done--");
            synchronized (notifyObj) {
                notifyObj.wait(timeoutInMins * 60 * 1000);
            }

            if (processStatus.isSuccess()) {
                LOGGER.info("---Finish to Parse CV--. Please check json result at path " + jsonPath);
            } else {
                LOGGER.error("Can NOT parse CV, error=" + processStatus.getMessage());
                throw new RuntimeException("Can NOT parse CV, error=" + processStatus.getMessage());
            }

        } catch (IOException | InterruptedException e) {
            LOGGER.error("Failed to parse CV -- exception:", e);
            throw new RuntimeException("Failed to parse CV -- exception" + e.getMessage());
        } finally {
            if (process != null) {
                LOGGER.info("Kill child process");
                process.destroy();
            }
            if (errorGobbler != null && errorGobbler.isAlive()) {
                LOGGER.info("Stop errorGobbler thread");
                errorGobbler.interrupt();
            }
            if (outputGobbler != null && outputGobbler.isAlive()) {
                LOGGER.info("Stop outputGobbler thread");
                outputGobbler.interrupt();
            }
        }
    }

    private static String[] createCommand(String cvPath, String jsonPath, String libPath) {

        if (SystemUtils.IS_OS_WINDOWS) {
            LOGGER.info("---Creating command for window OS...");
            return createCommandWindow(cvPath, jsonPath, libPath);
        } else if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_MAC) {
            LOGGER.info("---Creating command for Linux OS...");
            return createCommandLinux(cvPath, jsonPath, libPath);
        } else {
            throw new RuntimeException("Your OS is not supported");
        }
    }

    private static String[] createCommandLinux(String cvPath, String jsonPath, String libPath) {

        List<String> command = new ArrayList<>();
        command.add("java");
        command.add("-cp");
        command.add("'" + libPath + "\\ResumeTransducer\\bin\\*;" +
                libPath + "\\GATEFiles\\lib\\*;" +
                libPath + "\\GATEFILES\\bin\\gate.jar;" +
                libPath + "\\ResumeTransducer\\lib\\*'");
        command.add("code4goal.antony.resumeparser.ResumeParserProgram");
        command.add(cvPath);
        command.add(jsonPath);

        String[] commandArr = new String[command.size()];
        commandArr = command.toArray(commandArr);
        return commandArr;
    }

    private static String[] createCommandWindow(String cvPath, String jsonPath, String libPath) {

        List<String> command = new ArrayList<>();
        command.add("powershell.exe");
        command.add("java.exe");
        command.add("-cp");
        command.add("'" + libPath + "\\ResumeTransducer\\bin\\*;" +
                libPath + "\\GATEFiles\\lib\\*;" +
                libPath + "\\GATEFILES\\bin\\gate.jar;" +
                libPath + "\\ResumeTransducer\\lib\\*'");
        command.add("code4goal.antony.resumeparser.ResumeParserProgram");
        command.add(cvPath);
        command.add(jsonPath);

        String[] commandArr = new String[command.size()];
        commandArr = command.toArray(commandArr);
        return commandArr;
    }

    private static String getProcessOutput(BufferedReader outputReader) throws IOException {

        String output;
        StringBuilder message = new StringBuilder();

        System.out.println("Get output message...");
        while ((output = outputReader.readLine()) != null) {
            System.out.println("output--" + output);
            message.append(output);
        }
        System.out.println("End output message...");
        return message.toString();
    }

    private static String getProcessError(BufferedReader errorReader) throws IOException {

        String error;
        StringBuilder message = new StringBuilder();

        System.out.println("Get message...");
        while ((error = errorReader.readLine()) != null) {
            System.out.println(error);
            message.append(error);
        }
        return message.toString();
    }

    static class ProcessStatus {

        private Boolean errorStatus = Boolean.FALSE;
        private String message;

        public boolean isSuccess() {

            return !this.errorStatus;
        }

        public void success() {

            this.errorStatus = Boolean.FALSE;
        }

        public void error() {

            this.errorStatus = Boolean.TRUE;
        }

        public void setMessage(String message) {

            this.message = message;
        }

        public String getMessage() {

            return this.message;
        }

    }

    static class StreamGobbler extends Thread {

        InputStream is;
        String type;
        Object notifyObj;
        ProcessStatus processStatus;

        StreamGobbler(InputStream is, String type, Object notifyObj, ProcessStatus processStatus) {
            this.is = is;
            this.type = type;
            this.notifyObj = notifyObj;
            this.processStatus = processStatus;
        }

        private void markSuccess(String message) {

            this.processStatus.success();
            this.processStatus.setMessage(message);
        }

        private void markError(String message) {

            this.processStatus.error();
            this.processStatus.setMessage(message);
        }

        private boolean isDoneOrError(String line) {

            boolean isDoneOrError = false;
            switch (this.type) {
            case "OUTPUT":
                if (line.toLowerCase().contains("output written to file")) {
                    isDoneOrError = true;
                    markSuccess(line);
                }
                break;

            case "ERROR":
                if (line.toLowerCase().contains("error")) {
                    isDoneOrError = true;
                    markError(line);
                }
                break;

            default:
                throw new IllegalArgumentException("Invalid type" + this.type);
            }
            return isDoneOrError;
        }

        public void run() {

            try {
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                while ((line = br.readLine()) != null) {
                    LOGGER.info(type + " > " + line);
                    if (isDoneOrError(line)) {
                        synchronized (notifyObj) {
                            notifyObj.notifyAll();
                        }
                    }
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

}
