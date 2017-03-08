package ua.com.goevent.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.goevent.web.dto.EventDto;
import ua.com.goevent.web.dto.OrganizerDto;

@Controller
public class ManageController {

    @GetMapping("/manage")
    public String myEvents() {
        return "manage";
    }

    @GetMapping("/newevent")
    public String createEvent(Model model) {
        model.addAttribute("eventDto", new EventDto());
        model.addAttribute("organizerDto", new OrganizerDto());
        return "createEvent";
    }

    @GetMapping("/details")
    public String details(Model model) {
        model.addAttribute("eventDto", new EventDto());
        model.addAttribute("organizerDto", new OrganizerDto());
        return "fragments/details";
    }

    @PostMapping("/details")
    public String saveDetails(EventDto eventDto, OrganizerDto organizerDto,
                              BindingResult bindingResultEventDto, BindingResult bindingResultOrganizerDto) {
        System.out.println(eventDto.toString());
        System.out.println(organizerDto.toString());
        return "redirect:/manage";
    }

    @GetMapping("/overview")
    public String overview() {
        return "fragments/overview";
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

    @GetMapping("/tickets")
    public String tickets() {
        return "fragments/tickets";
    }

}
