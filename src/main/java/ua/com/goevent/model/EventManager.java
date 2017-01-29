package ua.com.goevent.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "event_managers")
public class EventManager implements Serializable {
    private static final long serialVersionUID = 2362691733446650309L;

    @Id
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_details_id")
    private UserDetails userDetails;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public EventManager() {}

    public EventManager(UserDetails userDetails, Event event) {
        this.userDetails = userDetails;
        this.event = event;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
