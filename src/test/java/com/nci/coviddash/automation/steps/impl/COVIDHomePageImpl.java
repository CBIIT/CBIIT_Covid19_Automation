package com.nci.coviddash.automation.steps.impl;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nci.automation.local.utils.PageCache;
import com.nci.automation.local.utils.PageInitializer;
import com.nci.automation.utils.CucumberLogUtils;
import com.nci.automation.utils.MiscUtils;
import com.nci.automation.web.EnvUtils;
import com.nci.automation.web.JavascriptUtils;
import com.nci.automation.web.WebDriverUtils;
import com.nci.automation.xceptions.TestingException;

public class COVIDHomePageImpl extends PageInitializer {

	private static PageCache pageCache = PageCache.getInstance();

	public static WebDriver driver = null;
	final static String covid = "covid-19-dashboard";
	final static String attName = "value";

	public void navigateToCOVIDDashLoginPage() throws TestingException {
		driver = WebDriverUtils.getWebDriver();
		driver.get(EnvUtils.getApplicationUrl());
	}

	public void clickOnLoginToAccessBtn() {
		dashPage.clickITrustRedirectButton();
	}

	public void verifyUserLoggedIn() {
		Assert.assertTrue(driver.getCurrentUrl().contains(covid));
		CucumberLogUtils.logScreenShot();
	}

	public void loginToCovidDashboard() throws TestingException {
		driver = WebDriverUtils.getWebDriver();
		driver.get(EnvUtils.getApplicationUrl());
		MiscUtils.sleep(2000);
		dashPage.clickITrustRedirectButton();
		MiscUtils.sleep(2060);
		login.enterUsername();
		login.enterPassword();
		login.clickSignInButton();
		MiscUtils.sleep(1000);
	}

	public void verifyFieldsAreDiabled() {
		Assert.assertFalse(dashPage.instituteField().isEnabled());
		Assert.assertFalse(dashPage.divisionField().isEnabled());
		Assert.assertFalse(dashPage.emailAddressField().isEnabled());
		Assert.assertFalse(dashPage.phonNumberField().isEnabled());
		CucumberLogUtils.logScreenShot();
	}

	public void enterInvestigatorName(String investgatorName) {
		dashPage.searchPrincipalInvestigator(investgatorName);
	}

	public void checkFieldsAutoPubulated(String inst, String dvsn, String piEml, String piPhn) {
		Assert.assertEquals(inst, dashPage.instituteField().getAttribute(attName));
		Assert.assertEquals(dvsn, dashPage.divisionField().getAttribute(attName));
		Assert.assertEquals(piEml, dashPage.emailAddressField().getAttribute(attName).substring(11));
		Assert.assertEquals(piPhn, dashPage.phonNumberField().getAttribute(attName));
		CucumberLogUtils.logScreenShot();
	}

	public void submitButtonIsDisbaled() {
		Assert.assertFalse(dashPage.submitButton().isEnabled());
	}

	public void clickSubmitButton() {
		JavascriptUtils.clickByJS(dashPage.submitButton());
	}

	public void selectBiospaecimenTypeOtherAndEnterOther(String other, String otherTypeValue) {
		JavascriptUtils.scrollDown(20000);
		dashPage.clickBiospaecimenTypeDdDD();
		for (WebElement ele : dashPage.biospaecimenTypeDdValues()) {
			if (ele.getText().trim().equals(other)) {
				JavascriptUtils.clickByJS(ele);
				break;
			}
		}
		dashPage.clickBiospaecimenTypeDdDD();
		dashPage.enterOtherBiospecimentType(otherTypeValue);
	}


}
