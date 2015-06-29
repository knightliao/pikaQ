package com.baidu.pikaq.core.test.db.commit.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderImpl implements EmailSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSenderImpl.class);

    public void sendEmail(String email, String subject, String text) {
        LOGGER.info("Sending email to {} with subject={} and text={}", email, subject, text);
    }
}
