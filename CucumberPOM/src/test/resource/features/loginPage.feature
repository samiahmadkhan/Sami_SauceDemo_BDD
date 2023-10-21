
Feature: Test Login Page Functionality
  
  Scenario: Login with Standard Credentials
    Given User is on login page
    When User enters username and password
    | username      | password     |
    | standard_user | secret_sauce |
   