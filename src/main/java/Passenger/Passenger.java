package Passenger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;

public class Passenger {

    public String firstName;
    public String lastName;
    public int age;
    public Sex sex;
    public boolean isDisabled = false;


    public Passenger (String firstName, String lastName, int age, Sex sex){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Passenger information:\n");
        sb.append("Firstname: ").append(this.firstName);
        sb.append("\nLastname: ").append(this.lastName);
        sb.append("\nAge: ").append(this.age);
        sb.append("\nSex: ").append(this.sex);
        sb.append("\nisDisabled: ").append(this.isDisabled);

        return sb.toString();
    }



}



