package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.listeners.TestAllureListener;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("EPIC 100: Design Login Page Feature for Hub Spot Application")
@Feature("US 101: Design Login Page module with title, sign up and login form")
@Listeners(TestAllureListener.class)
public class LoginPageTest extends BaseTest{

	@Description("verify Login Page Title Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void verifyLoginPageTitleTest() {
		String titleLoginPage = loginPage.getLoginPageTitle();
		System.out.println("login page title is: " + titleLoginPage);
		Assert.assertEquals(titleLoginPage, Constants.LOGIN_PAGE_TITLE, Constants.LOGIN_TITLE_ERROR_MESSG);
	}

	@Description("verify Sign up link Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.isSignUpLinkExist(), Constants.SIGNUP_LINK_ERROR_MESSG);
	}

	@Description("Hub Spot Login Form Test")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 3)
	public void loginTest() {
		HomePage homePage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		String title = homePage.getHomePageTitle();
		System.out.println("home page title is : " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}

}
