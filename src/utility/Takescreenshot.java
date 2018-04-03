package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Takescreenshot {
	public static  Logger logger= Logger.getLogger(Takescreenshot.class.getName());
	
	public static  void screenshot(WebDriver driver , String filename   ) {
		new Takescreenshot();
		try{
			
			
			File screenshot = 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE );
			String screenshotpath =new File(System.getProperty("user.dir")).getAbsolutePath()+"\\screenshot" ;
			File scrpath = new File((String)screenshotpath+"\\" +TodayDate()+"\\"+filename+".png");
			FileUtils.copyFile(screenshot, scrpath );
		}catch (Exception e){
			e.printStackTrace();
		}
	 logger.info("initializing screenshot");
	 logger.info("the date getting form calenadr " +TodayDate());
	}

	public static String TodayDate(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return formater.format(calendar.getTime());
		/*DateFormat dt = new SimpleDateFormat("MMM,dd,yy");
		Date Todaydt  = new Date();
		String date1 = dt.format(Todaydt);*/
		//return date1;
	}

}

/*public Takescreenshot(){
	String scrfolder = "D:\\workspaceneon\\Selenium_project\\screenshot\\";
	new File(scrfolder).mkdir();
	System.setProperty("scr.folder", scrfolder);
}*/