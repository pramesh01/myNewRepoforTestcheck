#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

 @Leads
  Feature: Managing Leaders
      creating and deleting the leads

    @Background : logged in to application
             Given i am logging into website https://zoho.com
             And i click on 'leads' tab on top menu
  
  @CreateLead
  Scenario Outline: creating the Leads
    When i goto 'create the lead' page
    And enter and submit the lead details
    And i goto 'lead details' page 
    Then i verify the lead details
    When i click on 'leads' tab on top menu
    And lead should be present inside the grid
    
     Examples: 
      | firstname  | lastname | emailid              | company  |
      | riyab      | jacobs   | rjacobs@hotmail.com  | microsoft|
      | james      | fernandis| jfernandis@gmail.com | infosys  |
  
  @DeleteLead
  Scenario Outline: deleting the leads
         When i select the lead
         And  i click on delete button
         Then lead should be deleted

    Examples: 
      | name  | company | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
