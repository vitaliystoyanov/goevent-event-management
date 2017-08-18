package ua.com.goevent.service;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public interface MailService {

    void sendEmail(String senderEmail, String recipientEmail,
                   String bodyText, String subject) throws MessagingException;

}
