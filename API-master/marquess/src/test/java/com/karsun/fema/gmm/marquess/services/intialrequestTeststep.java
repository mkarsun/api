//package com.karsun.fema.gmm.marquess.services;
//
//import java.util.Properties;
//
//import org.apache.log4j.Logger;
//import org.junit.Assert;
//import com.karsun.fema.gmm.marquess.cucumber.SetUp;
//import com.karsun.fema.gmm.marquess.rest.ReusableSpecificationEndPoints;
//import com.karsun.fema.gmm.marquess.utils.ApihelperMethods;
//import com.karsun.fema.gmm.marquess.utils.LoadProperties;
//
//import cucumber.api.Scenario;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.When;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//public class intialrequestTeststep  extends SetUp{
//	
//	private static Logger log = Logger.getLogger(intialrequestTeststep.class);
//	public Scenario scenario;
//	public Properties props;
//
//	protected RequestSpecification reqspec;
//	protected RequestSpecification aceRequestSpec;
//	private static String intialRequest = "";
//	private String aceApiRequest = "";
//	public Response response;
//	static Response intialResponse;
//	public String aceApiUrl = "";
//	public String requestFolder = "";
//	
//
//	public static void main(String[] args) {
//		
//		
//		
//	}
//	public Response ReceivesCode( String requestFile, int responseCode) throws Exception {
//		log.info("***********SENDING  REQUEST*************");
//		RestAssured.reset();
//		intialRequest =  ApihelperMethods.generateStringFromResource(
//				System.getProperty("user.dir").concat(LoadProperties.getProperty(requestFile);
//		//RestAssured.baseURI = props.getProperty(testEnvironment.toLowerCase() + "uatACE2_0BaseUrl");
//		scenario.write("request is " + intialRequest);
//		//String Resourcepath = props.getProperty("ACE2_0ResourcePath");
//		
//		reqspec= RestAssured
//				.given()
//				.body(intialRequest)
//				.log()
//				.all();
//		
//	for (int i=0; i<10; i++){
//		try{
//			intialResponse = reqspec
//					.when()
//					.post();
//					log.info("response is:" + intialResponse.then().extract().asString());
//					break;		
//		}catch (Exception e){
//			
//			Thread.sleep(1000);
//			System.out.println("API conenction is Reset. Retrying attempt");
//		}
//	}
//	
//	
//	for (int i =1; i<4; i++){
//		if(!(intialResponse.statusCode()== responseCode)){
//			Thread.sleep(5000);
//			
//					
//			intialResponse = aceRequestSpec.when().post();	
//	}else {break;}
//		
//	
//		Assert.assertTrue(intialResponse.statusCode() == responseCode);
//		scenario.write("API response is : " + intialResponse.then().extract().asString());
//		log.info("ACEresponse is : " + intialResponse.then().extract().asString());
//		
//	}
//	return intialResponse;
//	}
//	
//	
//
//}
