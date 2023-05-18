Feature: Reqres API Automation Testing QE-10

  @Latihan
  Scenario Outline: Get list users with valid parameter page
    Given Get list users with valid parameter page <page> and path "/api/users?page={page}"
    When Send get lists users
    Then Status code should be 200 OK
    Examples:
      | page |
      | 1    |
      | 2    |

  @Latihan
  Scenario: Post create new user with valid json
    Given Post create user with valid json and path "/api/users"
    When Send post create user
    Then Status code should 201 Created

  @Latihan
  Scenario Outline: Put update user with valid json and id
    Given Put update user with valid json and id <id> and path "/api/users/{id}"
    When Send put update user
    Then Status code should be 200 OK
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |

  @Latihan
  Scenario Outline: Delete user with valid parameter id
    Given Delete user with id <id> and path "/api/users/{id}"
    When Send delete user
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 1  |
      | 2  |