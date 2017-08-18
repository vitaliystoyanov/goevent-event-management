package ua.com.goevent.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class Coordinates implements Serializable {
    private static final long serialVersionUID = -139772673706943963L;

    private final Double longitude;
    private final Double latitude;
}
