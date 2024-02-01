@test
Feature: User can search anything on search box


  Scenario Outline: User can  search any item on search box
    Given User navigate to search page
    When User enters  "<searchItem>" and clicks Enter
    Then User able to see "<searchItem>" in the search response
    Examples:
      |searchItem|
      |Clover    |