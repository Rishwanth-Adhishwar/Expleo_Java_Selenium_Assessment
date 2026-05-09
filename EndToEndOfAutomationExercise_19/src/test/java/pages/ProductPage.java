package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

	public ProductPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath="//input[@id='search_product']")
	WebElement searchBox;
	
	@FindBy (xpath="//button[@id='submit_search']")
	WebElement clickSearchIcon;
	
	@FindBy (css="div[class='productinfo text-center'] p")
	WebElement searchResult;
	
	@FindBy (xpath="//div[@class='productinfo text-center']//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart']")
	WebElement addToCartButton;
	
	@FindBy (xpath="//u[normalize-space()='View Cart']")
	WebElement viewCartButton;
	
	@FindBy (xpath="//a[normalize-space()='Men Tshirt']")
	WebElement cartElement;
	
	
	public String searchFunctionality(String prodName)
	{
		wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(prodName);
		clickSearchIcon.click();
		return wait.until(ExpectedConditions.visibilityOf(searchResult)).getText();
	}
	
	public String addToCartFunctionality()
	{
		addToCartButton.click();
		wait.until(ExpectedConditions.visibilityOf(viewCartButton)).click();
		return wait.until(ExpectedConditions.visibilityOf(cartElement)).getText();
		
	}
}
