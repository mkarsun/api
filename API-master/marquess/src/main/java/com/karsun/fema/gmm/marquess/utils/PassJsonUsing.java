package com.karsun.fema.gmm.marquess.utils;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response; 


public class PassJsonUsing {
	
	public static void main(String[] args) {
		
		//JsonObject jsonObj = new JsonObject();
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.append("name", "Georsen thorson");
		jsonObj.append("live", "gulja");
		jsonObj.append("Name", "sean thorson");
	
		String JsonStr = jsonObj.toString();
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(JsonStr)
				.log()
				.all().post(LoadProperties.getProperty("endPoint.1"));
		System.out.println("********************************");
		response.prettyPrint();
		
		
		
	}
}
