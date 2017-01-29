package ua.com.goevent.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "locations")
public class Location implements Serializable {
    private static final long serialVersionUID = -7181541409863579446L;

    @Id
    @Column(name = "id")
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
    private Coordinates coords;
}
