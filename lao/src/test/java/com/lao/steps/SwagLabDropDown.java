package com.lao.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lao.DriverManager.DriverManager;
import com.lao.PageObjects.HomePage;
import com.lao.commonutils.CommonUtils;

import cucumber.api.java.en.And;

public class SwagLabDropDown {

	private static final org.apache.logging.log4j.Logger LOGGER = org.apache.logging.log4j.LogManager
			.getLogger(SwagLabDropDown.class);

	WebDriver driver = DriverManager.getDriver();

	@And("user selects {string} from the dropdown as {string}")
	public void user_selects_from_the_as(String howTo, String value) {
		try {
			CommonUtils.getInstance().selectFromDropDown(driver.findElement(HomePage.getInstance().getOptions()), howTo, value);
			LOGGER.info("Drop Down");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			try {
				WebDriverWait wait = new WebDriverWait(driver, 15);
				wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.getInstance().getOptions()));
			} catch (Exception e2) {
              LOGGER.error(e.getMessage());
			}
		}
	}
}
