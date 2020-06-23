package com.nci.coviddash.automation.steps.impl;

import org.openqa.selenium.WebDriver;

import com.nci.automation.local.utils.PageInitializer;
import com.nci.automation.utils.MiscUtils;
import com.nci.automation.web.CommonUtils;
import com.nci.automation.web.EnvUtils;
import com.nci.automation.web.WebDriverUtils;
import com.nci.automation.xceptions.TestingException;

public class ITrustLoginPageImpl extends PageInitializer{

	public static WebDriver driver=null;
	
	public void loginToITrust() throws TestingException {
		driver = WebDriverUtils.getWebDriver();
		driver.get(EnvUtils.getApplicationUrl());
		dashPage.clickITrustRedirectButton();
		MiscUtils.sleep(2000);
		login.enterUsername();
		login.enterPassword();
		login.clickSignInButton();
	}	
	

}
