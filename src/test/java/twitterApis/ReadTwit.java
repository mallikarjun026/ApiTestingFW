package twitterApis;

import static io.restassured.RestAssured.given;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import static org.hamcrest.Matchers.equalTo;

public class ReadTwit {
	
	public static void main(String[] args) {
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
		Response res=given().auth().oauth("PMorEr9DqI5ANJp1OIu8AwxIT", "fSLAa5Vt9XIFezaK13t8d7x13DgU4zebOLT49OhXAYQUOWdNC6", "379145303-ntJfKSXT68ak1Gdx4ojKklJyCfj4dYdwebfQcKXG", "X71HW4dG9YjLTXFPdJg1f8DZu4qBvpa4CNWsmfuYSnyW7").
		queryParam("id","1173291807783837697").
		when().
		get("/show.json").
		then().
		assertThat().statusCode(200).extract().response();
		
		String resStr= res.asString();
		JsonPath js= new JsonPath(resStr);
		System.out.println("recent tweet : "+js.get("text"));
		
	}

}
