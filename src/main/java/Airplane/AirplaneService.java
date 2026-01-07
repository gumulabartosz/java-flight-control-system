package Airplane;


import Airplane.DTO.CreateAirplaneRequest;
import Airplane.DTO.UpdateAirplaneRequest;
import Utils.EntityInUseException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;
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

    @Transactional
    public Airplane update(Long id, UpdateAirplaneRequest req) {
        Airplane airplane = Airplane.findById(id);
        if (airplane == null) {
            throw new EntityNotFoundException(
                    "Airplane with ID " + id + " not found"
            );
        }
        if(req.manufacturer != null) airplane.manufacturer = req.manufacturer ;
        if(req.model != null) airplane.model = req.model ;
        if(req.crewCapacity != null) airplane.crewCapacity = req.crewCapacity ;
        if(req.passengerCapacity != null) airplane.passengerCapacity = req.passengerCapacity ;

        return airplane;
    }



    @Transactional
    public void delete(Long id) {

        Airplane airplane = Airplane.findById(id);

        if (airplane == null) {
            throw new EntityNotFoundException(
                    "Airplane with id " + id + " not found."
            );
        }

        airplane.delete();

    }
}
