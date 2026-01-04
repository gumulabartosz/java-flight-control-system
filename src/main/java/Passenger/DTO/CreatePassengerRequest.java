package Passenger.DTO;

import Passenger.Sex;
import jakarta.validation.constraints.NotNull;

public class CreatePassengerRequest {
    @NotNull
    public String firstName;
    @NotNull
    public String lastName;
    @NotNull
    public int age;
    @NotNull
    public Sex sex;
    @NotNull
    public boolean isDisabled = false;
}
