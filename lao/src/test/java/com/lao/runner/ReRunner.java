package com.lao.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"@target/failed_scenario.txt"},
		glue = {"com.lao.steps","com.lao.hooks"},
		dryRun = false,
		monochrome = true,
		tags = {"@regression and @dropdown"}
		)
public class ReRunner extends AbstractTestNGCucumberTests{

}
