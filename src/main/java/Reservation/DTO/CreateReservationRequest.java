package Reservation.DTO;

import Flight.Flight;
import Passenger.Passenger;
import Reservation.Status;

import jakarta.validation.constraints.NotNull;

public class CreateReservationRequest {

    @NotNull
    public Long flightId;
    @NotNull
    public Long passengerId;
    @NotNull
    public Status status;

}
