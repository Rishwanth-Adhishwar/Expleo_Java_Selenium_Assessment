package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PayementPage extends BasePage {

	public PayementPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@name='name_on_card']")
	WebElement name;
	
	@FindBy(xpath="//input[@name='card_number']")
	WebElement cardno;
	
	@FindBy(xpath="//input[@placeholder='ex. 311']")
	WebElement cvc;
	
	@FindBy(xpath="//input[@placeholder='MM']")
	WebElement Month;
	
	@FindBy(xpath="//input[@placeholder='YYYY']")
	WebElement year;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement payConfirmOrder;
	
	@FindBy(xpath="//b[normalize-space()='Order Placed!']")
	WebElement orderPlacedMsg;

	public String placeOrderTwo()
	{
		wait.until(ExpectedConditions.visibilityOf(name)).sendKeys("Rishwa");
		cardno.sendKeys("584246756486");
		cvc.sendKeys("420");
		Month.sendKeys("02");
		year.sendKeys("2024");
		payConfirmOrder.click();
		 return wait.until(ExpectedConditions.visibilityOf(orderPlacedMsg)).getText();
	}
}
