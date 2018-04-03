package utility;

import org.apache.log4j.Logger;

import utility.BaseClass;

public class UrlLaunch extends BaseClass{
	public static  Logger logger= Logger.getLogger(UrlLaunch.class.getName());
	public void launchUrl(String URL){
		driver.get(URL);
		logger.info("initializing" +URL);
	}
}
