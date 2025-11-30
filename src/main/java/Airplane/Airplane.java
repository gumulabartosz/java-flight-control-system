package Airplane;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.Random;

public class Airplane {
    String id;
    String manufacturer;
    String model;
    int passengerCapacity;
    int crewCapacity;
    ArrayList<Seat> seats;

    public Airplane(String manufacturer, String model, int passengerCapacity, int crewCapacity){
        Random rand = new Random();
        int rd = 100000 + rand.nextInt(900000); // 100000–999999
        String asString = String.valueOf(rd);
        String tmpId = manufacturer.substring(0,1);
        this.id = tmpId+asString;

        this.model=model;
        this.manufacturer=manufacturer;
        this.passengerCapacity=passengerCapacity;
        this.crewCapacity=crewCapacity;
    }

}


