package com.nci.automation.local.utils;

import com.nci.coviddash.automation.pages.DashboardPage;
import com.nci.coviddash.automation.pages.ITrustLoginPage;
import com.nci.coviddash.automation.steps.impl.ITrustLoginPageImpl;

/**
 * This an initializer class which will initialize all pages classes.
 * Once pages class created, create an object it here inside the constructor
 */
public class PageInitializer { 

	// declare protected static variables of types of all the pages
	protected static ITrustLoginPage login;
	protected static ITrustLoginPageImpl loginImpl;
	protected static DashboardPage dashPage;
	
	
	public static void initializeAllPages() {
		// create instances of all pages and assign them to the variables
		 login = new ITrustLoginPage();
		 loginImpl=new ITrustLoginPageImpl();
		 dashPage = new DashboardPage();
	}
	
}
