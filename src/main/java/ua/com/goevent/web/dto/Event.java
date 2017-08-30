package ua.com.goevent.web.dto;

import lombok.Data;
import org.hibernate.validator.constraints.URL;
import ua.com.goevent.model.EventCategory;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Event {
    @NotNull
    @Size(max = 50)
    private String title;
    @NotNull
    @Size(max = 2000)
    private String description;
    @NotNull
    @URL
    private String imageUrl;

    private String startDate;
    private String endDate;

    private EventCategory category;
}
