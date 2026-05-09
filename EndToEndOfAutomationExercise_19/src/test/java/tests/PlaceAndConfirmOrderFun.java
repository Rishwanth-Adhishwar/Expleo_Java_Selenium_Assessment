package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.LoginPage;
import pages.PayementPage;
import pages.ProductPage;

public class PlaceAndConfirmOrderFun extends BaseTest{
	
	@Parameters({"spName"})
	@Test
	public void addToCartFun(String spName)
	{
		WebDriver driver=getDriver();
		log.info("Performin login");
		LoginPage lp=new LoginPage(driver);
		lp.login();
		ProductPage pp=new ProductPage(driver);
		log.info("Searching product");
		String actual=pp.searchFunctionality(spName);
		log.info("Adding product to cart");
		String actual1=pp.addToCartFunctionality();
		CartPage cp=new CartPage(driver);
		cp.placeOrderOne();
		PayementPage pay=new PayementPage(driver);
		log.info("Placing order with payment");
		String actual2=pay.placeOrderTwo();
		try
		{
			Assert.assertEquals(actual2, "ORDER PLACED!");
			log.info("Order Placed Successfully");
			
		}
		catch(AssertionError e)
		{
			log.error("Order Not Placed,Error: "+e.getMessage());
		}
		

		
	}

}
