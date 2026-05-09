package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//i[@class='fa fa-lock']")
	WebElement signUpButton;
	
	@FindBy(xpath="//input[@data-qa='login-email']")
    WebElement LEmail;

    @FindBy(xpath="//input[@data-qa='login-password']")
    WebElement LPassword;

    @FindBy(xpath="//button[@data-qa='login-button']")
    WebElement LoginButton;
    
    public void login()
	{
		 wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
	     wait.until(ExpectedConditions.visibilityOf(LEmail)).sendKeys("rishwa789@gmail.com");
	     LPassword.sendKeys("Rishwa2k26");
	     LoginButton.click();
	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/products']"))).click();
	}

}
