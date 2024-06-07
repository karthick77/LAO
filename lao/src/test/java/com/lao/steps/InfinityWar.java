package com.lao.steps;

import org.openqa.selenium.WebDriver;

import com.lao.DriverManager.DriverManager;
import com.lao.commonutils.Constants;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InfinityWar {

	WebDriver driver = DriverManager.getDriver();
	
	@Given("Thanos has the infinity stones")
	public void thanos_has_the_infinity_stones() {
	   System.out.println("Thanos has the infinity stones");
	   driver.get(Constants.APPLICATION_URL_2);
	   
	}

	@When("Thanos snaps his fingures")
	public void thanos_snaps_his_fingures() {
	    System.out.println("Thanos snaps his fingures");
	}

	@Then("Half of the living things died")
	public void half_of_the_living_things_died() {
	    System.out.println("Half of the living things died");
	    
	}
}
