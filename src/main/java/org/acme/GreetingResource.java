package org.acme;

import Airplane.Airplane;
import Airport.Airport;
import Flight.Flight;
import Passenger.Passenger;
import Passenger.Sex;
import Reservation.Reservation;
import Route.Route;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDateTime;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        Route route1 = new Route(Airport.POZ, Airport.GDN, 45);
        Airplane a1 = new Airplane("Airbus", "A320", 200, 5);
        Flight flight1 = new Flight(route1, LocalDateTime.now(), a1);
        Passenger passenger1 = new Passenger("Janusz", "Kowalski", 35, Sex.MALE);
        Reservation r1 = new Reservation(flight1, passenger1);



        return String.valueOf(r1);



    }
}
