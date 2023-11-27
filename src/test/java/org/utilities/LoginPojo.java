package org.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.stepdefinition.LoginStepDefinition;

public class LoginPojo extends LoginStepDefinition {
public LoginPojo() {
	PageFactory.initElements(driver, this);
}

@FindBy(id="email")
private WebElement email;
@FindBy(id="pass")
private WebElement password;
@FindBy(xpath = "//button[@type='submit']")
private WebElement button;
public WebElement getButton() {
	return button;
}
public WebElement getEmail() {
	return email;
}
public WebElement getPassword() {
	return password;
}



}
