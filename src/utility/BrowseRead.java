package utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowseRead extends BaseClass{
	public static  Logger logger= Logger.getLogger(BrowseRead.class.getName());
	
	public static void browserread(String brwosername ){
		
		  if (brwosername.equals("chrome")){
	 System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
			  driver = new ChromeDriver();
			  driver.manage().window().maximize();
			  logger.info("starting browser" +brwosername);
			  
			  //driver.navigate().refresh();
		  
		  }
		  else if(brwosername.equals("gecko")){
			  driver.get(prop.getProperty("gecko"));
			  
		  }
		  else if (brwosername.equals("IE")){
			  driver.get(prop.getProperty("IE")); 
			  driver = new InternetExplorerDriver();
		  }
		  else{
			System.out.println("browser name not found ");  
		  }
		  
	  }
}
