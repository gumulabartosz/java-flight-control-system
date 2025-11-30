package Airplane;

import Route.Route;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

@Entity
public class Airplane extends PanacheEntity {
    String manufacturer;
    String model;
    int passengerCapacity;
    int crewCapacity;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    ArrayList<Seat> seats;

    public String getManufacturer() { return manufacturer; }
    public String getModel() { return model; }
    public int getPassengerCapacity() { return passengerCapacity; }
    public int getCrewCapacity() { return crewCapacity; }

    public Airplane(String manufacturer, String model, int passengerCapacity, int crewCapacity){
        this.model=model;
        this.manufacturer=manufacturer;
        this.passengerCapacity=passengerCapacity;
        this.crewCapacity=crewCapacity;
    }

}


