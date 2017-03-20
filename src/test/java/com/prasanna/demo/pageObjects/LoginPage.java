package com.prasanna.demo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends UtilityPage {

	public LoginPage(WebDriver driv) {
		super(driv);
	}
	
	public By username = By.id("login1");
	public By password = By.id("password");
	public By loginBtn = By.name("proceed");
	
	public void fillLoginDetails(String UN, String PWD)
	{
		fillIn(username, UN);
		fillIn(password, PWD);
	}
	
	public void clickLoginBtn()
	{
		clickOn(loginBtn);
	}
}
