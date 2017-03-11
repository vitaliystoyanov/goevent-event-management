package ua.com.goevent.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.goevent.web.dto.EventDTO;
import ua.com.goevent.web.dto.OrganizerDTO;

import javax.validation.Valid;

@Controller
public class ManageController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public static final String FRAGMENTS_DETAILS_VIEW = "fragments/details";
    public static final String CREATE_EVENT_VIEW = "createEvent";

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
        model.addAttribute("eventDto", new EventDTO());
        model.addAttribute("organizerDto", new OrganizerDTO());
    }

    @PostMapping("/details")
    public String saveDetails(@Valid EventDTO eventDto, BindingResult bindingResultEventDto,
                              @Valid OrganizerDTO organizerDto, BindingResult bindingResultOrganizerDto, Model model) {
        logger.info("Post request to save details of an event: {} and {}", eventDto.toString(), organizerDto.toString());
        if (bindingResultEventDto.hasErrors()){
            logger.error("Binding results of EventDTO has errors!");
            model.addAttribute("eventDto", eventDto);
            model.addAttribute("organizerDto", organizerDto);
            return CREATE_EVENT_VIEW;
        }
        if (bindingResultOrganizerDto.hasErrors()) {
            logger.error("Binding results of Org..DTO has errors!");
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
