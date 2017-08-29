package ua.com.goevent.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;

    @SneakyThrows
    public void sendEmail(final String senderEmail, final String recipientEmail, String bodyText, String subject) {
        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");

        message.setSubject("Test an email");
        message.setFrom(senderEmail);
        message.setTo(new InternetAddress(recipientEmail));
        message.setText(bodyText);

        mailSender.send(mimeMessage);
    }

}
