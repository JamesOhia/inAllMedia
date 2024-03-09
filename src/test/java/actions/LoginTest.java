package actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.NavigateToURL;
import pages.StartBrowser;
import pages.LoginPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginTest extends ExtentReportClass {
	private static WebDriver driver;
    private static final String URL = "https://github.com/bonigarcia/webdrivermanager";

	@BeforeTest
	static void startUp() throws IOException {
		//Start the Selenium selected Browser for the test
        StartBrowser selectBrowser = new StartBrowser(driver);
		driver = selectBrowser.initializeBrowser();
		NavigateToURL startWebsite = new NavigateToURL(driver);
		startWebsite.launchURL();
	}

	@Test(priority = 1)
	public void LoginInvalidUsername () throws InterruptedException {
		ExtentTest invalidUsernameTest = extent.createTest("Login_Invalid_Username",
				"Negative Test to ensure you cannot login with an invalid UserName");

		invalidUsernameTest.log(Status.INFO, "Testing Login for Invalid Username has Started");

		String InvalidUsername = "Invalid_user";
		String ValidPassword = "secret_sauce";
		LoginPage loginPage = new LoginPage(driver);
		try{
			loginPage.enterUsername(InvalidUsername);
			invalidUsernameTest.log(Status.PASS, "Invalid Username has been entered and field is not null");
		}
		catch(Exception e){
			invalidUsernameTest.log(Status.FAIL, "Error encountered to enter InvalidUsername or field is null");
			throw new RuntimeException(e.getMessage());
		}
		try{
			loginPage.enterPassword(ValidPassword);
			invalidUsernameTest.log(Status.PASS, "Valid Password has been entered and field is not null");
		}
		catch(Exception e){
			invalidUsernameTest.log(Status.FAIL, "Error encountered to enter Valid Password or field is null");
			throw new RuntimeException(e.getMessage());
		}
		try{
			loginPage.clickLogin();
			invalidUsernameTest.log(Status.PASS, "Login Button has been clicked");
		}
		catch(Exception e){
			invalidUsernameTest.log(Status.FAIL, "Error encountered when clicking Login Button");
			throw new RuntimeException(e.getMessage());
		}
		try{
			loginPage.errorDisplayed();
			invalidUsernameTest.log(Status.PASS, "Error Text for invalid username has been displayed");
		}
		catch(Exception e){
			invalidUsernameTest.log(Status.FAIL, "Error encountered when displaying invalid username error message");
			throw new RuntimeException(e.getMessage());
		}
		invalidUsernameTest.log(Status.INFO, "Testing Login for Invalid Username has Ended");
	}

	@Test(priority = 2)
	public void LoginInvalidPassword () throws InterruptedException {
		ExtentTest invalidPasswordTest = extent.createTest("Login_Invalid_Password",
				"Negative Test to ensure you cannot login with an invalid Password");

		invalidPasswordTest.log(Status.INFO, "Testing Login for Invalid Password has Started");
		String ValidUsername = "standard_user";
		String InvalidPassword = "Invalid_password";
		LoginPage loginPage = new LoginPage(driver);

		try{
			loginPage.enterUsername(ValidUsername);
			invalidPasswordTest.log(Status.PASS, "Valid Username has been entered and field is not null");
		}
		catch(Exception e){
			invalidPasswordTest.log(Status.FAIL, "Error encountered to enter ValidUsername or field is null");
			throw new RuntimeException(e.getMessage());
		}
		try{
			loginPage.enterPassword(InvalidPassword);
			invalidPasswordTest.log(Status.PASS, "Invalid Password has been entered and field is not null");
		}
		catch(Exception e){
			invalidPasswordTest.log(Status.FAIL, "Error encountered to enter Invalid Password or field is null");
			throw new RuntimeException(e.getMessage());
		}
		try{
			loginPage.clickLogin();
			invalidPasswordTest.log(Status.PASS, "Login Button has been clicked");
		}
		catch(Exception e){
			invalidPasswordTest.log(Status.FAIL, "Error encountered when clicking Login Button");
			throw new RuntimeException(e.getMessage());
		}
		try{
			loginPage.errorDisplayed();
			invalidPasswordTest.log(Status.PASS, "Error Text for invalid password has been displayed");
		}
		catch(Exception e){
			invalidPasswordTest.log(Status.FAIL, "Error encountered when displaying invalid password error message");
			throw new RuntimeException(e.getMessage());
		}
		invalidPasswordTest.log(Status.INFO, "Testing Login for Invalid Password has Ended");

	}

	@Test(priority = 3)
	public void LoginLockedAccount () throws InterruptedException {
		ExtentTest lockedAccountTest = extent.createTest("Login_Locked_Account",
				"Negative Test to ensure you cannot login with a Locked Account");

		lockedAccountTest.log(Status.INFO, "Testing Login for Locked Account has Started");
		String LockedAccount = "locked_out_user";
		String ValidPassword = "secret_sauce";
		LoginPage loginPage = new LoginPage(driver);

		try{
			loginPage.enterUsername(LockedAccount);
			lockedAccountTest.log(Status.PASS, "Locked Account Username has been entered and field is not null");
		}
		catch(Exception e){
			lockedAccountTest.log(Status.FAIL, "Error encountered to enter Locked Account Username or field is not null");
			throw new RuntimeException(e.getMessage());
		}
		try{
			loginPage.enterPassword(ValidPassword);
			lockedAccountTest.log(Status.PASS, "Valid Password has been entered and field is not null");
		}
		catch(Exception e){
			lockedAccountTest.log(Status.FAIL, "Error encountered to enter Valid Password or field is not null");
			throw new RuntimeException(e.getMessage());
		}
		try{
			loginPage.clickLogin();
			lockedAccountTest.log(Status.PASS, "Login Button has been clicked");
		}
		catch(Exception e){
			lockedAccountTest.log(Status.FAIL, "Error encountered when clicking Login Button");
			throw new RuntimeException(e.getMessage());
		}
		try{
			loginPage.lockedDisplayed();
			lockedAccountTest.log(Status.PASS, "Error Text for locked Username has been displayed");
		}
		catch(Exception e){
			lockedAccountTest.log(Status.FAIL, "Error encountered when displaying locked Username error message");
			throw new RuntimeException(e.getMessage());
		}
		lockedAccountTest.log(Status.INFO, "Testing Login for Locked Account has Ended");
	}

@Test(priority = 4)
	public void loginSuccess () throws InterruptedException {
	ExtentTest loginSuccessTest = extent.createTest("Login_Successful",
			"Positive Test Scenario to Ensure you can login with a valid username and password");

	loginSuccessTest.log(Status.INFO, "Testing Login for Login Success has Started");
		String ValidUsername = "standard_user";
		String ValidPassword = "secret_sauce";
		LoginPage loginPage = new LoginPage(driver);

		try{
			loginPage.enterUsername(ValidUsername);
			loginSuccessTest.log(Status.PASS, "Valid Username has been entered and field is not null");
		}
		catch(Exception e){
			loginSuccessTest.log(Status.FAIL, "Error encountered to enter ValidUsername or field is not null");
			throw new RuntimeException(e.getMessage());
		}
		try{
			loginPage.enterPassword(ValidPassword);
			loginSuccessTest.log(Status.PASS, "Valid password has been entered and field is not null");
		}
		catch(Exception e){
			loginSuccessTest.log(Status.FAIL, "Error encountered to enter Valid Password or field is not null");
			throw new RuntimeException(e.getMessage());
		}
		try{
			loginPage.clickLogin();
			loginSuccessTest.log(Status.PASS, "Login Button has been clicked");
		}
		catch(Exception e){
			loginSuccessTest.log(Status.FAIL, "Error encountered when clicking Login Button");
			throw new RuntimeException(e.getMessage());
		}
		try{
			loginPage.productPageDisplayed();
			loginSuccessTest.log(Status.PASS, "Product Page is displayed therefore user has successfully logged in");
		}
		catch(Exception e){
			loginSuccessTest.log(Status.FAIL, "Error Encountered when displaying Product Page or User hasn't Logged in");
			throw new RuntimeException(e.getMessage());
		}
	loginSuccessTest.log(Status.INFO, "Testing Login for Login Success has Ended");
	}

		@AfterTest

	public void TearDown() {
		driver.close();
		driver.quit();
		System.out.print("Login Test Scenarios  Passed Successfully ");
	}

}






