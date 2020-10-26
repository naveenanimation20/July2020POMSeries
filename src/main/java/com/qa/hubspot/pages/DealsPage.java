package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class DealsPage extends BasePage {

	WebDriver driver;

	By deals = By.id("deals");

	public DealsPage(WebDriver driver) {
		System.out.println("deals page");
		driver = this.driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}

}
