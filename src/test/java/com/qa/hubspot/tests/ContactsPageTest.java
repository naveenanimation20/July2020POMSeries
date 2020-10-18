package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ExcelUtil;

public class ContactsPageTest extends BaseTest {

	@BeforeClass
	public void homePageSetup() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.gotoContactsPage();
	}

	@Test(priority = 2)
	public void verifyContactsPageTitleTest() {
		String title = contactsPage.getConatctsPageTitle();
		System.out.println("contacts page title is: " + title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE, Constants.CONTACTS_TITLE_ERROR_MESSG);
	}

	@Test(priority = 1)
	public void verifyContactsPageHeaderTest() {
		String header = contactsPage.getContactsPageHeaderValue();
		System.out.println("contacts page header is : " + header);
		Assert.assertEquals(header, Constants.CONTACTS_PAGE_HEADER);
	}

	@DataProvider
	public Object[][] getContactsTestData() {
		Object data[][] = ExcelUtil.getTestData(Constants.CONTACTS_SHEET_NAME);
		return data;
	}

	@Test(priority = 3, dataProvider = "getContactsTestData")
	public void createContactTest(String emailId, String firstName, String lastName, String jobTitle) {
		contactsPage.createContact(emailId, firstName, lastName, jobTitle);
	}

}
