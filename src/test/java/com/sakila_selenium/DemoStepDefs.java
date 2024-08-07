package com.sakila_selenium;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class DemoStepDefs {

    WebDriver driver;

    @Given("the driver is {string}")
    public void theDriverIs(String arg0) {

    }

    @Given("the page {string} is loaded")
    public void thePageIsLoaded(String arg0) {

    }

    @When("the user selects the {string} input")
    public void theUserSelectsTheInput(String arg0) {
    }

    @And("types {string}")
    public void types(String arg0) {
    }

    @And("submits the form")
    public void submitsTheForm() {
    }

    @Then("the URL should be {string}")
    public void theURLShouldBe(String arg0) {
    }

    @And("the film details should be displayed")
    public void theFilmDetailsShouldBeDisplayed() {
    }



}
