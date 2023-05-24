package learningcucumber;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions.*;


public class StepDefinitions {   
    
    // Name_check
    private String Name;
    private String Name_is_Valid;

    @Given("name is {string}")
    public void name_is(String name) {
        this.Name = name;
    }

    @When("I ask whether name is valid")
    public void is_valid() {
        Name_is_Valid = IsItValid.isNameValid(Name);
    }

    @Then("it should reply {string}")
    public void it_should_reply(String Answer) {
        assertEquals(Answer, Name_is_Valid);
    }


    // Age_Check
    private String Age_is_Valid;
    private String Age;

    @Given("Age is {string}")
    public void age_is(String age) {
        this.Age = age;
    }

    @When("I ask whether is positive number")
    public void is_positive_num() {
        Age_is_Valid = IsItValid.isAgeValid(Age);
    }

    @Then("it should answer {string}")
    public void it_should_answer(String Answer) {
        assertEquals(Answer, Age_is_Valid);
    }

    // Is_Minor
    private String geq18;

    

    @When("i ask whether is geq 18")
    public void is_geq18() {
        geq18 = IsItValid.isAgeValid(Age);
        if(geq18.equals("True")){
            int myage = Integer.parseInt(this.Age);
            if(myage>=18){
                geq18="True";
            }
            else{
                geq18="False";
            }
        }
    }

    @Then("answer {string}")
    public void isMinor(String Answer) {
        assertEquals(Answer,geq18);
    }
}


class IsItValid {
    static String isNameValid(String name) {
        return name.equals("") ? "False" : "True";
    }

    static String isAgeValid(String age) {
        //return a.equals("") ? "False" : "True";
        return age.matches("[0-9]+") ? "True" : "False";
    }
}