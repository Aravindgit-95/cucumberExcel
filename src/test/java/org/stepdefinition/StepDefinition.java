package org.stepdefinition;

import org.pom.LoginPojo;

import Utility.BaseClass;
import cucumber.api.java.en.*;

public class StepDefinition extends BaseClass {

	@Given("^User should be in the login page$")
	public void user_should_be_in_the_login_page() throws Throwable {
		LoginPojo o = LoginPojo.object();
		click(o.getLogin());

	}

	@When("^user enters the username and password$")
	public void user_enters_the_username_and_password() throws Throwable {
		LoginPojo o = LoginPojo.object();
		enter(o.getUser().get(2), data(1,0));
		Thread.sleep(2000);
		enter(o.getUser().get(3), data(1, 1));
		Thread.sleep(2000);

	}

	@Then("^user clicks the login button$")
	public void user_clicks_the_login_button() throws Throwable {
		LoginPojo o = LoginPojo.object();
		click(o.getButton());

	}

	@Given("^user in homepage view$")
	public void user_in_homepage_view() throws Throwable {
		System.out.println("User is in homepage");
	}

	@When("^user enters the products \"([^\"]*)\" in search box$")
	public void user_enters_the_products_in_search_box(String s1) throws Throwable {
		LoginPojo o = LoginPojo.object();
		enter(o.getSearch(), s1);
		LoginPojo.setObject();

	}

	@Then("^user clicks the go button$")
	public void user_clicks_the_go_button() throws Throwable {
		LoginPojo o = LoginPojo.object();
		click(o.getGo());
		LoginPojo.setObject();


	}

}
