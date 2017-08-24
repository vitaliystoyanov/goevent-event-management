package ua.com.goevent.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/events")
    public String event() {
        return "event";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
