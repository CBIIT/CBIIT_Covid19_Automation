package com.nci.coviddash.automation.steps;

import com.nci.automation.local.utils.PageCache;
import com.nci.automation.xceptions.TestingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COVIDHomePageSteps {

	private static PageCache pageCache = PageCache.getInstance();

	@Given("User navigates to the COVID{int} Biorepository login page")
	public void user_navigates_to_the_COVID_Biorepository_login_page(Integer int1) throws TestingException {
		pageCache.getCOVIDHomePageImpl().navigateToCOVIDDashLoginPage();
	}

	@When("the User clicls on Login to access button")
	public void the_User_clicls_on_Login_to_access_button() {
		pageCache.getCOVIDHomePageImpl().clickOnLoginToAccessBtn();
	}
	

	@When("the User is directed to the home page")
	public void the_User_is_directed_to_the_Submissions_home_page() {
		pageCache.getCOVIDHomePageImpl().verifyUserLoggedIn();
	}

	@Given("a User has logged in to the NIH COVID{int} Biorepository Dashboard Application")
	public void a_User_has_logged_in_to_the_NIH_COVID_Biorepository_Dashboard_Application(Integer int1) throws TestingException {
		pageCache.getCOVIDHomePageImpl().loginToCovidDashboard();
	}
	
	@Given("user validates that Institute, Division, Email Address, and Phone Number fields are not editable")
	public void user_validates_that_Institute_Division_Email_Address_and_Phone_Number_fields_are_not_editabel() {
		pageCache.getCOVIDHomePageImpl().verifyFieldsAreDiabled();
	}

	@When("the User selects a principal Investigator by typing their name in the principal Investigator search box. {string}")
	public void the_User_selects_a_Primary_Investigator_by_typing_their_name_in_the_Primary_Investigator_search_box(String piName) {
		pageCache.getCOVIDHomePageImpl().enterInvestigatorName(piName);
	}

	@Then("the Institute, Division, Email Address, and Phone Number fields are auto-populated. {string},{string},{string},{string}")
	public void the_Institute_Division_Email_Address_and_Phone_Number_fields_are_auto_populated(String inst, String dvsn, String piEml, String piPhn) {
		pageCache.getCOVIDHomePageImpl().checkFieldsAutoPubulated(inst, dvsn, piEml, piPhn);
	}

	@Given("the user verifies that the submit button is disbaled by default")
	public void the_user_verifies_that_the_submit_button_is_Disbaled() {
	 pageCache.getCOVIDHomePageImpl().submitButtonIsDisbaled();
	}

	@When("the User selects a Principal Investigator {string}")
	public void the_User_selects_a_Principal_Investigator(String investgatorName) {
	  pageCache.getCOVIDHomePageImpl().enterInvestigatorName(investgatorName);
	}

	@When("enters a unique IRB Protocol Number which can contain numbers and text such as {string}")
	public void enters_a_unique_IRB_Protocol_Number_which_can_contain_numbers_and_text_such_as(String ibrNumber) {
	  pageCache.getCOVIDHomePage().enterIBRProtocolNumber(ibrNumber);
	}

	@When("enters a Study Title as {string}")
	public void enters_a_Study_Title_as(String studyTitle) {
	   pageCache.getCOVIDHomePage().enterStudyTitle(studyTitle);
	}

	@When("selects any Biospecimen Type {string} than enters Other type as {string}")
	public void selects_any_Biospecimen_Type_than_enters_Other_type_as(String selectOther, String otherTypeValue) {
	   pageCache.getCOVIDHomePageImpl().selectBiospaecimenTypeOtherAndEnterOther(selectOther, otherTypeValue);
	}

	@When("selects any Biospecimen Collection Frequency")
	public void selects_any_Biospecimen_Collection_Frequency() {
	   pageCache.getCOVIDHomePage().selectCollectionFrequency();
	}

	@When("verifies that {string} text is displayed in the Repository Location text box")
	public void verifies_that_text_is_displayed_in_the_Repository_Location_text_box(String repoLocation) {
	   pageCache.getCOVIDHomePage().verifiyRepositoryLocation(repoLocation);
	}

	@When("enters Study Specific Aims {string}")
	public void enters_Study_Specific_Aims(String aim) {
	   pageCache.getCOVIDHomePage().enterStudySpecificAim(aim);
	}

	@When("attaches an IRB Protocol Document")
	public void attaches_an_IRB_Protocol_Document() {
		pageCache.getCOVIDHomePage().attachStudyDocument();
	}

	@When("attaches a Related URL")
	public void attaches_a_Related_URL() throws TestingException {
		pageCache.getCOVIDHomePage().attachURL();
	}

	@Then("the User is able to successfully submit a study")
	public void the_User_is_able_to_successfully_submit_a_study() throws TestingException {
		pageCache.getCOVIDHomePage().clickSubmitAndConfirmSubButton();
		pageCache.getSubmissionsPageImpl().rejectStudyUsingIbrNumber("Sharon Savage", "65YUT55");
	}
	
	
	
	
}
