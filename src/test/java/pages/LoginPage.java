package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import actions.LoginTest;

public class LoginPage {
    //Page Object variables
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By loginError = By.xpath("//h3[contains(text(), 'Epic sadface: Username and password do not match any user in this service')]");
    private By lockedError = By.xpath("//h3[contains(text(), 'Epic sadface: Sorry, this user has been locked out.')]");
    private By productPage = By.xpath("//span[contains(text(),'Products')]");
    LoginTest test = new LoginTest();

    //Instantiation variables
    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 15); //Explicit WebDriverWait setup
        action = new Actions(this.driver); //Interaction.Action class setup to perform hover action
    }

    //Function to Scroll down the page
    public void ScrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;//Launches the javascriptexecutor
        js.executeScript("window.scrollBy(0, 200)");
        System.out.println("Scrolled Page Down");
    }

    public void enterUsername(String input){
            driver.findElement(username).clear();
            driver.findElement(username).sendKeys(input);
            System.out.println("A Username has been entered");
    }

    public void enterPassword(String input) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(input);
        System.out.println("A password has been entered");
    }


    public void clickLogin(){
            driver.findElement(loginButton).click();
            System.out.println("Login Button has been clicked");
    }

    public void errorDisplayed(){
            driver.findElement(loginError).isDisplayed();
            System.out.println("Error Text for invalid username or password has been displayed");
    }

    public void lockedDisplayed(){
            driver.findElement(lockedError).isDisplayed();
            System.out.println("Error Text for locked Username has been displayed");
    }

    public void productPageDisplayed(){
            driver.findElement(productPage).isDisplayed();
            System.out.println("Product Page is displayed therefore user has successfully logged in");
    }
}
