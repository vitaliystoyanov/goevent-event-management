package ua.com.goevent.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/event")
    public String event() {
        return "event";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
