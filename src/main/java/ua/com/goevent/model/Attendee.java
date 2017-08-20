package ua.com.goevent.model;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Attendee {

    @OneToMany
    private Ticket ticket;
    @OneToOne
    private Event event;
    private Boolean checkInStatus;

}
