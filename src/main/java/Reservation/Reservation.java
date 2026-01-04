package Reservation;

import Airport.Airport;
import Flight.Flight;
import Passenger.Passenger;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Path;

import java.util.Random;

@Entity
public class Reservation extends PanacheEntity {

    @ManyToOne
    Flight flight;
    @ManyToOne
    Passenger passenger;
    @Enumerated
    Status status;

    public Flight getFlight() {return flight;}
    public Passenger getPassenger() {return passenger;}
    public Status getStatus() {return  status;}


    public Reservation(){}

    public Reservation(Flight flight, Passenger passenger, Status status){
        this.status = status;
        this.flight = flight;
        this.passenger = passenger;
    }


}


