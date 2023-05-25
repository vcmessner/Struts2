package learningcucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.itclinical.simple_struts_exercise.AuxiliaryMethods;
import com.itclinical.simple_struts_exercise.HelloWorldAction;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.core.ParseException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class ValidateInputAndAge {
    private HelloWorldAction myAction;
    private AuxiliaryMethods myAux = new AuxiliaryMethods();
    private String inputIsValid;
    
    @Given("user submits name {string} and date {string}")
    public void userSubmitsInput(String name, String date) throws ParseException {
        name = myAux.trucateName(name);
        System.out.println(name);
        myAction = new HelloWorldAction(name,date);
    }

    @When("i ask whether user the input is valid")
    public void iAskWhetherInputIsValid() throws Exception {
        if (myAction.saveOnSubmit().equals(ActionSupport.SUCCESS)){
            inputIsValid = "True";
        }
        else{
            inputIsValid = "False";
        }
    }
    @Then("input is valid = {string}")
    public void inputIsValid(String Answer) {
        assertEquals(Answer, inputIsValid);
    }
    @Then("my age = {string}")
    public void myAgeIsValid(String Answer) {
        assertEquals(Answer, myAction.getAge());
    }


}
