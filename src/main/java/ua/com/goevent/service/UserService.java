package ua.com.goevent.service;

import ua.com.goevent.model.UserDetails;
import ua.com.goevent.service.dto.UserDto;

public interface UserService {

    UserDetails registerNewUserAsOrganizer(UserDto userDto);
}
