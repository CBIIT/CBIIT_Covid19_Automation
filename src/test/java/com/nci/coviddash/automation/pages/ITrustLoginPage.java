package com.nci.coviddash.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nci.automation.web.CommonUtils;
import com.nci.automation.web.EnvUtils;
import com.nci.automation.web.WebDriverUtils;
import com.nci.automation.xceptions.TestingException;

public class ITrustLoginPage extends CommonUtils{

	
	@FindBy(xpath = "//input[@id='USER']")
	private WebElement userNameField;

	@FindBy(xpath = "//input[@id='PASSWORD']")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signInButton;
	
	@FindBy(xpath="//a[@class='forgot-password']")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath="//a[text()='Trouble signing in?']")
	private WebElement TroubleSigningInLink;
	
	

	// initialize all variables
	public ITrustLoginPage() {
		PageFactory.initElements(WebDriverUtils.getWebDriver(), this);
	}
	
	/**
	 * Enters user-name to ITrust
	 * @throws TestingException
	 */
	public void enterUsername() throws TestingException {
		userNameField.clear();
		sendKeys(userNameField, EnvUtils.getUserName("regular"));
	}
	
	/**
	 * Enters password to ITrust
	 * @throws TestingException
	 */
	public void enterPassword() throws TestingException {
		passwordField.clear();
		sendKeys(passwordField, EnvUtils.getPassword("regular"));
	}
	
	/**
	 * Clicks ITrust sign-in button
	 */
	public void clickSignInButton(){
		signInButton.click();
	}
	
}
