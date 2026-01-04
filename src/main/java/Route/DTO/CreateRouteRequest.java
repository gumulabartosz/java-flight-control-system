package Route.DTO;

import Airport.Airport;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

public class CreateRouteRequest {

    @NotNull
    public Long sourceId;
    @NotNull
    public Long destinationId;
    @NotNull
    public int estimatedTime;
}
