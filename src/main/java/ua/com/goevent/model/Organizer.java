package ua.com.goevent.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "organizers")
public class Organizer implements Serializable {
    private static final long serialVersionUID = -6940202244137866511L;

    @Id
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

    public Organizer() {}

    public Organizer(UserDetails userDetails, String name,
                     String description, String webpageUrl, String imageUrl, String email) {
        this.userDetails = userDetails;
        this.name = name;
        this.description = description;
        this.webpageUrl = webpageUrl;
        this.imageUrl = imageUrl;
        this.email = email;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
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

    public String getWebpageUrl() {
        return webpageUrl;
    }

    public void setWebpageUrl(String webpageUrl) {
        this.webpageUrl = webpageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
