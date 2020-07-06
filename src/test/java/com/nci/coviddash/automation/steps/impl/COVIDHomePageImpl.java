package com.nci.coviddash.automation.steps.impl;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.nci.automation.local.utils.COVIDConstants;
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


	final static String covid = "covid-19-dashboard";
	final static String attName = "value";

	public void navigateToCOVIDDashLoginPage() throws TestingException {
		WebDriverUtils.webDriver.get(EnvUtils.getApplicationUrl());
	}

	public void clickOnLoginToAccessBtn() {
		covidHomePage.clickITrustRedirectButton();
	}

	public void verifyUserLoggedIn() {
		Assert.assertTrue(WebDriverUtils.webDriver.getCurrentUrl().contains(covid));
		CucumberLogUtils.logScreenShot();
	}

	public void loginToCovidDashboard() throws TestingException {
		WebDriverUtils.webDriver.get(EnvUtils.getApplicationUrl());
		MiscUtils.sleep(2000);
		covidHomePage.clickITrustRedirectButton();
		MiscUtils.sleep(2060);
		iTrustloginPage.enterUsername();
		iTrustloginPage.enterPassword();
		iTrustloginPage.clickSignInButton();
		MiscUtils.sleep(1000);
	}

	public void verifyFieldsAreDiabled() {
		Assert.assertFalse(covidHomePage.instituteField().isEnabled());
		Assert.assertFalse(covidHomePage.divisionField().isEnabled());
		Assert.assertFalse(covidHomePage.emailAddressField().isEnabled());
		Assert.assertFalse(covidHomePage.phonNumberField().isEnabled());
		CucumberLogUtils.logScreenShot();
	}

	public void enterInvestigatorName(String investgatorName) {
		covidHomePage.searchPrincipalInvestigator(investgatorName);
	}

	public void checkFieldsAutoPubulated(String inst, String dvsn, String piEml, String piPhn) {
		Assert.assertEquals(inst, covidHomePage.instituteField().getAttribute(attName));
		Assert.assertEquals(dvsn, covidHomePage.divisionField().getAttribute(attName));
		Assert.assertEquals(piEml, covidHomePage.emailAddressField().getAttribute(attName).substring(11));
		Assert.assertEquals(piPhn, covidHomePage.phonNumberField().getAttribute(attName));
		CucumberLogUtils.logScreenShot();
	}

	public void submitButtonIsDisbaled() {
		Assert.assertFalse(covidHomePage.submitButton().isEnabled());
	}

	public void clickSubmitButton() {
		JavascriptUtils.clickByJS(covidHomePage.submitButton());
	}

	public void selectBiospaecimenTypeOtherAndEnterOther(String other, String otherTypeValue) {
		JavascriptUtils.scrollDown(20000);
		covidHomePage.clickBiospaecimenTypeDdDD();
		for (WebElement ele : covidHomePage.biospaecimenTypeDdValues()) {
			if (ele.getText().trim().equals(other)) {
				JavascriptUtils.clickByJS(ele);
				break;
			}
		}
		covidHomePage.clickBiospaecimenTypeDdDD();
		covidHomePage.enterOtherBiospecimentType(otherTypeValue);
	}

	public void submittingFormWithoutDocumentation() {
		covidHomePage.searchPrincipalInvestigator("Diego Juarez");
		covidHomePage.enterIBRProtocolNumber("Automation Test");
		covidHomePage.enterStudyTitle("Automation Test");
		pageCache.getCOVIDHomePageImpl().selectBiospaecimenTypeOtherAndEnterOther("Other", covid);
		covidHomePage.selectCollectionFrequency();
		covidHomePage.enterStudySpecificAim("Avoid reocurrance");
		covidHomePage.clickSubmitAndConfirmSubButton();
	}

	public void verifyHomePageVerbiage(String verbage) {
		String actualVerbage = covidHomePage.getHomePageVerbiageText().replaceAll("\\s", "");
		String expectedVerbage=verbage.replaceAll("\\s", "");
		Assert.assertTrue(actualVerbage.equals(expectedVerbage));
	}
	
	public void successfullFormSubmission(String PIName, String IRBProtocolNumber, String StudyTitle, String StudySpecificAim ) {
		pageCache.getCOVIDHomePageImpl().enterInvestigatorName(PIName);
		covidHomePage.enterIBRProtocolNumber(IRBProtocolNumber);
		covidHomePage.enterStudyTitle(StudyTitle);
		pageCache.getCOVIDHomePageImpl().selectBiospaecimenTypeOtherAndEnterOther("Other", "Automation Test");
		covidHomePage.selectCollectionFrequency();
		covidHomePage.enterStudySpecificAim(StudySpecificAim);
		covidHomePage.attachStudyDocument();
		covidHomePage.clickSubmitAndConfirmSubButton();
	}
	
	public void attachingMultipleURLs() {
		JavascriptUtils.clickByJS(pageCache.getCOVIDHomePage().urlButton());
		MiscUtils.sleep(1000);
		pageCache.getCOVIDHomePage().urlField().sendKeys(COVIDConstants.GOOGLE_URL);
		JavascriptUtils.clickByJS(covidHomePage.urlAddButton());
		covidHomePage.urlField().sendKeys(COVIDConstants.GOOGLE_URL);
		JavascriptUtils.clickByJS(covidHomePage.urlAddButton());
		covidHomePage.urlField().sendKeys(COVIDConstants.GOOGLE_URL);
		JavascriptUtils.clickByJS(covidHomePage.urlAddButton());
		covidHomePage.urlField().sendKeys(COVIDConstants.GOOGLE_URL);
		JavascriptUtils.clickByJS(covidHomePage.urlAddButton());
		JavascriptUtils.clickByJS(covidHomePage.urlSaveButton());	
		boolean addedURL = covidHomePage.addedUrlLink().getText().contains(COVIDConstants.GOOGLE_URL);
		Assert.assertTrue(addedURL);
		
	}

}
