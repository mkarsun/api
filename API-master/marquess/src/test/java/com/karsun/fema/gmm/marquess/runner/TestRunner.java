package com.karsun.fema.gmm.marquess.runner;

import org.junit.runner.RunWith;




import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "com.karsun.fema.gmm.marquess.steps",
		plugin = "com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport.html",
		
		tags={"@mehmet"}
		)

	public class TestRunner  {

	
	}
	 
	
	


