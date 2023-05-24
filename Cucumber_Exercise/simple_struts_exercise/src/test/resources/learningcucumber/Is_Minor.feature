Feature: Is Age from a Minor?
Check if the Age corresponts a Minor input

    Scenario Outline: Age is valid
        Given Age is "<number>"
        When i ask whether is geq 18
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