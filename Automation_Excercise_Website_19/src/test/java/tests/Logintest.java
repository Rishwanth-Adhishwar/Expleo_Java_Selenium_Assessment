package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Loginpage;

public class Logintest extends Basetest {
	
	@Test(priority=2,dataProvider="vLogin",dataProviderClass=utils.ExcelDataDriven.class)
	public void vLoginTest(String emailL,String passL)
	{
		WebDriver driver= getDriver();
		Loginpage lp=new Loginpage(driver);
		log.info("Entering valid Email: "+emailL+"\nEnetering valid Password");
		lp.login(emailL, passL);
		String actual=lp.logSuccess();
		try
		{
			Assert.assertEquals(actual,"Logged in as rishwanth16");
			log.info("Login Successfull");
			
		}catch(AssertionError e)
		{
			log.error("Login Unsuccesful,A error message thrown: "+e.getMessage());
		}
	}
	
	@Test(priority=3,dataProvider="inLogin",dataProviderClass=utils.ExcelDataDriven.class)
	public void iVLoginTest(String emailL,String passL)
	{
		WebDriver driver= getDriver();
		Loginpage lp=new Loginpage(driver);
		log.info("Entering valid Email: "+emailL+"\nEnetering invalid Password");
		lp.login(emailL, passL);
		String actual=lp.logErrorMessage();
		try
		{
			Assert.assertEquals(actual,"Your email or password is incorrect!");
			log.info("Got Error message for invalid login");
			
		}catch(AssertionError e)
		{
			log.error("login test fails for invalid case: "+e.getMessage());
		}
	}

}
