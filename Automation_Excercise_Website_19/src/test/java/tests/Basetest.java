package tests;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Basetest {
public static ThreadLocal<WebDriver> driver1=new ThreadLocal<WebDriver>();
public static Logger log=LogManager.getLogger();
	
	public WebDriver getDriver()
	{
		return driver1.get();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		log.info("Setting Chrome Driver");
		driver1.set(new ChromeDriver(opt));
		log.info("Getting Chrome Driver");
		WebDriver driver = getDriver();
		log.info("maximizing browser window");
		driver.manage().window().maximize();
		log.info("launching url in browser");
		driver.get("https://automationexercise.com/");
	}
	
	@AfterMethod
	public void turnDown()
	{
		WebDriver driver=getDriver();
		if(driver!=null)
		{
			log.info("quitting driver");
			driver.quit();
		}
	}


}
