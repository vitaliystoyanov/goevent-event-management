package ua.com.goevent.web.dto;

import ua.com.goevent.model.EventCategory;
import ua.com.goevent.model.EventStatus;
import ua.com.goevent.model.Location;
import ua.com.goevent.model.Organizer;

import java.util.Date;

public class EventDto {

    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Location location;
    private String startDate;
    private String endDate;
    private EventCategory category;
    private EventStatus status;

    private Organizer organizer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    @Override
    public String toString() {
        return "EventDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", location=" + location +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", category=" + category +
                ", status=" + status +
                ", organizer=" + organizer +
                '}';
    }
}
