package com.karsun.fema.gmm.marquess.steps;

import java.io.IOException;

import com.karsun.fema.gmm.marquess.data.User;
import com.karsun.fema.gmm.marquess.setup.SetUp;
import com.karsun.fema.gmm.marquess.utils.ApihelperMethods;
import com.karsun.fema.gmm.marquess.utils.LoadProperties;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiHealthCheck extends SetUp{
	
	
	


	public Response response;
	public RequestSpecification request;
	public RequestSpecification requestSpec;


	
	
	@Given("^Webservice post for api (\\d+)\\.(\\d+) in the Properties file and payload \"([^\"]*)\"$")
	
	   public void Given_URL (Integer b,  String filename) throws IOException{
		
		 String requestJSONStr; 
		 
		requestJSONStr = ApihelperMethods.generateStringFromResource(LoadProperties.getProperty(filename));
		String url = testEnvironment.getBasePath();
		request= RestAssured.given().body(requestJSONStr);
		response = request.when().post(url);
		
		System.out.println(response.asString());
	}

	
	@Then("^User validates the response code returned by ACE API (\\d+)\\.(\\d+) matches the expected value (\\d+)$")
	    public void Validate_Response_Code (Integer a, Integer b, Integer responseCode) throws Throwable{
		response.then().assertThat().statusCode(responseCode);
		
	    
	}
	


}
