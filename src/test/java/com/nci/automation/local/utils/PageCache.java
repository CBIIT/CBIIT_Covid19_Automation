package com.nci.automation.local.utils;


import com.nci.coviddash.automation.steps.impl.ITrustLoginPageImpl;


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
	//add implementation class object here
	private ITrustLoginPageImpl loginPageImpl;
	
	
	
	public ITrustLoginPageImpl getITrustLoginPageImpl() {
		if (loginPageImpl == null)
			loginPageImpl = new ITrustLoginPageImpl();
		return loginPageImpl;
	}

	

}
