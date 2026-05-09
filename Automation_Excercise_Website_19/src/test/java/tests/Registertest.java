package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loginpage;

public class Registertest extends Basetest {
	
	@Test(priority=0,dataProvider="newRegister",dataProviderClass=utils.ExcelDataDriven.class)
	public void newRegister(String uname,String uemail)
	{
		WebDriver driver=getDriver();
		Loginpage lp=new Loginpage(driver);
		log.info("Entering new username: "+uname+"\nEntering new email: "+uemail+"\nEntering Details");
		lp.registerAccount(uname,uemail, "Rishwa2k26","Rishwanth","Adhishwar","Narayanan Street", 3,"Tamilnadu","Salem","636002","3456789012");
		String actual=lp.registerSuccess();
	    try
	    {
	    	Assert.assertEquals(actual,"ACCOUNT CREATED!");
	    	log.info("New Account Created Successfully");
	    }
	    catch(AssertionError e)
	    {
	    	log.error("Account creation fails,Error: "+e.getMessage());
	    }
	}
	
	@Test(priority=1,dataProvider="duplicateRegister",dataProviderClass=utils.ExcelDataDriven.class)
	public void invalidRegister(String uname,String uemail)
	{
		WebDriver driver=getDriver();
		Loginpage lp=new Loginpage(driver);
		log.info("Entering new username: "+uname+"\nEntering new email: "+uemail);
		lp.registerAccWithExistEmail(uname, uemail);
		String actual=lp.registerErrorMessage();
	    try
	    {
	    	Assert.assertEquals(actual,"Email Address already exist!");
	    	log.info("invalid register error message thrown Successfully");
	    }
	    catch(AssertionError e)
	    {
	    	log.error("Registering with invalid credentials Fails,Error: "+e.getMessage());
	    }
	}


}
