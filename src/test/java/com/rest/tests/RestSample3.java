
package com.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class RestSample3 {
  @Test
  public void restAssuredTC() {
	  
	  RestAssured.baseURI="https://maps.googleapis.com";
	  
	  given()
	  .param("location", "-33.8670522,151.1957362")
	  .param("radius", "500")
	  .param("type","restaurant")
	  .param("key", "cruiseb")
	  .param("keyword", "AIzaSyCqNKKLFHiKPj8JroKZSjEoi7ueUV1kIcc").
	 when()
	  .get("/maps/api/place/nearbysearch/json").
	 then()
//	 .assertThat()
//	 .statusCode(200)
//	 .contentType(ContentType.JSON)
//	 .header("Server", "scaffolding on HTTPServer2")
	 .body("results[0].geometry.id",equalTo("kfdsfdsfk"));
	 
	 
	  
  }
}
