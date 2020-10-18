package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;


public class ContactsPage extends BasePage{
	
	ElementUtil elementUtil;
	private WebDriver driver;
	
	private By header = By.cssSelector("span.private-dropdown__item__label");
	private By createContactPrimary = By.xpath("//span[text()='Create contact']");
	private By emailId = By.xpath("//input[@data-field='email']");
	private By firstName = By.xpath("//input[@data-field='firstname']");
	private By lastName = By.xpath("//input[@data-field='lastname']");
	private By jobTitle = By.xpath("//textarea[@data-field='jobtitle']");
	private By createContactSecondary = By.xpath("(//span[text()='Create contact'])[position()=2]");
	private By contactsBackLink = By.xpath("(//*[text()='Contacts'])[position()=2]");
	
	
	public ContactsPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}
	
	public String getConatctsPageTitle() {
		return elementUtil.waitForPageTitlePresent(Constants.CONTACTS_PAGE_TITLE, 10);
	}
	
	public String getContactsPageHeaderValue() {
		return elementUtil.doGetText(header);
	}
	
	public void createContact(String emailId, String firstName, String lastName, String jobTitle) {
		
		elementUtil.waitForElementToBeLocated(createContactPrimary, 10);
		elementUtil.doClick(createContactPrimary);
		
		elementUtil.waitForElementToBeLocated(this.emailId, 5);
		elementUtil.doSendKeys(this.emailId, emailId);
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);

		elementUtil.waitForElementToBeVisible(this.jobTitle, 5);
		elementUtil.doSendKeys(this.jobTitle, jobTitle);
		
		elementUtil.clickWhenReady(createContactSecondary, 5);
		
		elementUtil.clickWhenReady(contactsBackLink, 10);
		
	}

}
