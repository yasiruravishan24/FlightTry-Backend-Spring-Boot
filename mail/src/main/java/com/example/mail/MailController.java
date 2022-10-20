package com.example.mail;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    private final MailService mailService;


    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/v1/mails")
    public void sendMail(@RequestBody Mail mail) throws MessagingException, javax.mail.MessagingException {
        mailService.sendMail(mail);
    }
}
