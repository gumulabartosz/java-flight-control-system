package Reservation;

import Flight.*;
import Passenger.DTO.CreatePassengerRequest;
import Passenger.*;
import Reservation.DTO.CreateReservationRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

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
        Passenger passenger = passengerService.findById(req.passengerId);

        Reservation r = new Reservation(flight, passenger);
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
}
