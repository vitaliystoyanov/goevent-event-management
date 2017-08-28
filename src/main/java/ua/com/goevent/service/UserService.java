package ua.com.goevent.service;

import org.springframework.stereotype.Service;
import ua.com.goevent.model.UserDetails;
import ua.com.goevent.web.dto.User;

@Service
public interface UserService {

    UserDetails registerOrganizer(User userDto);

}
