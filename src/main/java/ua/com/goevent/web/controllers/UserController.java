package ua.com.goevent.web.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.goevent.service.UserDetailsServiceImpl;
import ua.com.goevent.web.dto.User;
import ua.com.goevent.service.error.UserAlreadyExistException;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserDetailsServiceImpl userDetailsService;

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @PostMapping("/signup")
    public String checkUserInfo(@Valid User userDto, BindingResult bindingResult, Model model) {
        log.info("Checking user info. Request: " + userDto.toString());
        if (bindingResult.hasErrors()) {
            log.error("Fields of form have errors! " + userDto.toString());
            return "signup";
        }
        try {
            userDetailsService.registerOrganizer(userDto);
        } catch (UserAlreadyExistException e) {
            log.error("{} already exists!", userDto.getEmail());
            return "signup";
        }
        return "successRegistration";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("userDto", new User());
        return "signup";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/signin";
    }

    @GetMapping("/team")
    public String team() {
        return "team";
    }
}
