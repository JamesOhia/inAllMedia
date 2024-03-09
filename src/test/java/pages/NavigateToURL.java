package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

//Class used to Navigate to the URL
public class NavigateToURL {
		private WebDriver driver;
		private String baseUrl = "https://www.saucedemo.com/";

		// Constructor with WebDriver parameter for dependency injection
		public NavigateToURL(WebDriver driver){
			this.driver = driver;
		}

		public void launchURL() {
			//Set implicitly wait inorder to wait for 10 seconds if the element is not found before failing.
			//Works for subsequent driver.find elements
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(baseUrl);
			driver.manage().window().maximize();
			System.out.println("Swags Demo Url Launched Successfully");
		}

		public void BackArrow(){
			driver.navigate().back();
		}
	}

