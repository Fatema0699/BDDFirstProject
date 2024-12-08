package rainforesthomepage;

import common.WebAPI;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class Homepage extends WebAPI {
    // WebElements for the page
    @FindBy(how = How.ID, using = "username") public WebElement usernameWebelement;
    @FindBy (how = How.ID, using = "password") public WebElement passwordWebElement;
    @FindBy (how = How.ID, using = "loginButton") public WebElement loginButtonWebElement;
    @FindBy(how=How.XPATH, using = "//input[@id='searchInput' and @type='text']") public WebElement searchBar;
    @FindBy(how=How.XPATH, using = "//button[@onclick='performSearch()']") public WebElement searchButton;
    @FindBy(how=How.XPATH, using = "//h3[text()=\"Search Results:\"]") public WebElement searchResult;
    @FindBy (how = How.ID, using = "errorMessage") public WebElement errorMessageWebelement;
    //Action methods
    public void enterUsername(String username){
        usernameWebelement.click();
        usernameWebelement.sendKeys(username);
    }
    public  void enterPassword(String password){
        passwordWebElement.click();
        passwordWebElement.sendKeys(password);
    }
    public void clickOnLoginButton(){
        loginButtonWebElement.click();
    }
    public void enterSearchItem(String item){
       searchBar.click();
       searchBar.sendKeys(item);
    }
    public void clickOnSearchButton(){
        searchButton.click();
    }
    public boolean alertPresent(){
        Alert alert = driver.switchTo().alert();
       boolean isAlert = alert.equals(true);
       return isAlert;
    }
    //Validation and assertion
    public void validUserCredAssertion(){
       String actual =  driver.switchTo().alert().getText();
       String expected = "Login successful!";
       Assert.assertEquals("Assertion failed",expected,actual);
    }
    public void validateSearchResult(){
        String actual = searchResult.getText();
        String expected = "Search Results:";
        Assert.assertEquals("Assertion failed", expected,actual);
    }
    public void invalidUserCredValidation(){
            String actual =errorMessageWebelement.getText();
            String expected = "Invalid username and password!";
            Assert.assertEquals("Assertion failed",expected,actual);
    }
}
