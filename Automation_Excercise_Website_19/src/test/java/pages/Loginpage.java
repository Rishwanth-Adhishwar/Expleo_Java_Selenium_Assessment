package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Loginpage extends Basepage{
	public Loginpage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//i[@class='fa fa-lock']")
	WebElement signUpButton;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	WebElement Rname;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement Remail;
	
	@FindBy(xpath="//button[normalize-space()='Signup']")
	WebElement signUpButton1;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Rpassword;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement Address;
	
	@FindBy(xpath="//select[@id='country']")
	WebElement Country;
	
	@FindBy(xpath="//input[@id='state']")
	WebElement State;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement City;
	
	@FindBy(xpath="//input[@id='zipcode']")
	WebElement ZipCode;
	
	@FindBy(xpath="//input[@id='mobile_number']")
	WebElement MobileNumber;
	
	@FindBy(xpath="//button[text()='Create Account']")
	WebElement createAccButton;
	
	@FindBy(xpath="//b[text()='Account Created!']")
	WebElement confirmR;
	
	@FindBy(xpath="//p[text()='Email Address already exist!']")
	WebElement invalidRegister;
	
    @FindBy(xpath="//input[@data-qa='login-email']")
    WebElement LEmail;

    @FindBy(xpath="//input[@data-qa='login-password']")
    WebElement LPassword;

    @FindBy(xpath="//button[@data-qa='login-button']")
    WebElement LoginButton;
    
    @FindBy(xpath="//p[text()='Your email or password is incorrect!']")
	WebElement invalidLogin;
    
    @FindBy(xpath="//li[10]//a[1]")
	WebElement validLogin;
	public void registerAccount(String rname,String remail,String pass,String fname,String lname,String address,int country,String state,String city,String zipcode,String mobilenumber)
	{
		wait.until(ExpectedConditions.visibilityOf(signUpButton)).click();
		wait.until(ExpectedConditions.visibilityOf(Rname)).sendKeys(rname);
		Remail.sendKeys(remail);
		signUpButton1.click();
		wait.until(ExpectedConditions.visibilityOf(Rpassword)).sendKeys(pass);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		Address.sendKeys(address);
		Select s=new Select(Country);
		s.selectByIndex(country);
		State.sendKeys(state);
		City.sendKeys(city);
		ZipCode.sendKeys(zipcode);
		MobileNumber.sendKeys(mobilenumber);
		WebElement btn = wait.until(
		ExpectedConditions.visibilityOf(createAccButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btn);

	}
	
	public void registerAccWithExistEmail(String rname,String remail)
	{
		wait.until(ExpectedConditions.visibilityOf(signUpButton)).click();
		wait.until(ExpectedConditions.visibilityOf(Rname)).sendKeys(rname);
		Remail.sendKeys(remail);
		signUpButton1.click();
	}
	public String registerErrorMessage()
	{
		return wait.until(ExpectedConditions.visibilityOf(invalidRegister)).getText();
	}
	
	public String registerSuccess()
	{
		return wait.until(ExpectedConditions.visibilityOf(confirmR)).getText();
	}
	public void login(String lemail,String lpass)
	{
		 wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
	     wait.until(ExpectedConditions.visibilityOf(LEmail)).sendKeys(lemail);
	     LPassword.sendKeys(lpass);
	     LoginButton.click();
	}
	public String logSuccess()
	{
		return wait.until(ExpectedConditions.visibilityOf(validLogin)).getText();
	}
	public String logErrorMessage()
	{
		return wait.until(ExpectedConditions.visibilityOf(invalidLogin)).getText();
	}
	
}

	


