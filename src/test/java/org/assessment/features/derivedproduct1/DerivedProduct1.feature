Feature: Derived Product 1

  Scenario: Test Case 3 for DP1
    Given Login to Derived Product1
    Then Validate the count of number of slides present
      | slidesCount |
      | 3           |
    And Validate the tile of each slide
      | slide1                                               | slide2                                                         | slide3                                                  |
      | Philadelphia 76ers vs. New York Knicks (May 2, 2024) | Maxey's Playoff Career-High 46 Point Performance Forces Game 6 | Tyrese Maxey Named 2023-24 Kia NBA Most Improved Player |
    And Validate the duration of each slide
      | slide1_Duration | slide2_Duration | slide3_Duration |
      | 0.3s            | 0.3s            | 0.3s            |