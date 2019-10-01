package com.rest.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class BasicsRest {
	
	public static void main(String[] args) {
		//base uri
		RestAssured.baseURI="https://maps.googleapis.com";
		
		//currently not sending any headers and cookies
		//given
		given().
				param("location","-33.8670522,151.1957362").
				param("radius","500").
				param("Key","AIzaSyCqNKKLFHiKPj8JroKZSjEoi7ueUV1kIcc").
				when().
				get("/maps/api/place/nearbysearch/json").
				then().
				assertThat().statusCode(20)
				.and().contentType(ContentType.JSON)
				.and().statusLine("HTTP/1.1 200 OK")
				.and()
				.body("", equalTo(""));
		
		System.out.println("execution complete");
				
				
		
	}

}
