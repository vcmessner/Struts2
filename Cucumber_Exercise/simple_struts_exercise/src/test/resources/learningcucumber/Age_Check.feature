Feature: Is Age valid?
Check if the Age is a valid input

    Scenario Outline: Age is valid
        Given Age is "<number>"
        When I ask whether is positive number
        Then it should answer "<answer>"

        Examples:
        | number         | answer |
        | 18             | True   |
        | 5              | True   |
        |                | False  |
        | 1000           | True   |
        | 0              | True   |
        | algo           | False  |
        | -1             | False  |
