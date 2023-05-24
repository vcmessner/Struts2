Feature: Is Legal Age?
Check if the Age corresponts a Leagal Age input

    Scenario Outline: Age is valid
        Given Age is a valid "<number>"
        When i ask whether is legal
        Then answer "<answer>"

        Examples:
        | number         | answer |
        | 18             | True   |
        | 5              | False  |
        |                | False  |
        | 1000           | True   |
        | 0              | False  |
        | algo           | False  |
        | -1             | False  |