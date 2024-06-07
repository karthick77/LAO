package com.lao.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lao.DriverManager.DriverManager;
import com.lao.commonutils.CommonUtils;

public class HomePage {

	private By ProductLabel = By.xpath("//div[@class='product_label']");
    private By Menu = By.xpath("//button[contains(text(),'Open Menu')]");
    private By Logout = By.xpath("//a[@id='logout_sidebar_link']");
    private By ErrorMSG = By.xpath("//h3[@data-test='error']");
    private By Options = By.xpath("//select[@class='product_sort_container']");
    
	private static HomePage instance;
	
	WebDriver driver = DriverManager.getDriver();

	private HomePage() {

	}

	public static HomePage getInstance() {
		if (instance == null) {
			instance = new HomePage();
		}
		return instance;
	}

	public By getProductLabel() {
		CommonUtils.getInstance().highlightElements(driver.findElement(ProductLabel));
		return ProductLabel;
	}

	public By getMenu() {
		CommonUtils.getInstance().highlightElements(driver.findElement(Menu));
		return Menu;
	}

	public By getLogout() {
		CommonUtils.getInstance().highlightElements(driver.findElement(Logout));
		return Logout;
	}

	public By getErrorMSG() {
		CommonUtils.getInstance().highlightElements(driver.findElement(ErrorMSG));
		return ErrorMSG;
	}

	public By getOptions() {
		CommonUtils.getInstance().highlightElements(driver.findElement(Options));
		return Options;
	}


   	
}
