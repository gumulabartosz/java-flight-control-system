package Flight;

import Airplane.Airplane;
import Airport.Airport;
import Route.Route;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.ws.rs.Path;

import java.time.LocalDateTime;
import java.util.Random;

@Entity
public class Flight extends PanacheEntity {
    @ManyToOne
    Route route;
    LocalDateTime departure;
    LocalDateTime arrival;
    @ManyToOne(optional = false)
    Airplane airplane;

    public Route getRoute() { return route; }
    public LocalDateTime getDeparture() { return departure; }
    public LocalDateTime getArrival() { return arrival; }
    public Airplane getAirplane() { return airplane; }


    public Flight(){};

    public Flight(Route route, LocalDateTime departure, Airplane airplane){
        this.route = route;
        this.departure = departure;
        this.arrival = this.departure.plusMinutes(route.estimatedTime);
        this.arrival = this.departure.plusMinutes(40);
        this.airplane = airplane;
    }


}

