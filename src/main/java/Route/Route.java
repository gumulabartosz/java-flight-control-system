package Route;

import Airport.Airport;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.ws.rs.Path;

import java.util.Random;

@Entity
public class Route extends PanacheEntity {
    @ManyToOne(optional = false)
    public Airport source;
    @ManyToOne(optional = false)
    public Airport destination;
    public int estimatedTime;

    public Route() {}

    public Route(Airport source, Airport destination, int estimatedTime){
        this.source = source;
        this.destination = destination;
        this.estimatedTime = estimatedTime;
    }
}
