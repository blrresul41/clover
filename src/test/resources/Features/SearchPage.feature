@test
Feature: User can search anything on search box

  Scenario Outline: User can search any item on search box on
    Given User navigate to "<searchEngine>" search page
    When User enters "<searchItem>" and clicks enter on "<searchEngine>"
    Then User able to see "<searchItem>" in the search response on "<searchEngine>"

    Examples:
      | searchItem | searchEngine |
      | Clover     | Google       |
      | Clover     |    Yahoo     |
      | Clover     |    Bing      |
