package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath="//a[normalize-space()='Proceed To Checkout']")
	WebElement checkoutButton;
	
	@FindBy(xpath="//a[normalize-space()='Place Order']")
	WebElement placeOrderButton;
	
	
	public void placeOrderOne()
	{
		wait.until(ExpectedConditions.visibilityOf(checkoutButton)).click();
		wait.until(ExpectedConditions.visibilityOf(placeOrderButton)).click();
		
	}

}
