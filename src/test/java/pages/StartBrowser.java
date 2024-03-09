package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//Class used to select and initiate browser
public class StartBrowser {
	private WebDriver driver = null;
		
	public StartBrowser(WebDriver driver) {
		
		this.driver  = driver;
	}
	
	public WebDriver initializeBrowser() throws IOException {
		//Here we are making use of Config.properties to set the browser to use of your choice by just renaming it to the browser name specified below
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.properties");
		config.load(fis);
		String browserName = config.getProperty("browser");
		String osType = config.getProperty("os");
		if (browserName.equals("chrome")){ //Use Chrome Browser
			//Instantiate the Chrome Options object that will enable the disabling of notification
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications"); //Disable Location pop-up notification that has potential of displaying
			if(osType.equals("windows")){
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe");
			}
			else{//osType = "mac"
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver/chromedriver");
			}
			// Pass the ChromeOptions instance while creating the ChromeDriver
			this.driver = new ChromeDriver(options);
		}

		else if (browserName.equals("fireFox")) { //Use Firefox Browser
			if(osType.equals("windows")){
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver\\geckodriver.exe");
			}
			else{//osType = "mac"
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver/geckodriver");
			}

			this.driver = new FirefoxDriver();
		}

		else { //Use Internet Explorer Browser
			if(osType.equals("windows")){
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\drivers\\IEDriver\\IEDriverServer.exe");
			}
			else {//osType = "mac"
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/drivers/IEDriver/IEDriverServer");
			}
			driver = new EdgeDriver();
		}

		System.out.println("Browser Initialize. Test Passed");
		return driver;

	}
		

	}

