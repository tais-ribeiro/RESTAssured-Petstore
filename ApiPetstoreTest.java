package project.testapi_petstore;

import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiPetstoreTest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io";
    }

    @Test
    public void deveCadastrarPet() {
        given()
            .contentType("application/json")
            .body("{\n"
                + "  \"id\": 6765,\n"
                + "  \"petId\": 8080,\n"
                + "  \"quantity\": 1,\n"
                + "  \"shipDate\": \"2025-03-21T00:00:00.000+0000\",\n"
                + "  \"status\": \"placed\",\n"
                + "  \"complete\": true\n"
                + "}")
            .log().all()
        .when()
            .post("/v2/store/order")
        .then()
            .log().all()
            .assertThat()
            .statusCode(200)
            .body("id", is(6765))
            .body("petId", is(8080))
            .body("status", is("placed"));
    }

    @Test
    public void deveBuscarPetInexistente() {
        String petId = "987654321";
        given()
            .contentType("application/json")
            .log().all()
        .when()
            .get("/v2/pet/" + petId)
        .then()
            .log().all()
            .assertThat()
            .statusCode(404)
            .body("message", containsString("Pet not found"));
    }

    @Test
    public void deveAtualizarPet() {
        given()
            .contentType("application/json")
            .body("{\n"
                + "  \"id\": 6765,\n"
                + "  \"category\": { \"id\": 2, \"name\": \"Cachorro\" },\n"
                + "  \"name\": \"Frederico\",\n"
                + "  \"photoUrls\": [\"string\"],\n"
                + "  \"tags\": [{ \"id\": 7878, \"name\": \"Thor\" }],\n"
                + "  \"status\": \"available\"\n"
                + "}")
            .log().all()
        .when()
            .put("/v2/pet")
        .then()
            .log().all()
            .assertThat()
            .statusCode(200)
            .body("id", is(6765))
            .body("name", is("Frederico"))
            .body("status", is("available"));
    }

    @Test
    public void deveListarPetsPending () {
        given()
            .contentType("application/json")
            .queryParam("status", "pending")
            .log().all()
        .when()
            .get("/v2/pet/findByStatus")
        .then()
            .log().all()
            .assertThat()
            .statusCode(200)
            .body("status", everyItem(equalTo("pending"))); 
    }
}
