package com.nci.automation.local.utils;

import com.nci.automation.web.WebDriverUtils;
import com.nci.automation.xceptions.TestingException;

public class COVIDConstants {

	public static final String DOC_PATH = System.getProperty("user.dir")+"/src/test/resources/test-data/Study-Documentation.docx";

	public static final String TEST_URL = "teams.microsoft.com/l/file";
	
	public static final String GOOGLE_URL = "www.google.com/";
	
	public static String getExecutionEnv() throws TestingException {
		String env="";
		String url=WebDriverUtils.webDriver.getCurrentUrl();
		if(url.contains("test")) {
			env="Test";
		}else if(url.contains("acpt")) {
			env="Acceptance";
		}else if(url.contains("dev")) {
			env="Dev";
		}else if(url.contains("sandbox")) {
			env="SandBox";
		}
		env="Environment: "+env+" ("+url+")";
		return env;
	}

}
