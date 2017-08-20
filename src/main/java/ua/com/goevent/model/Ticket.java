package ua.com.goevent.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
public class Ticket implements Serializable {
    private static final long serialVersionUID = -8359159102073402656L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "file_url", nullable = false)
    private String fileUrl;

    @ManyToOne
    @JoinColumn(name = "ticket_type_id", nullable = false)
    private TicketType type;

    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated; // TODO: 8/20/17 Rename to purchasedOn?

    private PaymentSource paymentSource;
    private String orderedToken;

    public Ticket(String firstName, String lastName, String email,
                  String fileUrl, TicketType type, Date dateCreated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.fileUrl = fileUrl;
        this.type = type;
        this.dateCreated = dateCreated;
    }
}
