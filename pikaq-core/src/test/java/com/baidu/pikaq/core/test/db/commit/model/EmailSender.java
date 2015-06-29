package com.baidu.pikaq.core.test.db.commit.model;

public interface EmailSender {
    void sendEmail(String email, String subject, String text);
}
