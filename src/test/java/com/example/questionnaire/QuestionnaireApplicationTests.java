package com.example.questionnaire;

import com.sun.mail.smtp.SMTPTransport;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@SpringBootTest
class QuestionnaireApplicationTests {

    @Test
    void contextLoads() {
    }

    private static final String SMTP_SERVER = "smtp.gmail.com"; // smtp.yandex.uz // smtp.gmail.com
    private static final String PASSWORD = "34018302"; // 123456BDAS // klc642D123

    private static final String EMAIL_FROM = "BDAS2016@yandex.ru"; // BDAS2016@gmail.com // bardenbmw@gmail.com
    private static final String EMAIL_TO = "bardenbmw@gmail.com";

    private static final String EMAIL_SUBJECT = "Test Send Email via SMTP";
    private static final String EMAIL_TEXT = "Hello Java Mail \n ABC123";

    @Test
    public static void main(String[] args) throws MessagingException, IOException {

        var fileInputStream = new FileInputStream("config.properties");
        var properties = new Properties();
        properties.load(fileInputStream);

        var user = properties.getProperty("mail.user");
        var password = properties.getProperty("mail.password");
        var host = properties.getProperty("mail.host");

        var props = new Properties();
        props.put("mail.store.protocol", "imaps");

        var store = Session.getInstance(props).getStore();
        store.connect(host, user, password);

        var inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        System.out.println("Количество писем = " + inbox.getMessageCount());

//        Properties properties = new Properties();
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", 465);
//        properties.put("mail.smtp.auth", "true");
////        properties.put("mail.smtp.starttls.enable", "true");
//
//        properties.put("mail.smtp.ssl.enable", "true");
////        properties.put("mail.smtp.starttls.required", "true");
//// *** BEGIN CHANGE
//        properties.put("mail.smtp.user", EMAIL_FROM);
//
//        // creates a new session, no Authenticator (will connect() later)
//        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(EMAIL_FROM, PASSWORD);
//            }
//        });
//// *** END CHANGE
//
//        // creates a new e-mail message
//        Message msg = new MimeMessage(session);
//
//        msg.setFrom(new InternetAddress(EMAIL_FROM));
//        InternetAddress[] toAddresses = { new InternetAddress(EMAIL_TO) };
//        msg.setRecipients(Message.RecipientType.TO, toAddresses);
//        msg.setSentDate(new Date());
//        // set plain text message
//        msg.setText(EMAIL_TEXT);
//
//// *** BEGIN CHANGE
//        // sends the e-mail
//        Transport t = session.getTransport("smtp");
//        t.connect(EMAIL_FROM, PASSWORD);
//        t.sendMessage(msg, msg.getAllRecipients());
//        t.close();

//        Properties prop = new Properties();
////        prop.put("mail.transport.protocol", "smtp");
//        prop.setProperty("mail.smtp.host", SMTP_SERVER);
//        prop.setProperty("mail.smtp.user", USERNAME);
//        prop.setProperty("mail.transport.protocol", "smtp");
//        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.port", 587);
//        prop.put("mail.debug", "true");
////        prop.put("mail.smtp.socketFactory.port", "587");
////        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
////        prop.put("mail.smtp.socketFactory.fallback", "false");
////        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
////        prop.put("mail.smtp.ssl", "true");
////        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//        prop.put ("mail.smtp.starttls.enable", "true");
//
////        Email email = new SimpleEmail();
//
//        Session session = Session.getInstance(prop, null);
//        Message msg = new MimeMessage(session);
//
//        try {
//
//            msg.setFrom(new InternetAddress(EMAIL_FROM));
//
//            msg.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse(EMAIL_TO, false));
//
//            msg.setSubject(EMAIL_SUBJECT);
//
//            // text
//            MimeBodyPart p1 = new MimeBodyPart();
//            p1.setText(EMAIL_TEXT);
//
//            Multipart mp = new MimeMultipart();
//            mp.addBodyPart(p1);
//
//            msg.setContent(mp);
//
//
//            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
//
//            // connect
//            t.connect(SMTP_SERVER, USERNAME, PASSWORD);
//
//            // send
//            t.sendMessage(msg, msg.getAllRecipients());
//
//            System.out.println("Response: " + t.getLastServerResponse());
//
//            t.close();
//
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
    }
}
