package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	//1. Page Locators: By locators
	
	By emailId = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	//2. Create the constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//3. page actions/page methods
	@Step("getting login page title....")
	public String getLoginPageTitle() {
		return elementUtil.waitForPageTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}
	
	@Step("checking sign up link on the login page....")
	public boolean isSignUpLinkExist() {
		return elementUtil.doIsDisplayed(signUpLink);
	}
	
	@Step("login with : {0} and {1}")
	public HomePage doLogin(String username, String pwd) {
		System.out.println("login with : " + username + " : " + pwd);
		elementUtil.doSendKeys(emailId, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return new HomePage(driver);
	}
	
}
