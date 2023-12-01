package com.vsked.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginStep {


    @Given("User is on login")
    public void user_is_on_login() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("user prepare login ss1");
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("user name is admin user password is 123456");
    }

    @When("User enters username vsked")
    public void user_enters_username_vsked() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("user name is vsked");
    }

    @Then("User is navigated to Home page")
    public void user_is_navigated_to_home_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("login success let's go home page now");
    }

    @Then("Print good")
    public void print_good() {
        System.out.println("----------good----------");
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
}
