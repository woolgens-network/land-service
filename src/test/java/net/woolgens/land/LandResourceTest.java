package net.woolgens.land;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import net.woolgens.land.model.Land;
import net.woolgens.land.repository.LandRepository;
import net.woolgens.land.resource.LandResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(LandResource.class)
public class LandResourceTest {

    @Inject
    LandRepository repository;
    Land land;

    @BeforeEach
    public void setup() {
        repository.deleteAll();
        land = new Land();
        land.setId("test");
        land.setName("Test");
        land.setRegistered(System.currentTimeMillis());
        repository.persistOrUpdate(land);
    }

    @Test
    public void testGetAllEndpoint() {
        given()
                .when().get()
                .then()
                .statusCode(200)
                .body("isEmpty()", is(false));
    }

    @Test
    public void testGetEndpoint() {
        given()
                .when().get("/" + land.getId())
                .then()
                .statusCode(200)
                .body("id", is(land.getId()));
    }

    @Test
    public void testPutEndpoint() {
        Land land = new Land();
        land.setId("test-put");
        land.setName("Test-Put");
        land.setRegistered(System.currentTimeMillis());
        given().body(land).contentType(ContentType.JSON)
                .when().put()
                .then()
                .statusCode(200)
                .body("id", is(land.getId()));
    }

    @Test
    public void testDeleteEndpoint() {
        given()
                .when().delete("/" + land.getId())
                .then()
                .statusCode(200)
                .body(is("true"));
    }

}