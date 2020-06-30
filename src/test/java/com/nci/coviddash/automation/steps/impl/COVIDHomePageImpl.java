package com.nci.coviddash.automation.steps.impl;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
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

	public void submittingFormWithoutDocumentation() {
		dashPage.searchPrincipalInvestigator("Diego Juarez");
		pageCache.getCOVIDHomePage().enterIBRProtocolNumber("Automation Test");
		pageCache.getCOVIDHomePage().enterStudyTitle("Automation Test");
		pageCache.getCOVIDHomePageImpl().selectBiospaecimenTypeOtherAndEnterOther("Other", "Automation Test");
		pageCache.getCOVIDHomePage().selectCollectionFrequency();
		pageCache.getCOVIDHomePage().enterStudySpecificAim("Automation Test");
		pageCache.getCOVIDHomePage().clickSubmitAndConfirmSubButton();
	}

	public void verifyingHomePageVerbiage() {

		String homePageVeribiage = pageCache.getCOVIDHomePage().homePageVerbiage().getText();
		Assert.assertTrue(homePageVeribiage.contains(
				"The COVID-19 Biorepository is available to all Intramural Research Program (IRP) Investigators with an IRB approved COVID-19 related study. This biorepository will serve two primary functions:"));
		Assert.assertTrue(homePageVeribiage.contains(
				"1. Storage for biospecimens collected as part of an IRP IRB approved COVID-19 protocol in the NCI-Frederick Central Repository"));
		Assert.assertTrue(homePageVeribiage.contains(
				"2. Provide a catalogue of COVID-related studies with biospecimens to facilitate COVID-19 research for the wider scientific community"));
		Assert.assertTrue(homePageVeribiage.contains(
				"To ship and store biospecimens in the NCI-Frederick Repository, please complete the form to the left.\n"
						+ "All fields are required. The IRB approved protocol must be submitted and please include any other supporting documentation. Your request will be reviewed within 2 business days (as feasible). If approved, you will be contacted with instructions on how to proceed with the transfer of your specimens with a manifest to the Repository."));
		Assert.assertTrue(homePageVeribiage
				.contains("If you have any questions, please contact Mandy Black blacka@mail.nih.gov."));
		Assert.assertTrue(homePageVeribiage.contains("Thank you for your interest in the COVID-19 Biorepository"));
		System.out.println(homePageVeribiage);
	}
	
	public void successfullFormSubmission(String PIName, String IRBProtocolNumber, String StudyTitle, String StudySpecificAim ) {
		pageCache.getCOVIDHomePageImpl().enterInvestigatorName(PIName);
		pageCache.getCOVIDHomePage().enterIBRProtocolNumber(IRBProtocolNumber);
		pageCache.getCOVIDHomePage().enterStudyTitle(StudyTitle);
		pageCache.getCOVIDHomePageImpl().selectBiospaecimenTypeOtherAndEnterOther("Other", "Automation Test");
		pageCache.getCOVIDHomePage().selectCollectionFrequency();
		pageCache.getCOVIDHomePage().enterStudySpecificAim(StudySpecificAim);
		pageCache.getCOVIDHomePage().attachStudyDocument();
		pageCache.getCOVIDHomePage().clickSubmitAndConfirmSubButton();
	}
	
	public void attachingMultipleURLs() {
		JavascriptUtils.clickByJS(pageCache.getCOVIDHomePage().urlButton());
		MiscUtils.sleep(1000);
		pageCache.getCOVIDHomePage().urlField().sendKeys(COVIDConstants.GOOGLE_URL);
		JavascriptUtils.clickByJS(pageCache.getCOVIDHomePage().urlAddButton());
		pageCache.getCOVIDHomePage().urlField().sendKeys(COVIDConstants.GOOGLE_URL);
		JavascriptUtils.clickByJS(pageCache.getCOVIDHomePage().urlAddButton());
		pageCache.getCOVIDHomePage().urlField().sendKeys(COVIDConstants.GOOGLE_URL);
		JavascriptUtils.clickByJS(pageCache.getCOVIDHomePage().urlAddButton());
		pageCache.getCOVIDHomePage().urlField().sendKeys(COVIDConstants.GOOGLE_URL);
		JavascriptUtils.clickByJS(pageCache.getCOVIDHomePage().urlAddButton());
		JavascriptUtils.clickByJS(pageCache.getCOVIDHomePage().urlSaveButton());	
		boolean addedURL = pageCache.getCOVIDHomePage().addedUrlLink().getText().contains(COVIDConstants.GOOGLE_URL);
		Assert.assertTrue(addedURL);
		
	}

}
