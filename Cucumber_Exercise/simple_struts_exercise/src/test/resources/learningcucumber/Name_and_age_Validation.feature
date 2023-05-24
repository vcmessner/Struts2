Feature: Is Name valid?
Check if the name is a valid input

    Scenario Outline: name is valid
        Given user in in the form submission page submits name "<input_name>" and age "<input_age>"
        When I ask whether input is valid
        Then it returns "<answer>"

        Examples:
        | input_name     | input_age      |  answer |
        | Algo           | 5              |  True   |
        | Sunday         | 18             |  True   |
        | Sunday11       | 1000           |  False  |
        |                | 0              |  False  |
        | Algo           | algo           |  False  |
        | Algo           | -1             |  False  |
        | Algo           | 500            |  True   |
        | Algo           | 0              |  True   |

