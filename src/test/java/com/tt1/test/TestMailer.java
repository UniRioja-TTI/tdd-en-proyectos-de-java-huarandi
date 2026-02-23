package com.tt1.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMailer {
    private Mailer mailer = new MailerStub();

    @Test
    public void sendMail() {
        Assertions.assertTrue(mailer.sendMail("a", "a"));
    }
}
