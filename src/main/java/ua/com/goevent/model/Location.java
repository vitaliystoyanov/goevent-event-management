package ua.com.goevent.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "locations")
@Data
@NoArgsConstructor
public class Location implements Serializable {
    private static final long serialVersionUID = -7181541409863579446L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "venue")
    private String venue;

    @Embedded
    private Coordinates coordinates;

    public Location(String country, String state, String city,
                    String address, String zipCode, String venue, Coordinates coordinates) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.address = address;
        this.zipCode = zipCode;
        this.venue = venue;
        this.coordinates = coordinates;
    }
}
