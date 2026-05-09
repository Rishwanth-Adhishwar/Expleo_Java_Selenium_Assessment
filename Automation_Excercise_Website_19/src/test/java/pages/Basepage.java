package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basepage {
	WebDriver driver;
	WebDriverWait wait;
	
	public Basepage(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
}
