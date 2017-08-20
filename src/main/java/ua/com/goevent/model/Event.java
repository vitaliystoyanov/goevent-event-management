package ua.com.goevent.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "events")
@Data
@NoArgsConstructor
public class Event implements Serializable {
    private static final long serialVersionUID = -6391149432085415212L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private EventCategory category;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventStatus status;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    private String contactUrl;

    public Event(String name, String description, String imageUrl,
                 Location location, Date startDate, Date endDate,
                 EventCategory category, EventStatus status, Organizer organizer) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.status = status;
        this.organizer = organizer;
    }
}
