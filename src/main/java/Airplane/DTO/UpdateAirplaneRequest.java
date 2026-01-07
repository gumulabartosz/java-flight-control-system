package Airplane.DTO;

import jakarta.validation.constraints.NotNull;

public class UpdateAirplaneRequest {
    public String manufacturer;
    public String model;
    public Integer passengerCapacity;
    public Integer crewCapacity;
}
