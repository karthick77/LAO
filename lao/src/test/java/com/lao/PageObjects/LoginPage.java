package com.lao.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lao.DriverManager.DriverManager;
import com.lao.commonutils.CommonUtils;

public class LoginPage {

	private By UserName = By.xpath("//input[@id='user-name']");
	private By Password = By.xpath("//input[@id='password']");
	private By LoginButton = By.xpath("//input[@id='login-button']");

	private static LoginPage instance;
	
	WebDriver driver = DriverManager.getDriver();

	private LoginPage() {

	}

	public static LoginPage getInstance() {
		if (instance == null) {
			instance = new LoginPage();
		}
		return instance;
	}

	public By getUserName() {
		CommonUtils.getInstance().highlightElements(driver.findElement(UserName));
		return UserName;
	}

	public By getPassword() {
		CommonUtils.getInstance().highlightElements(driver.findElement(Password));
		return Password;
	}

	public By getLoginButton() {
		CommonUtils.getInstance().highlightElements(driver.findElement(LoginButton));
		return LoginButton;
	}

}
