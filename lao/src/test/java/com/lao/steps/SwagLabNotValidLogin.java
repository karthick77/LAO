package com.lao.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.lao.DriverManager.DriverManager;
import com.lao.PageObjects.HomePage;
import com.lao.commonutils.CommonUtils;

import cucumber.api.java.en.Then;

public class SwagLabNotValidLogin {

	private static final org.apache.logging.log4j.Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger(SwagLabNotValidLogin.class);
	
	WebDriver driver = DriverManager.getDriver();

	@Then("validate {string} message")
	public void validate_label(String error) {
		try {
			System.out.println("validate product label: " + error);
			CommonUtils.getInstance().highlightElements(driver.findElement(HomePage.getInstance().getErrorMSG()));
			String errorMewssage = driver.findElement(HomePage.getInstance().getErrorMSG()).getText();
			LOGGER.info("Error message validation success");
			Assert.assertTrue(errorMewssage.contains(error), "error is validate");	
		} catch (Exception e) {
            LOGGER.error(e.getMessage());
		}
		
	}
}
