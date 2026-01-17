package Airport.DTO;

import jakarta.validation.constraints.NotNull;

public class CreateAirportRequest {
    @NotNull
    public String code;
}
