package com.lao.steps;

import org.openqa.selenium.WebDriver;

import com.lao.DriverManager.DriverManager;
import com.lao.commonutils.Constants;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AvengersEndGame {

	WebDriver driver = DriverManager.getDriver();
	
	@Given("Avengers has the infinity stones")
	public void avengers_has_the_infinity_stones() {
	   System.out.println("Avengers has the infinity stones");
	   driver.get(Constants.APPLICATION_URL);
	}

	@When("engers snaps his fingures")
	public void engers_snaps_his_fingures() {
	    System.out.println("Aengers snaps his fingures");
	}

	@Then("Half of the living things comes back")
	public void half_of_the_living_things_comes_back() {
	    System.out.println("Half of the living things comes back ");
	    
	}
}
