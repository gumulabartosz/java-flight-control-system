package Airplane;


import Airplane.DTO.CreateAirplaneRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class AirplaneService {

    @Transactional
    public Airplane createAirplane(CreateAirplaneRequest req) {
        Airplane a = new Airplane(req.manufacturer, req.model, req.passengerCapacity, req.crewCapacity);
        a.persist();
        return a;
    }
    public Airplane findById(Long id) {
        return Airplane.findById(id);
    }
    public List<Airplane> findAllPaged(int page, int size) {

        return Airplane.findAll()
                .page(page, size)
                .list();
    }

    public long count() {
        return Airplane.count();
    }
}
