package com.lao.commonutils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.lao.DriverManager.DriverManager;
import com.lao.PageObjects.HomePage;
import com.lao.PageObjects.LoginPage;

public class CommonUtils {

	private static final org.apache.logging.log4j.Logger LOGGER = org.apache.logging.log4j.LogManager
			.getLogger(CommonUtils.class);

	private static CommonUtils instance;

	private CommonUtils() {

	}

	public static CommonUtils getInstance() {
		if (instance == null) {
			instance = new CommonUtils();
		}
		return instance;
	}

	public void loadProperties() {
		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Constants.APPLICATION_URL = (String) properties.get("APP_URL");
		System.out.println(Constants.APPLICATION_URL);
		Constants.APPLICATION_URL_2 = (String) properties.get("APP_URL2");
		System.out.println(Constants.APPLICATION_URL_2);
		Constants.LAUNCH_BROWSER = (String) properties.get("BROWSER");
		System.out.println(Constants.LAUNCH_BROWSER);
	}

	public void initElements() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getInstance());
	}

	public void takesScreenshots(String scenarioName) {

		File srcFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(srcFile, new File(scenarioName + ".png"));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	public void highlightElements(WebElement element) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
			jse.executeScript(
					"arguments[0].setAttribute('style','border:2px solid blue; background:yellow; color:green');",
					element);
			Thread.sleep(2000);
			jse.executeScript("arguments[0].setAttribute('style','border:; background:');", element);
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage());
		}

	}

	public void selectFromDropDown(WebElement dropDown, String howTo, String value) {
		try {
			
		    Select select = new Select(dropDown);
			switch (howTo) {
			case "index":
                select.selectByIndex(Integer.parseInt(value));
				break;
			case "value":
                select.selectByValue(value);
				break;
			case "text":
                select.selectByVisibleText(value);  
				break;
			default:
				LOGGER.info("Please provide valid selection");
				break;
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

}
