package ua.com.goevent.web.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.goevent.web.dto.Event;
import ua.com.goevent.web.dto.Organizer;

import javax.validation.Valid;

@Slf4j
@Controller
public class ManageController {
    private static final String FRAGMENTS_DETAILS_VIEW = "fragments/details";
    private static final String CREATE_EVENT_VIEW = "createEvent";

    @GetMapping("/manage")
    public String manage() {
        return "manage";
    }

    @GetMapping("/newevent")
    public String createEvent(Model model) {
        createAttribures(model);
        return CREATE_EVENT_VIEW;
    }

    @GetMapping("/details")
    public String details(Model model) {
        createAttribures(model);
        return FRAGMENTS_DETAILS_VIEW;
    }

    private void createAttribures(Model model) {
        model.addAttribute("eventDto", new Event());
        model.addAttribute("organizerDto", new Organizer());
    }

    @PostMapping("/details")
    public String saveDetails(@Valid Event eventDto, BindingResult bindingResultEventDto,
                              @Valid Organizer organizerDto, BindingResult bindingResultOrganizerDto, Model model) {
        log.info("Post request to save details of an event: {} and {}", eventDto.toString(), organizerDto.toString());
        if (bindingResultEventDto.hasErrors()){
            log.error("Binding results of Event has errors!");
            model.addAttribute("eventDto", eventDto);
            model.addAttribute("organizerDto", organizerDto);
            return CREATE_EVENT_VIEW;
        }
        if (bindingResultOrganizerDto.hasErrors()) {
            log.error("Binding results of Org..DTO has errors!");
            model.addAttribute("eventDto", eventDto);
            model.addAttribute("organizerDto", organizerDto);
            return CREATE_EVENT_VIEW;
        }
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
