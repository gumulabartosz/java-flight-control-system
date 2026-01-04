package Airplane.DTO;

import jakarta.validation.constraints.NotNull;

public class CreateAirplaneRequest {
    @NotNull
    public String manufacturer;
    @NotNull
    public String model;
    @NotNull
    public int passengerCapacity;
    @NotNull
    public int crewCapacity;
}
