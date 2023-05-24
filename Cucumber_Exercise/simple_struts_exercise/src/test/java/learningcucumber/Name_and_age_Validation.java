package learningcucumber;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.itclinical.simple_struts_exercise.HelloWorldAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Name_and_age_Validation{
    HelloWorldAction myaction;
    String Name_is_Valid;
    String Age_is_Valid;
    String Output_is_valid;
    String User_is_Allowed;


    @Given("user in in the form submission page submits name {string} and age {string}")
    public void user_in_in_the_form_submission_page_submits_name(String name, String age) {
        myaction = new HelloWorldAction(name,age);        
    }

    @When("I ask whether input is valid")
    public void i_ask_whether_name_is_valid() {
        Name_is_Valid = IsItValid.isNameValid(myaction.getName());
        Age_is_Valid = IsItValid.isAgeValid(myaction.getAge());
        if(Name_is_Valid.equals("True") && Age_is_Valid.equals("True")){
            Output_is_valid = "True";
        }
        else{
            Output_is_valid = "False";
        }
    }

    @Then("it returns {string}")
    public void it_returns(String Answer) {
        assertEquals(Answer, Output_is_valid);
    }

    
}
