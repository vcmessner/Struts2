package learningcucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LegalAge_StepDefinition {
    private String legal;

    private String Age;

    private String Is_Valid_Age;

    public static final int LEGAL_AGE = 18;

    @Given("Age is a valid {string}")
    public void age_is(String age) {
        this.Is_Valid_Age = IsItValid.isAgeValid(age);
        this.Age = age;
    }

    @When("i ask whether is legal")
    public void is_legal() {
        if(Is_Valid_Age.equals("True")){
            int myage = Integer.parseInt(this.Age);
            if(myage>=LEGAL_AGE){
                legal="True";
            }
            else{
                legal="False";
            }
        }
        else{
            legal="False";
        }
        }

    @Then("answer {string}")
    public void isMinor(String Answer) {
        assertEquals(Answer,legal);
    }
}
