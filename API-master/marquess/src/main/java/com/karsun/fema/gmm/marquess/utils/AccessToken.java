package com.karsun.fema.gmm.marquess.utils;

import org.apache.log4j.Logger;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import com.karsun.fema.gmm.marquess.setup.SetUp;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class AccessToken extends SetUp{

	public static final String ContentType = ReusableConstants.APPLICATION_JSON;
	public static final String GrantType = "password";
	//public static final String ClientID = "QnqaRPWTQtgManGMEgXdq4opZXjW7WS7";
	//public static final String ClientSecret = "6Wu1GMd5zGOrShMy";

	public static final String UserName = "aor@microsoft.test";
	public static final String Password = "pass";
	public static final String AccessTokenPath = "$.access_token";
	
	private static String accessToken=null;
	
	public static String getAccessToken() {
		if(accessToken == null) {
			getNewAccessToken();
		}
		return accessToken;
	}

	public static String getNewAccessToken() {
		accessToken=generateNewAccessToken();
		return accessToken;
	}

	private static String generateNewAccessToken() {
		RestAssured.baseURI = testEnvironment.getBaseURI();
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.proxy(ReusableConstants.InternetProxyHost, ReusableConstants.InternetProxyPort);
		RequestSpecification reqspec = RestAssured.given().contentType(ContentType).formParam("grant_type", GrantType)
				//.formParam("client_id", ClientID).formParam("client_secret", ClientSecret)
				.formParam("username", UserName).formParam("password", Password);
		reqspec.log().all();
		String Resourcepath = testEnvironment.getAccessToken_URI_Path();
		Response apiResponse = reqspec.when().post(Resourcepath);
		apiResponse.then().assertThat().statusCode(ReusableConstants.HTTPSUCCESSCODE);
		String jsonResp = apiResponse.then().extract().asString();
		TestScenario.writeToScenario("Response is :" + jsonResp);
		ReadContext JSONContext = JsonPath.parse(jsonResp);
		String accessTokenInResponse = JSONContext.read(AccessTokenPath);
		return accessTokenInResponse;
	}
	
       
	
	
}


