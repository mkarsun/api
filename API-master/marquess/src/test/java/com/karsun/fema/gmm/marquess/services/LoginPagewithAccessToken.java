package com.karsun.fema.gmm.marquess.services;

import com.karsun.fema.gmm.marquess.setup.SetUp;
import com.karsun.fema.gmm.marquess.utils.ReusableConstants;
import com.karsun.fema.gmm.marquess.utils.TestScenario;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginPagewithAccessToken extends SetUp{

	public static Response apiResponse;
	public static RequestSpecification reqspec;

@SuppressWarnings("unused")
private static void getAccessToken(String JSONStr) {
	String apiToken="81d7d1091db446d4acdc22a5e43b56e0";
	//String userID= "aor@microsoft.test";

	RestAssured.reset();
	RestAssured.useRelaxedHTTPSValidation();
	RestAssured.baseURI = testEnvironment.getBaseURI();
//	RestAssured.proxy(ReusableConstants.InternetProxyHost, ReusableConstants.InternetProxyPort);
//	RestAssured.config = RestAssured.config().encoderConfig(
//			EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));

	 reqspec = RestAssured.given().contentType(ReusableConstants.APPLICATION_JSON)
			.header("Authorization", "X-Auth-Token".concat(apiToken)).body(JSONStr);
	reqspec.log().all();
	String Resourcepath = testEnvironment.getBasePath();
	//TestScenario.writeToScenario("ACE Check API request URL: "+TestCon+TestConfig.getProperty("ACECheckAPIResourcePath"));
	apiResponse = reqspec.when().post(Resourcepath);
}


public static void getCheckAPIResponse() {
	apiResponse.then().assertThat().statusCode(ReusableConstants.HTTPSUCCESSCODE);
	
	String jsonResp=apiResponse.then().extract().asString();
	TestScenario.writeJSONToScenario(jsonResp, " API Response");
	//ACECheckAPIResponseData.setACEAPIResponse(jsonResp);
}

public static void checkACEAPIReturnCode(int expectedReturnCode) {
	apiResponse.then().assertThat().statusCode(expectedReturnCode);
	TestScenario.writeToScenario("ACE Check API returned HTTPS status code is "+apiResponse.statusCode());
	String jsonResp=apiResponse.then().extract().asString();
	TestScenario.writeJSONToScenario(jsonResp, "ACE Check API Response");
	//.setACEAPIResponse(jsonResp);
}

//public static void clearServiceData() {
//	ACECheckAPIRequestData.clear();
//	ACECheckAPIDB.clear();
//	GFSDB.clearDBDocs();
//	ACECheckAPIDerivedData.clear();
//	ACECheckAPIResponseData.clear();
//	ACECheckAPIHVERequestData.clear();
//	ACECheckAPIHVEResponseData.clear();
//	ACECheckAPIAARequestData.clear();
//	ACECheckAPIAAResponseData.clear();
//




}