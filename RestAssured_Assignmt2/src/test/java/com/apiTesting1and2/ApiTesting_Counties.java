package com.apiTesting1and2;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ApiTesting_Counties {

	@Test
	
	public void fullName() {
		
		Response fullName=RestAssured.given().baseUri("https://restcountries.eu")
			.basePath("rest/v2/name/{name}")
				.pathParam("name", "Tunisia")
				.queryParam("fullText", true).when().get();
		
		System.out.println(fullName.asString());	
		Headers header=fullName.headers();		
		System.out.println("No. of Header"+header);
	    System.out.println("Statusline_fullNmae:"+fullName.getStatusLine());
		Assert.assertEquals(fullName.statusCode(), 200);
	}
	
	@Test
	public void currency(){
		Response curr=RestAssured.given().baseUri("https://restcountries.eu")
				.basePath("rest/v2/currency{currency}")
				.pathParam("currency", "cop").when().get();
		System.out.println(curr.asString());
		Headers header=curr.headers();
		System.out.println("All Currency:"+header);
		Assert.assertEquals(curr.getStatusCode(), 404);		
		
	}
	@Test 
	public void language() {
		Response lang=RestAssured.given().baseUri("https://restcountries.eu")
				.basePath("rest/v2/lang/{et}")
				.pathParam("et", "en").when().get();
		
		System.out.println(lang.asString());
		Headers header=lang.headers();
		System.out.println("Total Languages:"+header);
		System.out.println(lang.getStatusCode());
		Assert.assertEquals(lang.statusCode(), 200);
	}
	@Test 
	public void country_capital() {
		Response lang=RestAssured.given().baseUri("https://restcountries.eu")
				.basePath("rest/v2/capital/{capital}")
				.pathParam("capital", "tallinn").when().get();
		
		System.out.println(lang.asString());
		Headers capital=lang.headers();
		System.out.println("Total capitals:"+capital);
		System.out.println(lang.getStatusCode());
		Assert.assertEquals(lang.statusCode(), 200);
}
	@Test 
	public void list_Code() {
		Response lang=RestAssured.given().baseUri("https://restcountries.eu")
				.basePath("rest/v2/alpha/col")
				.queryParam("code", "TVD[G]").when().get();
		
		System.out.println(lang.asString());
		Headers codes=lang.headers();
		System.out.println("Total codes:"+codes);
		System.out.println(lang.getStatusCode());
		Assert.assertEquals(lang.statusCode(), 200);
}
}