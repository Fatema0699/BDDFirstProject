package homepagestepdefinition;

import common.WebAPI;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import rainforesthomepage.Homepage;

import java.io.IOException;

public class Stepdefinition extends WebAPI {
    @Before
    public void envAndSetup() throws IOException {
        setUp(false,
                "browserstack",
                "Windows", "11",
                "Edge", "131",
                "https://monsur26.github.io/mypage/");
    }
    @After
    public void closeBrowser(){
        cleanUp();
    }
    static Homepage homepage;
    public static void getInitElements(){
        homepage = PageFactory.initElements(driver,Homepage.class);
    }

    @Given("User lands on the rainforest homepage")
    public void User_lands_on_the_rainforest_homepage(){
        getInitElements();
    }
    @When("User clicks and enters valid username on the username field")
    public void User_clicks_and_enters_valid_username_on_the_username_field(){
        getInitElements();
        homepage.enterUsername("Username1");
    }
    @When("User clicks and enters valid password on the password field")
    public void User_clicks_and_enter_valid_password_on_the_password_field(){
        getInitElements();
        homepage.enterPassword("Password1");
    }
    @When("User clicks on the Login button")
    public void User_clicks_on_the_Login_button(){
        getInitElements();
        homepage.clickOnLoginButton();
    }
    @Then("User is successfully logged in")
    public void User_is_successfully_logged_in(){
        getInitElements();
        homepage.validUserCredAssertion();
    }
    @When("User clicks on the search bar and enter for an {string}")
    public void user_clicks_on_the_search_bar_and_enter_for_an(String string) {
        getInitElements();
        string = "Rainforest";
        homepage.enterSearchItem(string);
    }
    @When("User clicks on the search button")
    public void user_clicks_on_the_search_button() {
      getInitElements();
      homepage.clickOnSearchButton();
    }
    @Then("User should see the search results")
    public void user_should_see_the_search_results() {
        getInitElements();
        homepage.validateSearchResult();
    }

    @When("User serches for an {string}")
    public void user_serches_for_an(String string) {
      getInitElements();
      homepage.enterSearchItem(string);
    }
    @When("User enters username {string}")
    public void user_enters_username(String string) {
       getInitElements();
       homepage.enterUsername(string);
    }
    @When("User enters password {string}")
    public void user_enters_password(String string) {
     getInitElements();
     homepage.enterPassword(string);
    }
    @Then("User is successfully logged if user is valid in or see an error message if user is invalid")
    public void user_is_successfully_logged_if_user_is_valid_in_or_see_an_error_message_if_user_is_invalid() {
      getInitElements();
      if(homepage.alertPresent()){
          homepage.validUserCredAssertion();
      }else {
          homepage.invalidUserCredValidation();
      }
    }

}
