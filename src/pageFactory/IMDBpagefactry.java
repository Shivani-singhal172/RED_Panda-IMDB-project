package pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;
import utility.BrowseRead;
import utility.JDBCconnection;
import utility.UrlLaunch;

public class IMDBpagefactry extends BaseClass {
	JDBCconnection objdbc = new JDBCconnection();
	static String rowsdata ;
	int i , j = 0;
	public static void getdataimdb(){
		List<WebElement> rowofimdb= driver.findElements(By.xpath("//*[@id='main']/div/span/div/div/div[3]/table/tbody/tr"));
		String nameofmovie= null;
		String rating = null;
		String yearofmovie = null;
		System.out.println("the total no of rows "+rowofimdb.size()); 
		for (int i=1 ; i<rowofimdb.size() ;i++){
			
			rowsdata = driver.findElement(By.xpath("//*[@id='main']/div/span/div/div/div[3]/table/tbody/tr["+i+"]")).getText();
			nameofmovie = driver.findElement(By.xpath("//*[@id='main']/div/span/div/div/div[3]/table/tbody/tr["+i+"]/td[2]/a")).getText();
			yearofmovie =driver.findElement(By.xpath("//*[@id='main']/div/span/div/div/div[3]/table/tbody/tr["+i+"]/td[2]/span")).getText();
			rating = driver.findElement(By.xpath("//*[@id='main']/div/span/div/div/div[3]/table/tbody/tr["+i+"]/td[3]")).getText();
			JDBCconnection.insert(yearofmovie, nameofmovie, rating);
			System.out.println("The year of releaase:" +yearofmovie +"Movie name" +nameofmovie +"rating" +rating);
			//System.out.println(nameofmovie);
			//System.out.println(rating);
		}

	}

}

