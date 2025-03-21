package project.testapi_petstore;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiPetstoreTest {
	
	@Test
	public void testCadastrarNovoPet() {
		baseURI = "https://petstore.swagger.io";
		given()
			.body("{\"id\": 7878,"
					+ "\"petId\": 1010,"
					+ "\"quantity\": 1,"
					+ "\"shipDate\": \"2022-04-28\","
					+ "\"status\": \"avaliable\","
					+ "\"complete\": true}")
			.contentType("application/json")
		.when()
			.post("/v2/store/order")
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.body("id", is (7878))
			.body("petId", is (1010));
	}
	
	@Test
	public void testPesquisarPetInexistente() {
		baseURI = "https://petstore.swagger.io";
		String petId = "99999999";
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
	public void testAtualizarDadosPetExistente() {
		baseURI = "https://petstore.swagger.io";
		given()
			.contentType("application/json")
			.log().all()
				.body("{\r\n"
					+ "  \"id\": 7878,\r\n"
					+ "  \"category\": {\r\n"
					+ "    \"id\": 1,\r\n"
					+ "    \"name\": \"gato\"\r\n"
					+ "  },\r\n"
					+ "  \"name\": \"Garfield\",\r\n"
					+ "  \"photoUrls\": [\r\n"
					+ "    \"string\"\r\n"
					+ "  ],\r\n"
					+ "  \"tags\": [\r\n"
					+ "    {\r\n"
					+ "      \"id\": 7879,\r\n"
					+ "      \"name\": \"Felix\"\r\n"
					+ "    }\r\n"
					+ "  ],\r\n"
					+ "  \"status\": \"available\"}")
		.when()
			.put("/v2/pet")
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.body("id", is (7878))
			.body("name", is ("Garfield"))
			.body("status", is ("available"));
	}
	
	@Test
	public void testPesquisarPetsComStatusPending() {
		baseURI = "https://petstore.swagger.io";
		basePath = "/v2/pet/findByStatus?status=pending";
		given()
			.contentType("application/json")
			.log().all()
		.when()
			.get(baseURI + basePath)
		.then()
			.log().all()
			.assertThat()
			.statusCode(200);
	}
}