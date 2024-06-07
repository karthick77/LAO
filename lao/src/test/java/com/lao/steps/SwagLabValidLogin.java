package com.lao.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.lao.DriverManager.DriverManager;
import com.lao.PageObjects.HomePage;
import com.lao.PageObjects.LoginPage;
import com.lao.commonutils.Constants;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SwagLabValidLogin {

	private static final org.apache.logging.log4j.Logger LOGGER = org.apache.logging.log4j.LogManager
			.getLogger(SwagLabValidLogin.class);

	WebDriver driver = DriverManager.getDriver();

	@Given("user is on login page")
	public void thanos_has_the_infinity_stones() {
		try {
			System.out.println("Thanos has the infinity stones");
			driver.get(Constants.APPLICATION_URL_2);
			LOGGER.info("URL LOGIN");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@When("user enters {string} and {string}")
	public void thanos_snaps_his_fingures(String username, String password) {
		try {
			System.out.println("user enters username: " + username + " and password: " + password);
			driver.findElement(LoginPage.getInstance().getUserName()).sendKeys(username);
			driver.findElement(LoginPage.getInstance().getPassword()).sendKeys(password);
			LOGGER.info("User Name and Password entered");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			try {
				WebDriverWait wait = new WebDriverWait(driver, 15);
				wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.getInstance().getUserName()));
			} catch (Exception e2) {
				LOGGER.error(e2.getMessage());
			}
		}
	}

	@When("user clicks the login button")
	public void user_enters_and() {
		try {
			System.out.println("user clicks the login button");
			driver.findElement(LoginPage.getInstance().getLoginButton()).click();
			LOGGER.info("Login button clicked");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			try {
				WebDriverWait wait = new WebDriverWait(driver, 15);
				wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.getInstance().getLoginButton()));
			} catch (Exception e2) {
				LOGGER.error(e2.getMessage());
			}
		}
	}

	@Then("validate {string} label")
	public void validate_label(String label) {
		try {
			System.out.println("validate product label: " + label);
			String productLabel = driver.findElement(HomePage.getInstance().getProductLabel()).getText();
			LOGGER.info("Label validation");
			Assert.assertEquals(productLabel, "Products");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			try {
				WebDriverWait wait = new WebDriverWait(driver, 15);
				wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.getInstance().getProductLabel()));
			} catch (Exception e2) {
				LOGGER.error(e2.getMessage());
			}
		}
	}

	@Then("logout from application successfully")
	public void logout_from_application_successfully() throws InterruptedException {
		try {
			System.out.println("logout from application successfully");
			driver.findElement(HomePage.getInstance().getMenu()).click();
			Thread.sleep(3000);
			driver.findElement(HomePage.getInstance().getLogout()).click();
			LOGGER.info("Logout Successfully");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			try {
				WebDriverWait wait = new WebDriverWait(driver, 15);
				wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.getInstance().getMenu()));
			} catch (Exception e2) {
				LOGGER.error(e2.getMessage());
			}
		}

	}
}
