package com.karsun.fema.gmm.marquess.steps;

import com.karsun.fema.gmm.marquess.setup.SetUp;
import com.karsun.fema.gmm.marquess.utils.ExtentTestManager;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends SetUp {
	
	
	@Before
	public void beforeScenario(Scenario scenario)
	{
		
		ExtentTestManager.startTest(scenario.getName());
		ExtentTestManager.logInfo("<b>"+"Excution of Scenario: "+scenario.getName()+" started </b>");
		SetUp.setUpFramework();
	}
	
	@After
	public void afterScenario(Scenario scenario)
	{
		System.out.println("This method executed After " +scenario.getName());
		if(scenario.isFailed())
		{
			ExtentTestManager.logFail("This Scenario got failed");
		}
		else
		{
			ExtentTestManager.logPass("This Scenrio got passed");
		}
		
		ExtentTestManager.extent.flush();
		
		//scenario.
	}

}
