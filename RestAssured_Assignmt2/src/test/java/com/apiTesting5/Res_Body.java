package com.apiTesting5;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Res_Body {
	
//	@Test
//	
//	public void resbody(){
//		
//		RestAssured.baseURI="https://restcountries.eu/rest/v2/all";
//		RequestSpecification httpreq=RestAssured.given();
//		Response res=httpreq.get("name/Rahul");
//		
//	}
	
    @Test	
	public void filter_Res(){
    	
    	Response res=RestAssured.given().when().baseUri("https://restcountries.eu/rest/v2").get();
    	
    	JsonPath jsonvalue=res.jsonPath();
    	String allcountries=jsonvalue.getString("name");
    	System.out.println("Countries name:"+allcountries);

}
}