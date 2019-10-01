package twitterApis;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Twitter1Test {

	/*
	 * @Test(dataProvider = "dp") public void f(Integer n, String s) { }
	 * 
	 * @BeforeMethod public void beforeMethod() { }
	 * 
	 * @AfterMethod public void afterMethod() { }
	 * 
	 * 
	 * @DataProvider public Object[][] dp() { return new Object[][] { new Object[] {
	 * 1, "a" }, new Object[] { 2, "b" }, }; }
	 * 
	 * @BeforeClass public void beforeClass() { }
	 * 
	 * @AfterClass public void afterClass() { }
	 * 
	 * @BeforeTest public void beforeTest() { }
	 * 
	 * @AfterTest public void afterTest() { }
	 * 
	 * @BeforeSuite public void beforeSuite() { }
	 * 
	 * @AfterSuite public void afterSuite() { }
	 */

	@Test
	public void readTweet() {
		RestAssured.baseURI = "https://api.twitter.com/1.1/statuses";
		Response res = given().auth()
				.oauth("PMorEr9DqI5ANJp1OIu8AwxIT", "fSLAa5Vt9XIFezaK13t8d7x13DgU4zebOLT49OhXAYQUOWdNC6",
						"379145303-ntJfKSXT68ak1Gdx4ojKklJyCfj4dYdwebfQcKXG",
						"X71HW4dG9YjLTXFPdJg1f8DZu4qBvpa4CNWsmfuYSnyW7")
				.queryParam("id", "1173291807783837697").when().get("/show.json").then().assertThat().statusCode(200)
				.extract().response();

		String resStr = res.asString();
		JsonPath js = new JsonPath(resStr);
		System.out.println("recent tweet : " + js.get("text"));

	}

}
