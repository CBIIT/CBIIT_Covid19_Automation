package com.nci.coviddash.automation.steps.impl;

import com.nci.automation.local.utils.PageCache;
import com.nci.automation.local.utils.PageInitializer;
import com.nci.automation.utils.MiscUtils;
import com.nci.automation.web.EnvUtils;
import com.nci.automation.web.WebDriverUtils;
import com.nci.automation.xceptions.TestingException;


public class NativeViewDashboardPageImpl extends PageInitializer {

	private static PageCache pageCache = PageCache.getInstance();


	public void impersonateUser(String approver) throws TestingException {
		WebDriverUtils.getWebDriver().get("https://service-test.nci.nih.gov/ncisp");
		MiscUtils.sleep(3000);
		pageCache.getNativeViewDashboardPage().clickNativeViewLink();
		MiscUtils.sleep(2000);
		pageCache.getNativeViewDashboardPage().clickUserDropDown();
		MiscUtils.sleep(500);
		pageCache.getNativeViewDashboardPage().clickImpersonateUserLink();
		MiscUtils.sleep(1000);
		pageCache.getNativeViewDashboardPage().clickImpersonateSearchDD();
		MiscUtils.sleep(1000);
		pageCache.getNativeViewDashboardPage().enterTextImpersntSearchBox(approver);
		MiscUtils.sleep(1000);	
		WebDriverUtils.getWebDriver().get(EnvUtils.getApplicationUrl());

	}
	
	
}
