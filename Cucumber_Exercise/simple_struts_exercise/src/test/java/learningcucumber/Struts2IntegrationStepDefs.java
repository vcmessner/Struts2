package learningcucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.itclinical.simple_struts_exercise.AuxiliaryMethods;
import com.itclinical.simple_struts_exercise.HelloWorldAction;

import freemarker.core.ParseException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Struts2IntegrationStepDefs {

    private HelloWorldAction myAction;
    private String userIsAllowed;
    private AuxiliaryMethods myAux = new AuxiliaryMethods();

    @Given("the name {string} and days interval {int}")
    public void userSubmitsName(String name, int days) throws ParseException {
        LocalDate currentDate = LocalDate.now(ZoneOffset.UTC);
        currentDate=currentDate.minusDays(days);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AuxiliaryMethods.DATE_FORMAT);
        name = myAux.trucateName(name);
        myAction = new HelloWorldAction(name,currentDate.format(formatter));        
    }

    @When("we want to abstract the user date input and check if the day intervals provide valid reply")
    public void iAskWhetherUserIsAllowed() throws Exception {
        if (myAction.saveUsername() && myAction.saveDate()){
            userIsAllowed = "True";
        }
        else{
            userIsAllowed = "False";
        }
    }
    @Then("user allowed value is {string}")
    public void userAllowedValueIs(String Answer) {
        assertEquals(Answer, userIsAllowed);
    }

}
