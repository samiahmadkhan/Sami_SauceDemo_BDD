Feature: Test that User is able to Successfully add products and See them to Your Cart,
       aand complete Checkout Process
        
        
Background: 
    Given User is on login page 
 
 
 
 
 
    @ycheckout @positive @addremove @test       
Scenario Outline: Complete the Checkout Process
      Given User enters "<username>" and "<password>"
      When User adds "<Product Name>" to cart  
      And  User adds "Sauce Labs Bolt T-Shirt" to cart 
      When User navigated to Your Cart page
      Then User lands on Your Cart Page
      And User Verify Products are visible on Your Cart Page
      | Products |
      | <Product Name>|
      | Sauce Labs Bolt T-Shirt |
      When User Checkout from Your Cart Page
      And User Fill following details
      | FirstName | LastName | Postcode  |
      |<FirstName>|<LastName>|<Postcode> |
      And User Verify Products are visible on Your Cart Page
      | Products      |
      | <Product Name>|
      | Sauce Labs Bolt T-Shirt |
      Then User Finish the Checkout Process
      And User Logout from Products Page

       
      Examples:
    | username                 | password     | Product Name            | FirstName  |LastName | Postcode |
    | standard_user            | secret_sauce | Sauce Labs Backpack     |  test1     | user1   | 123 |
    | visual_user              | secret_sauce | Sauce Labs Bike Light   | test2      | user2   | 456 |