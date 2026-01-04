package Passenger;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.Entity;
import jakarta.ws.rs.Path;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;


@Entity
public class Passenger extends PanacheEntity {

    public String firstName;
    public String lastName;
    public int age;
    public Sex sex;
    public boolean isDisabled = false;


    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public Sex getSex() { return sex; }
    public boolean isDisabled() { return isDisabled; }

    public Passenger() {}

    public Passenger (String firstName, String lastName, int age, Sex sex, boolean isDisabled){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.isDisabled = isDisabled;
    }


//    @Override
//    public String toString(){
//        StringBuilder sb = new StringBuilder();
//        sb.append("Passenger information:\n");
//        sb.append("Firstname: ").append(this.firstName);
//        sb.append("\nLastname: ").append(this.lastName);
//        sb.append("\nAge: ").append(this.age);
//        sb.append("\nSex: ").append(this.sex);
//        sb.append("\nisDisabled: ").append(this.isDisabled);
//
//        return sb.toString();
//    }

}



