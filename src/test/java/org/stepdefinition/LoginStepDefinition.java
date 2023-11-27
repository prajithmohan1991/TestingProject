package org.stepdefinition;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.utilities.Baseclass;
import org.utilities.LoginPojo;

import io.cucumber.java.en.*;

public class LoginStepDefinition extends Baseclass {
	@Given("user should launch the chrome browser and load the url")
	public void user_should_launch_the_chrome_browser_and_load_the_url() throws AWTException {
		launchChrome();
		loadUrl("https://www.facebook.com");
		winMax();

	}

	@When("user should input the invalid username and invalid password in the textbox")
	public void user_should_input_the_invalid_username_and_invalid_password_in_the_textbox() {
		LoginPojo l = new LoginPojo();
		WebElement email = l.getEmail();
		WebElement password = l.getPassword();
		fill(email, "prajith");
		fill(password, "prajith@123");

	}

	@When("user should click the login button")
	public void user_should_click_the_login_button() {
		LoginPojo l = new LoginPojo();

		WebElement button = l.getButton();
		btnClick(button);
	}

	@Then("user should navigate to incorrect credential page")
	public void user_should_navigate_to_incorrect_credential_page() {

	}

}
