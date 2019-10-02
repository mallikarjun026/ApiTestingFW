package com.rest.tests;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BasicsRest2 {
	
	public static void main(String[] args) {
		//base uri
		/*RestAssured.baseURI="https://maps.googleapis.com";
		
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
				.and().statusLine("HTTP/1.1 200 OK");
		
		System.out.println("execution complete");
				*/
				
		
		RestAssured.baseURI="https://maps.googleapis.com";
		
		given().
				param("location", "").
				param("key", "").param("Key", "").
		when()
				.get("/maps/api/place/nearbysearch/json").
		then()
				.assertThat()
				.statusCode(0)
				.statusLine("")
				.contentType(ContentType.JSON);
		
	}

}
