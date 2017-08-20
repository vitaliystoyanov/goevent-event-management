package ua.com.goevent.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ticket_types")
@Data
@NoArgsConstructor
public class TicketType implements Serializable {
    private static final long serialVersionUID = -705708367627748145L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private Float price;
    private Type type;

    public TicketType(Long quantity, String name, String description, Event event) {
        this.quantity = quantity;
        this.name = name;
        this.description = description;
        this.event = event;
    }
}
