package learningcucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AgeCheck_StepDefinition {
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
}