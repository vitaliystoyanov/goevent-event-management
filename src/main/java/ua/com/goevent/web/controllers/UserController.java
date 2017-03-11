package ua.com.goevent.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.goevent.service.UserDetailsServiceImpl;
import ua.com.goevent.web.dto.UserDto;
import ua.com.goevent.service.error.UserAlreadyExistException;

import javax.validation.Valid;

@Controller
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @PostMapping("/signup")
    public String checkUserInfo(@Valid UserDto userDto, BindingResult bindingResult, Model model) {
        logger.info("Checking user info. Request: " + userDto.toString());
        if (bindingResult.hasErrors()) {
            logger.error("Fields of form have errors! " + userDto.toString());
            return "signup";
        }
        try {
            userDetailsService.registerNewUserAsOrganizer(userDto);
        } catch (UserAlreadyExistException e) {
            logger.error("{} already exists!", userDto.getEmail());
            return "signup";
        }
        return "successRegistration";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("userDto", new UserDto());
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
