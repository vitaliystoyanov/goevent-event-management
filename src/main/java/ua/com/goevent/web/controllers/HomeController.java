package ua.com.goevent.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.goevent.service.MailMessage;
import ua.com.goevent.service.MailService;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final MailService mailService;

    @GetMapping("/events")
    public String event() {
        mailService.sendEmail(
                new MailMessage("info@goevent.com.ua", "developer.stoyanov@gmail.com", "This test email.", "Test"));
        return "event";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
