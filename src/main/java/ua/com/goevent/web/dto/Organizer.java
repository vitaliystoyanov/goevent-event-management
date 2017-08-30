package ua.com.goevent.web.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Organizer {
    @Size(max = 50)
    private String name;

    @URL
    private String webpageUrl;

    @NotNull
    @Email
    private String email;
}
