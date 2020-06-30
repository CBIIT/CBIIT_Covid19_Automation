Feature: COVID Dashboard
  
  Description: This feature file tests COVIDDASH-7, 8, 20, 134, 135, 138, 136, 137, 142, 148

  @regression
  Scenario Outline: Validate Autopulation
    Given a User has logged in to the NIH COVID-19 Biorepository Dashboard Application
    And user validates that Institute, Division, Email Address, and Phone Number fields are not editable
    When the User selects a principal Investigator by typing their name in the principal Investigator search box. "<PI Name>"
    Then the Institute, Division, Email Address, and Phone Number fields are auto-populated. "<istitName>","<dvsnName>","<piEmail>","<piPhonNum>"
    Then user validates that Institute, Division, Email Address, and Phone Number fields are not editable

    Examples: 
      | PI Name      | istitName | dvsnName | piEmail  | piPhonNum  |
      | Sohil Zalmay | NCI       | OD       | @nih.gov | 2402766573 |

  @smoke @regression
  Scenario: Validate Study Submission
    Given a User has logged in to the NIH COVID-19 Biorepository Dashboard Application
    And the user verifies that the submit button is disbaled by default
    When the User selects a Principal Investigator "Sohil Zalmay"
    And enters a unique IRB Protocol Number which can contain numbers and text such as "65YUT55"
    And enters a Study Title as "COVID Study"
    And selects any Biospecimen Type "Other" and enters Other type as "tissue"
    And selects any Biospecimen Collection Frequency
    And verifies that "NCI Frederick" text is displayed in the Repository Location text box
    And enters Study Specific Aims "Prevent the development or recurrence of disease"
    And attaches an IRB Protocol Document
    And attaches a Related URL
    Then the User is able to successfully submit a study

  @smoke @regression
  Scenario: Validating Study Submission without attaching a Related URL
    Given a User has logged in to the NIH COVID-19 Biorepository Dashboard Application
    When the User selects a Principal Investigator "Diego Juarez"
    And enters a unique IRB Protocol Number which can contain numbers and text such as "65YUT55"
    And enters a Study Title as "Automation Test"
    And selects any Biospecimen Type "Other" and enters Other type as "Automation Test"
    And selects any Biospecimen Collection Frequency
    And verifies that "NCI Frederick" text is displayed in the Repository Location text box
    And enters Study Specific Aims "Test Automation"
    And attaches an IRB Protocol Document
    And does not attach a Related URL
    Then the User is able to successfully submit a study

  @smoke @regression
  Scenario: Validating Study Submission with attaching multiple Related URL's
    Given a User has logged in to the NIH COVID-19 Biorepository Dashboard Application
    When the User selects a Principal Investigator "Diego Juarez"
    And enters a unique IRB Protocol Number which can contain numbers and text such as "65YUT55"
    And enters a Study Title as "Automation Test"
    And selects any Biospecimen Type "Other" and enters Other type as "Automation Test"
    And selects any Biospecimen Collection Frequency
    And verifies that "NCI Frederick" text is displayed in the Repository Location text box
    And enters Study Specific Aims "Test Automation"
    And attaches an IRB Protocol Document
    And attaches multiple Related URL’s
    Then the User is able to successfully submit a study

  @progression
  Scenario: Verifying a user is not able to submit a study form when not attaching an IRB Protocol Document
    Given a User has logged in to the NIH COVID-19 Biorepository Dashboard Application
    When the User enters all required information
    But does not attach an IRB Protocol Document
    And attempts to confirm and submit the study form
    Then the user is not able to successfully submit the study form
    And sees a pop up with a message indicating study documentation is required before submitting
    And when selecting "Go Back"
    Then under Study Documentation the user sees the message " Study documentation is required. Please attach the appropriate file(s). "
