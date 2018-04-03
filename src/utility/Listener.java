package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener extends BaseClass implements ITestListener{
	
	
	
	public static  Logger logger= Logger.getLogger(Takescreenshot.class.getName());

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		 
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss"); 
		
		String methodname = result.getName();
		if(!result.isSuccess()){
			
			File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try{
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() +"/Failurescreenshot";
				File destfile = new File((String) reportDirectory +methodname + "_" +formater.format(calendar.getTime()) + ".png");
				FileUtils.copyFile(scrfile, destfile);
				Reporter.log("<a href='" +destfile.getAbsolutePath() +"'> <img src='" +destfile.getAbsolutePath() +"' height ='100' width = '100'/></a>");
				
				
			}
			catch(IOException e ){
				e.printStackTrace();
				
			}
			
		}
		logger.error("the method has failed" +methodname);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
