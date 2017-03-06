package ua.com.goevent.service;

import javax.mail.MessagingException;

public interface MailService {

    void sendEmail(String senderEmail, String recipientEmail, String bodyText, String subject)
            throws MessagingException;
}
