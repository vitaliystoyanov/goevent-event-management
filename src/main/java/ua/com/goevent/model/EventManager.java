package ua.com.goevent.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "event_managers")
@Data
@NoArgsConstructor
public class EventManager implements Serializable {
    private static final long serialVersionUID = 2362691733446650309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_details_id")
    private UserDetails userDetails;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public EventManager(UserDetails userDetails, Event event) {
        this.userDetails = userDetails;
        this.event = event;
    }
}
