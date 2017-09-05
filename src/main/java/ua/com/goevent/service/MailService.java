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
    public void sendEmail(MailMessage mailMessage) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");

        message.setSubject("Test an email");
        message.setFrom(mailMessage.getFrom());
        message.setTo(new InternetAddress(mailMessage.getTo()));
        message.setText(mailMessage.getText());

        mailSender.send(mimeMessage);
    }
}
