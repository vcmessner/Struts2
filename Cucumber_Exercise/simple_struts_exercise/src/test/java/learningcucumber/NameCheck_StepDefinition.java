package learningcucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NameCheck_StepDefinition {
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
}
