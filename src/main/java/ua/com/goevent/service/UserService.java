package ua.com.goevent.service;

import ua.com.goevent.model.UserDetails;
import ua.com.goevent.web.dto.UserDto;

public interface UserService {

    UserDetails registerNewUserAsOrganizer(UserDto userDto);
}
