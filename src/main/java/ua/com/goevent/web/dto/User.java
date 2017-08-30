package ua.com.goevent.web.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class User {
    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 6, max = 30)
    private String password;
}
