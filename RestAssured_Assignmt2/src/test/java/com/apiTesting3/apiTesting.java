package com.apiTesting3;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;

public class apiTesting {
	@Test
	
	public void Manipulatereqheader() {
		
		Response res=RestAssured.given().when().baseUri("https://restcountries.eu/rest/v2/all")
				.and().header("header","headerValue").and()
				.pathParam("countryName", "Australlia")
				.log().all().get("/name/{countryName}");
		res.then().assertThat().statusCode(200).log().all();
		
		Headers headr=res.headers();
		
		for(Header header:headr) 
		{
			System.out.println("hName:" + header.getName()+"Val:" +header.getValue());
		}
		ResponseBodyData body=res.getBody();
		System.out.println("Res_Body:"+body.asString());
	}

}
