package ua.com.goevent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.goevent.model.UserRole;
import ua.com.goevent.repository.UserDetailsRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getSpringUser(userDetailsRepository.findByUsername(username));
    }

    // fix later
    private User getSpringUser(ua.com.goevent.model.UserDetails details) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (UserRole role: details.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        }
        return new User(details.getUsername(), details.getPassword(), authorities);
    }
}
