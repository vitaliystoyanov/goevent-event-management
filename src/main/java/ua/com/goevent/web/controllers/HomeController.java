package ua.com.goevent.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.goevent.service.MailService;

import javax.mail.MessagingException;

@Controller
public class HomeController {

    @Autowired
    MailService mailService;

    @GetMapping("/events")
    public String event() {
        try {
            mailService.sendEmail("info@goevent.com.ua", "developer.stoyanov@gmail.com",
                    "Test", "This test email.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "event";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
