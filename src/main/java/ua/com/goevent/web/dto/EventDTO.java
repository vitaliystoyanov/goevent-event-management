package ua.com.goevent.web.dto;

import org.hibernate.validator.constraints.URL;
import ua.com.goevent.model.EventCategory;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EventDTO {

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public EventCategory getCategory() {
        return category;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", category=" + category +
                '}';
    }
}
