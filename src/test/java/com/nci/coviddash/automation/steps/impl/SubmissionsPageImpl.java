package com.nci.coviddash.automation.steps.impl;

import java.util.List;

import org.openqa.selenium.WebElement;
import com.nci.automation.local.utils.PageCache;
import com.nci.automation.local.utils.PageInitializer;
import com.nci.automation.utils.MiscUtils;
import com.nci.automation.xceptions.TestingException;


public class SubmissionsPageImpl extends PageInitializer {
	
	private static PageCache pageCache = PageCache.getInstance();

	
	public void findIbrNumberAndclickRejectButton(String ExptdIbrNumber) {
		List<WebElement> ibrList = submissionPage.getPendingApprovalIBRNumbersList();
		for (int i = 0; i < ibrList.size(); i++) {
			String actualIbrNumber = ibrList.get(i).getText().trim();
			System.err.println("Actual IBR: "+actualIbrNumber);
			
			if (actualIbrNumber.equals(ExptdIbrNumber)) {
				MiscUtils.sleep(2000);
				submissionPage.getRejectButtonsList().get(i).click();
				MiscUtils.sleep(1000);
				submissionPage.enterRejecttionReasonClickConfirm();
				break;
			}else {
				MiscUtils.sleep(1000);
				submissionPage.clickPendingApprovalNextButton();
			}
		}

	}
	
	public void rejectStudyUsingIbrNumber(String approver, String ibrNumber) throws TestingException {
		pageCache.getNativeViewDashboardPageImpl().impersonateUser(approver);
		MiscUtils.sleep(2000);
		pageCache.getSubmissionsPageImpl().findIbrNumberAndclickRejectButton(ibrNumber);
	}

}
