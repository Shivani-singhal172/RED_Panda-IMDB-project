package testCases;


import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;

import utility.BrowseRead;
import utility.Listener;
import utility.UrlLaunch;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.JDBCconnection;
import pageFactory.IMDBpagefactry;
import utility.BaseClass;
@Listeners(Listener.class)

public class IMDB extends BaseClass{
	BrowseRead browserobj = new BrowseRead(); 
	UrlLaunch urllaunch = new UrlLaunch();
	Listener lis = new Listener();
	Logger logger= Logger.getLogger(IMDB.class.getName());
	@BeforeTest
	public void launch_webpage(){
		JDBCconnection.createtable();
        BrowseRead.browserread("chrome"); 
		urllaunch.launchUrl(prop.getProperty("URLIMDB"));
		log4jconfigure();
	}
	@Test 
	public void getdata(){
		IMDBpagefactry.getdataimdb();
	}

	@AfterTest
	public void endtest(){
		driver.quit();
	}
}
