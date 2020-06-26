package com.nci.coviddash.automation.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nci.automation.web.CommonUtils;
import com.nci.automation.web.JavascriptUtils;
import com.nci.automation.web.WebDriverUtils;


public class SubmissionsPage extends CommonUtils{

	
	
	@FindBy(xpath = "//div[@class='content']/div[1]/div[@data-toggle='collapse']/div[3]")
	private List<WebElement> pendingApprovalStudiesTable;
	
	@FindBy(xpath = "//button[@id='reject-button']")
	private List<WebElement> rejectButtonsList;

	
	@FindBy(xpath = "//button[@ng-click='selectPendingStudiesPage(c.pendingStudiesCurrentPage + 1);']")
	private WebElement pendingAprovalNextButton;
	
	@FindBy(xpath = "//textarea[@name='justification']")
	private WebElement rejectSubmisnTextArea;
	
	@FindBy(xpath = "//button[text()='Reject Submission']")
	private WebElement rejectConfirmButton;
	

	// initialize all variables
	public SubmissionsPage() {
		PageFactory.initElements(WebDriverUtils.getWebDriver(), this);
	}
	
	public List<WebElement> getPendingApprovalIBRNumbersList() {
		return pendingApprovalStudiesTable;
	}
	
	public List<WebElement> getRejectButtonsList(){
		return rejectButtonsList;
	}
	
	public void clickPendingApprovalNextButton() {
		pendingAprovalNextButton.click();
	}
	
	public void enterRejecttionReasonClickConfirm() {
		rejectSubmisnTextArea.sendKeys("It was a test study");
		JavascriptUtils.clickByJS(rejectConfirmButton);
	}
	
	
	
	
}
