package Flight;

import Airplane.Airplane;
import Airport.Airport;
import Route.Route;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

import java.time.LocalDateTime;
import java.util.Random;


public class Flight {
    int id;
    Route route;
    LocalDateTime departure;
    LocalDateTime arrival;
    Airplane airplane;


    public Flight(Route route, LocalDateTime departure, Airplane airplane){
        Random rand = new Random();
        // 100000–999999
        this.id = 100000 + rand.nextInt(900000);
        this.route = route;
        this.departure = departure;
        this.arrival = this.departure.plusMinutes(route.estimatedTime);
        this.airplane = airplane;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Flight information:\n");
        sb.append(this.route);
        sb.append("\nDeparture: ").append(this.departure);
        sb.append("\nArrival: ").append(this.arrival);
        sb.append("\nAirplane: ").append(this.airplane);

        return sb.toString();
    }
}

