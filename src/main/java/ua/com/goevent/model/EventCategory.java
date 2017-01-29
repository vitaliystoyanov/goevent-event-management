package ua.com.goevent.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "event_categories")
public class EventCategory implements Serializable {
    private static final long serialVersionUID = 3942060076962250629L;
    //TODO: implement later

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public EventCategory() {}

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
}