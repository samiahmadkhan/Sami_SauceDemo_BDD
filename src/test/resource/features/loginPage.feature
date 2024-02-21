
Feature: Test Login Page Functionality where that user is able to Login
  
  @positive @login
  Scenario Outline: Login with Standard Credentials
    Given User is on login page
    When User enters "<username>" and "<password>"
    Then User should land on Products Page
    
    Examples:
    | username                 | password     |
    | standard_user            | secret_sauce |
    | problem_user             | secret_sauce |
    | performance_glitch_user  | secret_sauce |
    
    @negative @login
  Scenario Outline: Login with Incorrect Credentials( Negative Case )
    Given User is on login page
    When User enters "<username>" and "<password>"
    Then User gets "<errorMessage>"
    
    Examples:
    | username          | password     | errorMessage |                      
    | locked_out_user   | secret_sauce | Epic sadface: Sorry, this user has been locked out. |
    |                   | secret_sauce | Epic sadface: Username is required |
    | standard_user     |              | Epic sadface: Password is required |
    | standard_user     |    xyz       | Epic sadface: Username and password do not match any user in this service |

    
    