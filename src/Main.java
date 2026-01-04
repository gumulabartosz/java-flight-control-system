import Airplane.Airplane;
import Airport.Airport;
import Flight.Flight;
import Passenger.*;
import Reservation.Reservation;
import Route.Route;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {


    Route route1 = new Route(Airport.POZ, Airport.GDN, 45);
    Airplane a1 = new Airplane("Airbus", "A320", 200, 5);
    Flight flight1 = new Flight(route1,LocalDateTime.now(), a1);
    Passenger passenger1 = new Passenger("Janusz", "Kowalski", 35, Sex.MALE);
    Reservation r1 = new Reservation(flight1, passenger1);


    r1.ShowReservation();
}
