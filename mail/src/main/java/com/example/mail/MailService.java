package com.example.mail;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    private final MailConfig mailConfig;
    private static String MAIL = "flighttry@gmail.com";

    JavaMailSenderImpl mailSender;

    public MailService(MailConfig mailConfig) {
        this.mailConfig = mailConfig;
        createMailSender();
    }

    private void createMailSender() {
        mailSender = new JavaMailSenderImpl();

        mailSender.setHost(this.mailConfig.getHost());
        mailSender.setPort(this.mailConfig.getPort());
        mailSender.setUsername(this.mailConfig.getUsername());
        mailSender.setPassword(this.mailConfig.getPassword());

    }

    public void sendMail(Mail mail) throws MessagingException, javax.mail.MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(MAIL);
        helper.setTo(mail.getEmail());
        helper.setSubject(mail.getSubject());
        helper.setText(MailTemplate(mail.getName(), mail.getBody()), true);

        mailSender.send(message);
    }


    private String MailTemplate(String name, String body) {
        String template = "<html></html>" +
                "<body>" +
                    "<div display:grid;>" +
                        "<h3 style='padding-bottom:10px !important'>Dear "+name+",</h3>" +
                        "<span>"+body+"</span>"+
                    "</div>" +
                "</body>";
        return template;
    }
}
