Feature: Is user allowed?
Check if the user is allowed to proceed

    Scenario Outline: user is allowed
        Given user submits name "<input_name>" and age "<input_age>"
        When I ask whether user will be allowed
        Then user allowed value is "<answer>"

        Examples:
        | input_name     | input_age      |  answer |
        | Algo           | 5              |  False  |
        | Sunday         | 18             |  True   |
        | Algo           | algo           |  False  |
        | Algo           | -1             |  False  |
        | Algo           | 500            |  True   |
        | Algo           | 0              |  False  | 
        | Sunday11       | 1000           |  False  |
        |                | 0              |  False  |