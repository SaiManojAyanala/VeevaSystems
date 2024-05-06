Feature: CoreProduct Feature

  Scenario: Testcase1 for CP
    Given User Login to the Core Product Application
    Then Skip Signup
    When User Navigate to shop menu mens
    Then Collect the all jackets Price Title and Top Seller Message to a text file


#  https://testomat.io/blog/singleton-design-pattern-how-to-use-it-in-test-automation/
#  driverVersion("122")
#  //div[@class='grid-small-1-medium-3 row small-up-1 medium-up-3']/div