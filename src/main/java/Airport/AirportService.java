package Airport;

import Airport.DTO.CreateAirportRequest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class AirportService {
    @Transactional
    public Airport createAirport(CreateAirportRequest req){
        Airport airport = new Airport(req.code);
        airport.persist();
        return airport;
    }

    public Airport findById(Long id) {
        return Airport.findById(id);
    }

    public List<Airport> findAllPaged(int page, int size){
        return Airport.findAll().page(page,size).list();
    }

    public long count() {
        return Airport.count();
    }

}
