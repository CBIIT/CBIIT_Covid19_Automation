package com.nci.automation.local.utils;


import com.nci.coviddash.automation.pages.COVIDHomePage;
import com.nci.coviddash.automation.pages.ITrustLoginPage;
import com.nci.coviddash.automation.pages.NativeViewDashboardPage;
import com.nci.coviddash.automation.pages.SubmissionsPage;
import com.nci.coviddash.automation.steps.impl.COVIDHomePageImpl;
import com.nci.coviddash.automation.steps.impl.ITrustLoginPageImpl;
import com.nci.coviddash.automation.steps.impl.NativeViewDashboardPageImpl;
import com.nci.coviddash.automation.steps.impl.SubmissionsPageImpl;


public class PageCache {

	private static ThreadLocal<PageCache> pageCache = new ThreadLocal<PageCache>();

	
	
	private PageCache() {
		// Private Constructor
	}

	public synchronized static PageCache getInstance() {
		if (pageCache.get() == null) {
			pageCache.set(new PageCache());
		}
		return pageCache.get();
	}

	// private pages variables
	private ITrustLoginPageImpl loginPageImpl;
	private COVIDHomePageImpl covidHomePageImpl;
	private SubmissionsPageImpl submissionPageImpl;
	private NativeViewDashboardPageImpl nativeViewDashImpl;
	
	//private Pages variable if any
	private COVIDHomePage covidHomePage;
	private ITrustLoginPage iTrustLoginPage;
	private NativeViewDashboardPage nativeViewDashPage;
	private SubmissionsPage submissionsPage;
	
	
	//add implementation class object bellow
	public ITrustLoginPageImpl getITrustLoginPageImpl() {
		if (loginPageImpl == null)
			loginPageImpl = new ITrustLoginPageImpl();
		return loginPageImpl;
	}
	
	
	public COVIDHomePageImpl getCOVIDHomePageImpl() {
		if (covidHomePageImpl == null)
			covidHomePageImpl = new COVIDHomePageImpl();
		return covidHomePageImpl;
	}
	
	
	public SubmissionsPageImpl getSubmissionsPageImpl() {
		if (submissionPageImpl == null)
			submissionPageImpl = new SubmissionsPageImpl();
		return submissionPageImpl;
	}
	
	
	public NativeViewDashboardPageImpl getNativeViewDashboardPageImpl() {
		if (nativeViewDashImpl == null)
			nativeViewDashImpl = new NativeViewDashboardPageImpl();
		return nativeViewDashImpl;
	}
	
	
	//Pages Object below
	public ITrustLoginPage getITrustLoginPage() {
		if (iTrustLoginPage == null)
			iTrustLoginPage = new ITrustLoginPage();
		return iTrustLoginPage;
	}
	

	public COVIDHomePage getCOVIDHomePage() {
		if (covidHomePage == null)
			covidHomePage = new COVIDHomePage();
		return covidHomePage;
	}
	
	
	public NativeViewDashboardPage getNativeViewDashboardPage() {
		if (nativeViewDashPage == null)
			nativeViewDashPage = new NativeViewDashboardPage();
		return nativeViewDashPage;
	}
	
	public SubmissionsPage getSubmissionsPage() {
		if (submissionsPage == null)
			submissionsPage = new SubmissionsPage();
		return submissionsPage;
	}
}
