package ua.com.goevent.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "event_categories")
@Data
@NoArgsConstructor
public class EventCategory implements Serializable {
    private static final long serialVersionUID = 3942060076962250629L;
    //TODO: implement later

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public EventCategory(String name) {
        this.name = name;
    }
}