package com.lao.hooks;

import java.util.concurrent.TimeUnit;

import com.lao.DriverManager.DriverManager;
import com.lao.commonutils.CommonUtils;
import com.lao.commonutils.Constants;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;

public class Hooks {

	private static final org.apache.logging.log4j.Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger(Hooks.class);
	private static String scenarioName = null;
	
	public static String getScenarioName() {
		return scenarioName;
	}

	@Before
	public void beforeScenario(Scenario scenario) {
		scenarioName = scenario.getName();
		CommonUtils.getInstance().loadProperties();
		if(DriverManager.getDriver() == null) {
			DriverManager.getInstance().launchBrowser();
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		System.out.println("Thanos collecting the infinity stones "+Constants.APPLICATION_URL);
		LOGGER.info("Welcome to cucumber automation");
	}

	@AfterStep
	public void getScenarioNames(Scenario scenario) {
		if(scenario.isFailed()) {
			CommonUtils.getInstance().takesScreenshots(scenarioName);
		}
	}
	@After
	public void afterScenario() {
		System.out.println("After kiling everyone, taking rest on garden "+Constants.LAUNCH_BROWSER);
		//DriverManager.getDriver().close();
	}
}
