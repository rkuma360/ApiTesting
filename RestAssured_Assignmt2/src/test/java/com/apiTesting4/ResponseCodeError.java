package com.apiTesting4;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseCodeError {
	
	@Test
	public void Res_1() {
		
		Response res=RestAssured.given().baseUri("https://restcountries.eu/rest/v2/all").get();
		System.out.println(res.getHeaders());
		System.out.println("Res_Code:"+res.getStatusCode());
		
		
	}
	@Test
	public void Res_2() {
		Response res2=RestAssured.given().baseUri("https://restcountries.eu/rest/v2/all/currency/cop1").get();
		System.out.println(res2.getHeaders());
		System.out.println("Res_Code:"+res2.getStatusCode());
		
	}
	@Test
	public void Res_3() {
		Response res3=RestAssured.given().baseUri("https://restcountries.eu/api/unknown/23").get();
		System.out.println(res3.getHeaders());
		System.out.println("Res_Code:"+res3.getStatusCode());
		
	}
	@Test
	public void Res_4() {
		Response res4=RestAssured.given().baseUri("http:localhost:8080/clg/admin/").get();
		System.out.println(res4.getHeaders());
		System.out.println("Res_Code:"+res4.getStatusCode());
		
	}
}
