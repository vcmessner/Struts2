Feature: Is user allowed?
Check if the user input are valid, the resulting allowed status and the user age. User age Should be "" if no valid data input is found.

    Scenario Outline: user inputs are valid
        Given user submits name "<inputName>" and date "<inputDate>"
        When i ask whether user the input is valid
        Then input is valid = "<isValid>"
        Then my age = "<myAge>"

        Examples:
        | inputName      | inputDate      |  isValid |  myAge       |
        | Algo           | 24/05/2000     |  True    |  23 years    | 
        | Sunday         | 24/05/2010     |  False   |  13 years    |
        | John           | 26/05/2005     |  True    |  18 years    |
        | John           | 25/05/2005     |  True    |  18 years    |
        | Algo           | 24/13/2010     |  False   |              |
        | Algo           | 29/02/2010     |  False   |              |
        | Algo           | 24/05/2023     |  False   |  0 years     | 
        |                | 24/05/2010     |  False   |  13 years    | 