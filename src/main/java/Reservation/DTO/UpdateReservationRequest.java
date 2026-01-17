package Reservation.DTO;

import Reservation.Status;
import jakarta.validation.constraints.NotNull;

public class UpdateReservationRequest {
    public Long flightId;
    public Long passengerId;
    public Status status;
}
