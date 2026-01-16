package Flight.DTO;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class UpdateFlightRequest {
    public Long routeId;
    public LocalDateTime departure;
    public Long airplaneId;

}
