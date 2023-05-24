package learningcucumber;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions.*;


public class StepDefinitions {
    private String Name;
    private String Name_is_Valid;

    @Given("name is {string}")
    public void name_is(String name) {
        this.Name = name;
    }

    @When("I ask whether is valid")
    public void is_valid() {
        Name_is_Valid = IsItValid.isItValid(Name);
    }

    @Then("it should reply {string}")
    public void it_should_reply(String Answer) {
        assertEquals(Answer, Name_is_Valid);
    }

    @Given("an example scenario")
    public void anExampleScenario() {
    }

    @When("all step definitions are implemented")
    public void allStepDefinitionsAreImplemented() {
    }

    @Then("the scenario passes")
    public void theScenarioPasses() {
    }
}


class IsItValid {
    static String isItValid(String name) {
        return name.equals("") ? "False" : "True";
    }
}