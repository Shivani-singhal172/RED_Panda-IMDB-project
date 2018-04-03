package testCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageFactory.LoginPage;
import utility.BaseClass;
import utility.BrowseRead;
import utility.Listener;
import utility.UrlLaunch;
@Listeners(Listener.class)
public class Guru99Login extends BaseClass {
	BrowseRead browserobj = new BrowseRead(); 
	UrlLaunch urllaunch = new UrlLaunch();
	Listener lis = new Listener();
	

	Logger logger= Logger.getLogger(Guru99Login.class.getName());

	@BeforeTest
	public void launch_webpage(){
		BrowseRead.browserread("chrome"); 
		urllaunch.launchUrl(prop.getProperty("URL"));
		log4jconfigure();
	}

	@Test
	public void test(){
		LoginPage pg = new LoginPage(driver);
		String ret =  pg.email("shivani.singhal172@gmail.com");
		Assert.assertEquals(ret, "Successfully Logged in...");
	}

	@AfterTest
	public void endtest(){
		driver.quit();
	}

}

