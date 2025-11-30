package Reservation;

import Airport.Airport;
import Flight.Flight;
import Passenger.Passenger;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

import java.util.Random;


public class Reservation {
    int id;
    Flight flight;
    Passenger passenger;
    Status status;

    public Reservation(Flight flight, Passenger passenger){
        Random rand = new Random();
        // 100000–999999
        this.id = 100000 + rand.nextInt(900000);
        this.status = Status.INACTIVE;
        this.flight = flight;
        this.passenger = passenger;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Stan rezerwacji:\n")
        .append("ID: "+ String.valueOf(this.id)).append("\n")
        .append(String.valueOf(this.passenger)).append("\n")
        .append(String.valueOf(this.flight)).append("\n");

        return sb.toString();
    }

    /*public void ShowReservation(){
        IO.println("Stan rezerwacji:");
        IO.println("ID: "+ String.valueOf(this.id));
        IO.println(String.valueOf(this.passenger));
        IO.println(String.valueOf(this.flight));
        //IO.println(String.valueOf(this.id));
    }*/
}


