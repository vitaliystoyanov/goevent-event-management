package ua.com.goevent.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Coordinates implements Serializable {
    private static final long serialVersionUID = -139772673706943963L;

    private Double longitude;
    private Double latitude;

    public Coordinates() {}

    public Coordinates(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
