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

    public Reservation(Flight flight, Passenger passenger){
        this.status = Status.INACTIVE;
        this.flight = flight;
        this.passenger = passenger;
    }


//    @Override
//    public String toString(){
//        StringBuilder sb = new StringBuilder();
//        sb.append("Stan rezerwacji:\n")
//        .append("ID: "+ String.valueOf(this.id)).append("\n")
//        .append(String.valueOf(this.passenger)).append("\n")
//        .append(String.valueOf(this.flight)).append("\n");
//
//        return sb.toString();
//    }

    /*public void ShowReservation(){
        IO.println("Stan rezerwacji:");
        IO.println("ID: "+ String.valueOf(this.id));
        IO.println(String.valueOf(this.passenger));
        IO.println(String.valueOf(this.flight));
        //IO.println(String.valueOf(this.id));
    }*/
}


