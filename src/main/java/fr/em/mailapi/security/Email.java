package fr.em.mailapi.security;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;

public class Email {
    public static void sendEmail(String toEmail, String subject, String body){
        String from = "service@cuib.fr";
        final String username = "81a7f647f039c6";
        final String password = "e833d6a56d482d";
        System.out.println(body);
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.mailtrap.io");
        props.put("mail.smtp.socketFactory.port", "2525");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "2525");
//        props.put("mail.debug", "true");

        Session session = Session.getInstance(props,
                new jakarta.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.addHeader("Content-Transfer-Encoding", "8bit");
            message.addHeader("Content-Type", "text/HTML; charset=UTF-8");
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setContent(body, "text/html");
            Transport.send(message);
            System.out.println("Email envoyé");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
