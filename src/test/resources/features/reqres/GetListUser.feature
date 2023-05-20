Feature: Get List Users

  @Tugas
  Scenario Outline: Get list users with valid page parameter
    Given <page> as valid parameter page for get list users
    When Send GET request for get list users
    Then API response for get list users should return 200 OK status code
    And Response body page for get list users should be <page>
    And Response body data for get list users should contains 6 users
    And Validate get list users with valid page parameter response body JSON Schema
    Examples:
      | page |
      | 1    |
      | 2    |

  @Tugas
  Scenario: Get list users with exceeded users count page parameter
    Given 3 as a valid exceeded parameter page for get list users
    When Send GET request for get list users
    Then API response for get list users should return 404 Not Found status code

  @Tugas
  Scenario Outline: Get list users with invalid parameter page
    Given "<page>" as invalid parameter page for get list users
    When Send GET request for get list users
    Then API response for get list users should return 400 Bad Request status code
    Examples:
      | page |
      | !    |
      | @    |

  @Tugas
  Scenario: Get list users with empty parameter page
    Given Empty parameter page for get list users
    When Send GET request for get list users
    Then API response for get list users should return 400 Bad Request status code