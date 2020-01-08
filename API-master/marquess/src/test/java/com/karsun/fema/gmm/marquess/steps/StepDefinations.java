package com.karsun.fema.gmm.marquess.steps;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSenderOptions;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import com.karsun.fema.gmm.marquess.setup.SetUp;
import com.karsun.fema.gmm.marquess.utils.ExtentTestManager;
import com.karsun.fema.gmm.marquess.utils.TestScenario;
import com.mongodb.util.JSON;



public class StepDefinations extends SetUp{
	
 	public RequestSpecification request;
	public RequestSpecification requestSpec;


	RequestSpecification requestSpecification;
	Response response;

	
	@Given("^I have a valid Auth Key$")
	public void i_have_a_valid_Auth_Key() throws Throwable {
		requestSpecification= given().auth().basic(testEnvironment.getValidKey(), "football");
	    
	}
	
	
	@When("^I see game scores$")
	public void i_see_game_scores() throws Throwable {
		
//		  RestAssured.baseURI="http://api.football-data.org";
//		  Response res = given().
//				  auth().oauth(null,null,"X-Auth-Token", " 81d7d1091db446d4acdc22a5e43b56e0").
//				  log().all().when().post("/v2/matches").then().assertThat().statusCode(200).log().all().extract().response();
//		  
		  
		  
		  
				String uri2= testEnvironment.getBaseURI()+testEnvironment.getBasePath();
				
			
				
				
//				Response response =  
				         RestAssured.given().
				    //header("Content-Type", "application/json").
				    header("X-Auth-Token","81d7d1091db446d4acdc22a5e43b56e0").
				  //  body().
				when().get(uri2).
				then().
				    log().ifError().
				    statusCode(200);
//				
//				System.out.println(response.body().asString());
				       //     contentType("application/vnd.api+json")
				        //    body("$", hasKey("authorization_token")).                                   //authorization_token is present in the response
				        //    body("any { it.key == 'authorization_token' }", is(notNullValue())).        //authorization_token value is not null - has a value
				  		//  statusCode(200);
				
			
				
	//			@Test
//				public void authenticate() {
//
//				    Credentials credentials = new Credentials();
//				    credentials.setUsername("admin");
//				    credentials.setPassword("password");
//
//				    AuthenticationToken authenticationToken =
//
//				        given()
//				            .accept("application/json")
//				            .contentType("application/json")
//				            .body(credentials)
//				        .expect()
//				            .statusCode(200)
//				        .when()
//				            .post("/login")
//				        .then()
//				            .log().all()
//				            .extract()
//				                .body().as(AuthenticationToken.class);
//
//				    assertNotNull(authenticationToken.getToken());
//				}
				
				
				
				
				

//				given().accept(ContentType.JSON)
//				  .auth()
//				  .oauth2("81d7d1091db446d4acdc22a5e43b56e0")
//		
//		given().auth()
//		//  .basic("X-Auth-Token", "81d7d1091db446d4acdc22a5e43b56e0")
//		.form("X-Auth-Token", "81d7d1091db446d4acdc22a5e43b56e0")
//		 
//		.when()
//		  .get(uri2)
//		  .then()
//		  .statusCode(200);
		 // .body("filters.permission", equalTo("TIER_ONE"));
	//requestSpecification.auth();
	//	requestSpecification.authentication();
		String uri=
				"https://jsonplaceholder.typicode.com/todos/1";
				//"http://api.football-data.org/v2/matches";
		//response=requestSpecification.get("http://api.football-data.org/v2/matches").
		System.out.println(uri);
		System.out.println(uri2);

		//given().when().get(uri).then().statusCode(200);
		
		Response res2 = get(uri2);
		//  assertEquals(200, response.getStatusCode());
		 System.out.println("yyyyyyyyyyyyyyy"+ res2.getStatusCode());
		  String json = res2.asString();
		  System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx  "+ json);
		  
		  
//		  String requestJSONStr = null; 
//		  String url = testEnvironment.getBasePath();
//			request= RestAssured.given().body(requestJSONStr);
//			response = request.when().post(url);
//			
//			System.out.println("zzzzzzzzzzzzzzzz"  +response.asString());
		
		given().when().get(uri).then().body("title", equalTo("delectus aut autem"));
		 // Response text = given().then().log()).get();
		//System.out.println(text.asString());
		//body("filters.permission", equalTo("TIER_ONE"));
		//body(containsString("TIER_ONE"));
	}




	@When("^I send a Post request to \"([^\"]*)\"$")
	public void i_send_a_Post_request_to(String endPoint) throws Throwable {
		response=requestSpecification.post(endPoint).then().extract().response();
		System.out.println(response.asString());
	}

	@When("^I Enter valid email \"([^\"]*)\"$")
	public void i_Enter_valid_email(String email) throws Throwable {
		requestSpecification.formParam("email", email);
	}

	@When("^I enter valid description \"([^\"]*)\"$")
	public void i_enter_valid_description(String description) throws Throwable {
		requestSpecification.formParam("description", description);
	}

	

	@Then("^new customer should get created$")
	public void a_new_customer_should_get_created() throws Throwable {
	   String id=response.jsonPath().get("id");
	   ExtentTestManager.logInfo("Id of the new Customer is: "+id);
	   Assert.assertTrue(!id.equals("null"));

		
	}

	@Then("^the response status code should be (\\d+)$")
	public void the_response_status_code_should_be(int arg1) throws Throwable {
	  
		Assert.assertEquals(arg1, response.getStatusCode());
		
	}
	
	@When("^I send a Get request to \"([^\"]*)\"$")
	public void i_send_a_Get_request_to(String arg1) throws Throwable {
		
		response=given().header("Authorization", "Bearer sk_test_kzxPb2wjsBPiIh7QxZKqJU3a").get(arg1).then().extract().response();
	
		System.out.println("retirve all -->"+response.asString());
		
	}

	@Then("^I should be able to retrive all customers$")
	public void i_should_be_able_to_retrive_all_customers() throws Throwable {
		int size=response.jsonPath().get("data.size()");
		Assert.assertEquals(size, 10);
		
	
	}

}
