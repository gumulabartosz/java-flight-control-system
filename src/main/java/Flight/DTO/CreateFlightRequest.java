package Flight.DTO;

import Airplane.Airplane;
import Route.Route;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CreateFlightRequest {

    @NotNull
    public Long routeId;

    @NotNull
    public LocalDateTime departure;

    @NotNull
    public Long airplaneId;

}
