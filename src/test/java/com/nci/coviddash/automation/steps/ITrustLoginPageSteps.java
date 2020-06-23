package com.nci.coviddash.automation.steps;

import com.nci.automation.local.utils.PageCache;
import com.nci.automation.local.utils.PageInitializer;
import com.nci.automation.xceptions.TestingException;
import cucumber.api.java.en.Given;


public class ITrustLoginPageSteps extends PageInitializer {
	
	private static PageCache pageCache=PageCache.getInstance();
	
	
	@Given("a user is on covid dashboard homepage")
	public void a_user_is_on_covid_dashboard_homepage() throws TestingException {
	  pageCache.getITrustLoginPageImpl().loginToITrust();
	}

}
