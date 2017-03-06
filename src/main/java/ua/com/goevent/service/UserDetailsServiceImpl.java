package ua.com.goevent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.goevent.model.UserDetails;
import ua.com.goevent.model.UserRole;
import ua.com.goevent.repository.UserDetailsRepository;
import ua.com.goevent.service.error.UserAlreadyExistException;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails registerNewUser(UserDetails userDetails) {
        if (emailExist(userDetails.getUsername())) {
            throw new UserAlreadyExistException("There is an account with that email address: " + userDetails.getUsername());
        }
        return userDetailsRepository.save(userDetails);
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return getSpringUser(userDetailsRepository.findByUsername(username));
    }

    // fix later
    private User getSpringUser(UserDetails details) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (UserRole role : details.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        }
        return new User(details.getUsername(), details.getPassword(), authorities);
    }

    private boolean emailExist(String email) {
        return userDetailsRepository.findByUsername(email) != null;
    }
}
