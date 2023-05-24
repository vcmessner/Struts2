package learningcucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.itclinical.simple_struts_exercise.HelloWorldAction;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Struts2Integration {

    HelloWorldAction myaction;
    private String User_is_Allowed;

    @Given("user submits name {string} and age {string}")
    public void user_submits_name(String name, String age) {
        myaction = new HelloWorldAction(name,age);        
    }

    @When("I ask whether user will be allowed")
    public void i_ask_whether_user_is_allowed() throws Exception {
        if (myaction.saveUsername() && myaction.saveAge()){
            User_is_Allowed = "True";
        }
        else{
            User_is_Allowed = "False";
        }
    }
    @Then("user allowed value is {string}")
    public void user_allowed_value_is(String Answer) {
        assertEquals(Answer, User_is_Allowed);
    }

}
