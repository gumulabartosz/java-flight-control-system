package Passenger.DTO;

import Passenger.Sex;
import jakarta.validation.constraints.NotNull;

public class UpdatePassengerRequest {
    public String firstName;
    public String lastName;
    public Integer age;
    public Sex sex;
    public Boolean isDisabled;
}
