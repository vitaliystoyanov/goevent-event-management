package ua.com.goevent.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.goevent.model.UserDetails;
import ua.com.goevent.model.UserRole;
import ua.com.goevent.service.UserDetailsServiceImpl;
import ua.com.goevent.service.dto.UserDto;
import ua.com.goevent.service.error.UserAlreadyExistException;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @PostMapping("/signup")
    public String checkUserInfo(@Valid UserDto userDto, BindingResult bindingResult) {
        System.out.println("user is " + userDto.toString());
        if (bindingResult.hasErrors()) {
            System.out.println("errors");
            return "signup";
        }
        Set<UserRole> roles = new HashSet<>();
        roles.add(UserRole.ROLE_ORGANIZER);
        UserDetails userDetails = new UserDetails(userDto.getEmail(),
                userDto.getPassword(), roles);
        try {
            userDetailsService.registerNewUser(userDetails);
        } catch (UserAlreadyExistException e) {
            System.err.println(e);
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
