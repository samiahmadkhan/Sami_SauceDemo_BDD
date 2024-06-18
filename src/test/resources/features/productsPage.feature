Feature: Test that User is able to Successfully add products,Remove,Logout
Background: 
    Given User is on login page
    
 @product @positive @image          
Scenario Outline: Correct Products Images are Visible with respect to the Products Name
      When User enters "<username>" and "<password>"
      Then "<Product Name>" and its respective "<ImageName>" should be displayed 
      
      Examples:
    | username                 | password     | Product Name            | ImageName      |
    | standard_user            | secret_sauce | Sauce Labs Backpack     | sauce-backpack |
    | standard_user            | secret_sauce | Sauce Labs Bolt T-Shirt | bolt-shirt     |
    | problem_user             | secret_sauce | Sauce Labs Bike Light   | bike-light     |
    | performance_glitch_user  | secret_sauce | Sauce Labs Bolt T-Shirt | bolt-shirt     |
    
 @product @positive @addremove       
Scenario Outline: User should be able to Logout from Product Page
       Given User enters "<username>" and "<password>" 
       And User should land on Products Page
       When User Logout from Products Page
       Then User is on login page  
      
        Examples:
    | username                 | password     | Product Name            |
    | standard_user            | secret_sauce | Sauce Labs Backpack     |
    | standard_user            | secret_sauce | Sauce Labs Bolt T-Shirt |
    
    
       
  @product @positive @addremove       
Scenario Outline: Add Products to Cart
      Given User enters "<username>" and "<password>"
      When User adds "<Product Name>" to cart
      Then Verify Product is added in Shopping Bag
      When User should be able to remove "<Product Name>" from Products
      Then Verify Product is Removed from Shopping Bag "<Product Name>"
      When User Logout from Products Page
      Then User is on login page
      
      Examples:
    | username                 | password     | Product Name            |
    | standard_user            | secret_sauce | Sauce Labs Backpack     |
    | standard_user            | secret_sauce | Sauce Labs Bolt T-Shirt |
    | performance_glitch_user  | secret_sauce | Sauce Labs Bolt T-Shirt | 
    | problem_user             | secret_sauce | Sauce Labs Bike Light   |