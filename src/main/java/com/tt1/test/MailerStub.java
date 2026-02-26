package com.tt1.test;

public class MailerStub implements Mailer {
    @Override
    public boolean sendMail(String to, String content){
        return true;
    }
}
