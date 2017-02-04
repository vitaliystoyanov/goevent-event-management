package ua.com.goevent.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fragments")
public class FragmentsController {

    @GetMapping("/overview")
    public String overview() {
        return "fragments/overview";
    }

    @GetMapping("/details")
    public String details() {
        return "fragments/details";
    }

    @GetMapping("/addattendees")
    public String addAttendees() {
        return "fragments/add-attendees";
    }

    @GetMapping("/attendees")
    public String attendees() {
        return "fragments/attendees";
    }

    @GetMapping("/emailinvitations")
    public String emailInvitations() {
        return "fragments/email-invitations";
    }

    @GetMapping("/orders")
    public String orders() {
        return "fragments/orders";
    }

    @GetMapping("/team")
    public String team() {
        return "fragments/team";
    }

    @GetMapping("/tickets")
    public String tickets() {
        return "fragments/tickets";
    }
}
