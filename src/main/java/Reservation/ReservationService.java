package Reservation;

import Airport.Airport;
import Flight.*;
import Passenger.DTO.CreatePassengerRequest;
import Passenger.*;
import Reservation.DTO.CreateReservationRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.util.List;
@ApplicationScoped
public class ReservationService {

    @Inject
    FlightService flightService;
    @Inject
    PassengerService passengerService;

    @Transactional
    public Reservation createReservation(CreateReservationRequest req) {

        Flight flight = flightService.findById(req.flightId);
        if (flight == null) {
            throw new EntityNotFoundException(
                    "Flight with ID: " + req.flightId + " not found."
            );
        }

        Passenger passenger = passengerService.findById(req.passengerId);
        if (passenger == null) {
            throw new EntityNotFoundException(
                    "Passenger with ID: " + req.passengerId + " not found."
            );
        }

        Reservation r = new Reservation(flight, passenger, req.status);
        r.persist();
        return r;
    }

    public Reservation findById(Long id) {
        return Reservation.findById(id);
    }

    public List<Reservation> findAllPaged(int page, int size) {

        return Reservation.findAll()
                .page(page, size)
                .list();
    }

    public long count() {
        return Reservation.count();
    }


    @Transactional
    public void delete(Long id) {

        Reservation reservation = Reservation.findById(id);

        if (reservation == null) {
            throw new EntityNotFoundException(
                    "Reservation with id " + id + " not found."
            );
        }
        reservation.delete();
    }
}
