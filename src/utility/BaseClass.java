package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class BaseClass {
	public static  Logger logger= Logger.getLogger(BaseClass.class.getName());
	public static WebDriver driver;
	public static Properties prop ;
	public BaseClass(){
		
		try{
			propertyRead();
		}catch(Exception e){

		}
	}
	
	public static void  propertyRead() throws IOException{
		prop = new Properties();
		File file  = new File("D:\\workspaceneon\\Selenium_project\\object.properties");
		FileInputStream finpt = new FileInputStream(file);
		prop.load(finpt);
	}
	
	public static void log4jconfigure(){
		String log4jconfPath = "Log4j.properties";//System.getProperty("D:\\workspaceneon\\Selenium_project\\src\\Log4j.properties");
		PropertyConfigurator.configure(log4jconfPath);
	}


}
