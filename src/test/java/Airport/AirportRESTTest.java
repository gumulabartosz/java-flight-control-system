package Airport;

import Airport.*;
import Airport.DTO.CreateAirportRequest;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class AirportRESTTest {

    @Inject
    AirportREST airportREST;

    @BeforeEach
    @Transactional
    void setup() {
        Airport.deleteAll();
    }


    @Test
    @TestTransaction
    public void testCreateAirport() {

        Airport airport = new Airport("POZ");

        Airport a2 = RestAssured.given()
                .contentType("application/json")
                .body(airport)
                .when()
                .post("/airports")
                .then()
                .statusCode(is(200))
                .extract().as(Airport.class);

    }
    @Test
    @TestTransaction
    public void testCreateAirportAlreadyExists() {


        RestAssured.given()
                .contentType("application/json")
                .body(new Airport("POZ"))
                .when()
                .post("/airports")
                .then()
                .statusCode(is(200));

        RestAssured.given()
                .contentType("application/json")
                .body(new Airport("POZ"))
                .when()
                .post("/airports")
                .then()
                .body("message", is("Airport with code POZ already exists"));
    }

    @Test
    @TestTransaction
    public void testDeleteAirport() {

        String airportId = RestAssured.given()
                .contentType("application/json")
                .body(new Airport("POZ"))
                .when()
                .post("/airports")
                .then()
                .statusCode(200)
                .extract().path("id").toString();

        RestAssured.given()
                .contentType("application/json")
                .when()
                .delete("/airports/"+airportId)
                .then()
                .statusCode(is(204));
    }

}
