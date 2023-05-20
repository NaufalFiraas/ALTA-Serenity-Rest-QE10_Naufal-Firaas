Feature: Delete User

  @Tugas
  Scenario Outline: Delete user with valid id
    Given <id> as a valid parameter id for delete user
    When Send DELETE request for delete user
    Then API response for delete user should return 204 No Content status code
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |

  @Tugas
  Scenario: Delete user with exceeded parameter id
    Given 50 as exceeded parameter id for delete user
    When Send DELETE request for delete user
    Then API response for delete user should return 404 Not Found status code

  @Tugas
  Scenario Outline: Delete user with invalid parameter id
    Given "<id>" as invalid parameter id for delete user
    When Send DELETE request for delete user
    Then API response for delete user should return 400 Bad Request status code
    Examples:
      | id |
      | @  |
      | *  |
      | %  |

  @Tugas
  Scenario: Delete user with empty parameter id
    Given Empty parameter id for delete user
    When Send DELETE request for delete user
    Then API response for delete user should return 400 Bad Request status code