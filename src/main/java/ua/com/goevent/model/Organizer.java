package ua.com.goevent.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "organizers")
@Data
@NoArgsConstructor
public class Organizer implements Serializable {
    private static final long serialVersionUID = -6940202244137866511L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_details_id")
    private UserDetails userDetails;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "webpage_url")
    private String webpageUrl;

    @Column(name = "img_url")
    private String imageUrl;

    @Column(name = "email")
    private String email;

    public Organizer(UserDetails userDetails, String name, String description,
                     String webpageUrl, String imageUrl, String email) {
        this.userDetails = userDetails;
        this.name = name;
        this.description = description;
        this.webpageUrl = webpageUrl;
        this.imageUrl = imageUrl;
        this.email = email;
    }
}
