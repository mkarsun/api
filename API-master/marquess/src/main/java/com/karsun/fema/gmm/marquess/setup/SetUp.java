package com.karsun.fema.gmm.marquess.setup;

import java.lang.reflect.Method;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.aeonbits.owner.ConfigFactory;
import org.junit.Before;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.karsun.fema.gmm.marquess.utils.ConfigProperties;
import com.karsun.fema.gmm.marquess.utils.ExtentManager;
import com.karsun.fema.gmm.marquess.utils.TestScenario;

import groovy.util.logging.Log;
import io.restassured.*;
import io.restassured.specification.*;

/*import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;*/

public class SetUp {
	

	public static ConfigProperties testEnvironment;
	
	public static ThreadLocal<ExtentTest> classLevelExtentTest = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> testCaseLogger = new ThreadLocal<ExtentTest>();
	public static RequestSpecification requestSpec;
   
	public static ExtentReports extent=ExtentManager.GetExtent();
	/*public ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\simple.xlsx");*/
	
	public synchronized static void setUpFramework()

	{
		TestScenario.writeToScenario(sessionId);;
		System.out.println("****************Setup***************Framework******************");
		ConfigFactory.setProperty("environment", "football");
		testEnvironment = ConfigFactory.create(ConfigProperties.class);

		RestAssured.baseURI = testEnvironment.getBaseURI();
		RestAssured.basePath = testEnvironment.getBasePath();

	 
	}

	

//	@Before(alwaysRun = true)
//	public void beforeClass() {
//
//		ExtentTest parent = extent.createTest(getClass().getSimpleName());
//
//		classLevelExtentTest.set(parent);
//	}
//
//	@BeforeMethod(alwaysRun = true)
//	public void beforeMethod(Object[] testArgs,Method method) {
//		
//		ExtentTest child = classLevelExtentTest.get().createNode(method.getName());
//		testCaseLogger.set(child);
//
//		testCaseLogger.get().log(Status.INFO, "Execution of Test case- " +method.getName()+ " started");
//	
//		System.out.println("Size of Object Array in Before Method:"+testArgs.length);
//		
//		Map<String,String>	value=(Map<String,String>)testArgs[0];
//		if(value.get("isValidKeyReq").equalsIgnoreCase("y"))
//		{
//			extentLogger().info("Valid Secret key passed");
//			requestSpec=setRequestSpec(testEnvironment.getValidKey());
//		}
//		else
//		{
//			extentLogger().info("InValid Secret key passed");
//			requestSpec=setRequestSpec(testEnvironment.getInValidKey());
//			
//		}
//		//System.out.println("in before method--> "+testArgs.length);
//		Map<String,String> paramMap = (Map<String, String>)testArgs[0];
//		System.out.println("in before method--> "+paramMap);
//		
//		// System.out.println("Execution of Test case:-" + method.getName() + "
//		// started");
//
//	}
//
//	@AfterMethod(alwaysRun = true)
//	public void afterMethod() {
//
//		extent.flush();
//	}
//
//	@AfterClass(alwaysRun = true)
//	public void AfterClass() {
//
//	}
//
//	@AfterTest(alwaysRun = true)
//	public void afterTest() {
//
//	}
//
//	@BeforeClass(alwaysRun = true)
//	public void afterSuite() {
//
//	}
//
//	public static RequestSpecification setRequestSpec(String key) {
//		
//
//		return given().auth().basic(key, "").when();
//		
//	}
//	
//	public static ExtentTest extentLogger()
//	{
//		return testCaseLogger.get();
//	}
//*/
}
