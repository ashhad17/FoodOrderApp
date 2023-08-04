package com.example.foodater.Helper;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {

    public static void sendEmail(String recipientEmail, String subject, String body) {
        // SMTP server configuration
        String smtpServer = "smtp.gmail.com";
        String username = "foodaterapplication@gmail.com";
        String password = "Foodater@123";

        // Sender's email address
        String senderEmail = "asden7854@gmail.com";

        // Create properties object for SMTP authentication
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", smtpServer);
        properties.put("mail.smtp.port", "587");

        // Create a session with SMTP authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);

            // Set sender and recipient addresses
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

            // Set email subject and body
            message.setSubject(subject);
            message.setText(body);

            // Send the email
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
