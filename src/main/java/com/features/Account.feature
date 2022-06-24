Feature: Account


 Background:Below are common steps for every scenario
  Given User launch chrome browser
  When User opens URL "https://ingecnotechnologies.com/Other/CRM/index.php/site/login"
  And User enters userName as "admin" and password as "pass"
  And click on Remember me 
  And double click on SignIn
  Then User can view Homepage
  
Scenario:Create an account
  When User move to Accounts menu 
  And click on create Account menu
  Then User can view create Account page
  When User enter client info
  And click on create button
  Then User can view Heading 
  And close browser
  
Scenario:verify List of Account names
  When User move to Accounts menu   
  And click on Lists
  Then User can view Account Lists page
  And verify List
  And close browser
 
Scenario:verify Heading after Report Generation
  When User move to Accounts menu
  And click on Accounts Report
  Then User can view Accounts Report Page
  When User enter Accounts Report info
  And click on Generate button
  Then User can view Heading of Report List
  And close browser
  
Scenario:verify Title of file after successful upload
  When User move to More menu and click on docs
  And click on upload file
  And click on Select files
  Then User can view uploaded file 
  And close browser
  
Scenario:verify Address2 and Description column after clicking checkbox
  When User move to Accounts menu and click on All Accounts
  And click on column icon
  And click on Address2 and Description
  Then User can view Address2 and Description column in Accounts table
  