package ua.com.goevent.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.goevent.model.UserDetails;
import ua.com.goevent.model.UserRole;
import ua.com.goevent.repository.UserDetailsRepository;
import ua.com.goevent.service.error.UserAlreadyExistException;
import ua.com.goevent.web.dto.User;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService, UserService {
    private final UserDetailsRepository userDetailsRepository;
    private final MailService mailService;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Nullable
    public UserDetails registerOrganizer(User userDto) {
        if (emailExist(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: " + userDto.getEmail());
        }
        Set<UserRole> roles = new HashSet<>();
        roles.add(UserRole.ROLE_ORGANIZER);
        UserDetails newUser = new UserDetails(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), roles);
        UserDetails savedUsed = userDetailsRepository.save(newUser);
        if (savedUsed != null) {
            mailService.sendEmail("developer.stoyanov@gmail.com", savedUsed.getUsername(), // FIXME: 3/7/17
                    "Registration complete",
                    "Goevent - Registration");
        }
        return savedUsed;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return getSpringUser(userDetailsRepository.findByUsername(username));
    }

    // fix later
    private org.springframework.security.core.userdetails.User getSpringUser(UserDetails userDetails) {
            Set<GrantedAuthority> authorities = new HashSet<>();
            for (UserRole role : userDetails.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.toString()));
            }
            return new org.springframework.security.core.userdetails.User(userDetails.getUsername(), userDetails.getPassword(), authorities);
    }

    private boolean emailExist(String email) {
        return userDetailsRepository.findByUsername(email) != null;
    }
}
