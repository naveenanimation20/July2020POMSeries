package com.qa.hubspot.util;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	Properties prop;
	ChromeOptions co;
	FirefoxOptions fo;

	
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	
	
	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		if(prop.getProperty("headless").trim().equals("true")) co.addArguments("--headless");
		if(prop.getProperty("incognito").trim().equals("true")) co.addArguments("--incognito");
		
		return co;
	}
	
	public FirefoxOptions getFirfoxOptions() {
		fo = new FirefoxOptions();
		if(prop.getProperty("headless").trim().equals("true")) fo.addArguments("--headless");
		if(prop.getProperty("incognito").trim().equals("true")) fo.addArguments("--incognito");
		
		return fo;
	}
	
	

}
