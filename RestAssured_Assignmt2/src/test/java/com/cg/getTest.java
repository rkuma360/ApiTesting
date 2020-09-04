package com.cg;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class getTest {
	@Test
	public void getWeatherDetails() {
		
		given()
		.when()
		.get("https://restcountries.eu/rest/v2/name/{name}")
		.then()
		.statusCode(200)
		.assertThat()
		.body("country", equalTo("eesti"))
		.header("content-Type", "application/Json");
		
	}

}
