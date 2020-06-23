package com.nci.coviddash.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nci.automation.web.WebDriverUtils;

public class DashboardPage {

	// add xpaths
	
	
	@FindBy(xpath = "//button[@ng-click='c.login()']")
	private WebElement iTrustRedirectForLogin;
	
	@FindBy(xpath = "//span[@class='select2-arrow']")
	public WebElement principalInvestigatorDD;

	@FindBy(xpath = "//input[@id='s2id_autogen2_search']")
	public WebElement principalInvestigatorSearchBox;
	
	@FindBy(xpath = "//input[@id='institution']")
	public WebElement instituteField;
	
	

	// initialize all variables
	public DashboardPage() {
		PageFactory.initElements(WebDriverUtils.getWebDriver(), this);
	}
	
	/**
	 * This method will direct you to ITrust and login and redirect 
	 * to covid19 dashboard page
	 */
	public void clickITrustRedirectButton() {
		iTrustRedirectForLogin.click();
	}

}
