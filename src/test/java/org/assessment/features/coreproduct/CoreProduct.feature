Feature: CoreProduct Feature

  Scenario: Testcase1 for CP
    Given User Login to the Core Product Application
    Then Skip Signup
    When User Navigate to shop menu mens
    Then Collect the all jackets Price Title and Top Seller Message to a text file
