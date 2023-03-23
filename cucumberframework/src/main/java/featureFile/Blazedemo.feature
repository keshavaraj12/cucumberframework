Feature: Book the flight

	Background: Comman steps in all scenarios
  	Given enter the url "https://blazedemo.com/index.php" 
    Then validate the home page

@smoketest
  	Scenario: In home page validate beach link
    When click on beach link
    Then validate the beach link page
    And back to home page
    
@regressiontest
    Scenario Outline: In home page select Departure and Destination city then find flights 
    When select Departure city "<from>"
    And select Destination city "<to>"
    And click on flight button
    When click on choose flight with lowest price
    Then validate the total cost
    When click on purchase flight 
     Examples: 
      |from |to |
      |Paris |Rome |
      |Mexico City |Rome |  
    
@smoketest
  	Scenario: purchase the flight by filling the form then validate confirmation page and get id
    When select Departure city "Mexico City"
    And select Destination city "London"
    And click on flight button
    When click on choose flight with lowest price
    Then validate the total cost
     When enter the details
    |Name |Prashanth Neel |
    |Address |KGF |
    |City |Kolar |
    |State |Karnataka |
    |Zip Code |543231 |
    |Credit Card Number |69876543219 |
    |Month |12 |
    |year |2020 |
    |Name on Card |Prashanthraj | 
    When click on purchase flight
    Then validate cofirmation
    And get id 