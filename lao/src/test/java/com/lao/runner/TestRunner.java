package com.lao.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src\\test\\resources\\features"},
		glue = {"com.lao.steps","com.lao.hooks"},
		dryRun = false,
		monochrome = true,
		tags = {"@regression"},
		plugin = {"rerun:target/failed_scenario.txt",
				  "pretty",
				  "html:target/myreports/report.html",
				  "json:target/myreports/report.json",
				  "junit:target/myreports/report.xml",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		snippets = SnippetType.CAMELCASE
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
