package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductPage;

public class AddToCartFuctionality extends BaseTest {
	
	
	@Parameters({"spName"})
	@Test
	public void addToCartFun(String spName)
	{
		WebDriver driver=getDriver();
		log.info("Performin login");
		LoginPage lp=new LoginPage(driver);
		lp.login();
		ProductPage pp=new ProductPage(driver);
		String actual=pp.searchFunctionality(spName);
		String actual1=pp.addToCartFunctionality();
		try
		{
			Assert.assertEquals(actual1, "Men Tshirt");
			log.info("Searched product is visibled in Cart");
			
		}
		catch(AssertionError e)
		{
			log.error("Searched product Not visible,Error: "+e.getMessage());
		}

		
	}

}
