Feature: Is Name valid?
Check if the name is a valid input

    Scenario Outline: name is valid
        Given name is "<input_name>"
        When I ask whether name is valid
        Then it should reply "<answer>"

        Examples:
        | input_name     | answer |
        | Algo           | True   |
        | Sunday         | True   |
        | Sunday11       | False   |
        |                | False  |