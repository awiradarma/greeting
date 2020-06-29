package id.bogor.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/greetings")
          .then()
             .statusCode(200);
    }

}