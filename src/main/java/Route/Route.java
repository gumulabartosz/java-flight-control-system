package Route;

import Airport.Airport;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.ws.rs.Path;

import java.util.Random;

@Entity
public class Route extends PanacheEntity {
    @ManyToOne(optional = false)
    Airport source;
    @ManyToOne(optional = false)
    Airport destination;
    public int estimatedTime;

    public Route() {}

    public Route(Airport source, Airport destination, int estimatedTime){
        this.source = source;
        this.destination = destination;
        this.estimatedTime = estimatedTime;
    }
}
