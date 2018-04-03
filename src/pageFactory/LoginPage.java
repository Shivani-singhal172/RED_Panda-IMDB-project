package pageFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import utility.BaseClass;
import utility.Takescreenshot;

public class LoginPage extends BaseClass {
	public static final Logger logger= Logger.getLogger(LoginPage.class.getName());

	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}


	@FindBy(how = How.NAME, using = "emailid")
	WebElement email;

	@FindBy(how = How.XPATH, using = "//*[@id='navbar-brand-centered']/ul/li[1]")
	WebElement drpdwn;

	@FindBy(how = How.XPATH, using = "//*[@id='navbar-brand-centered']/ul/li[1]/ul/li[11]/a")
	WebElement Login;

	@FindBy(how = How.ID, using ="email")
	WebElement USRname;

	@FindBy(how = How.ID, using = "passw")
	WebElement Password;

	@FindBy(how = How.XPATH, using = "//div/div/h3")
	WebElement Loginvaliadtion;


	public String email(String emailtext){
		email.sendKeys(emailtext);
		Takescreenshot.screenshot(driver, "email");
		logger.info("email is entered");
		email.submit();
		drpdwn.click();
		Takescreenshot.screenshot(driver, "homepage");
		logger.info("navigated to login page");
		Login.click();
		USRname.sendKeys(prop.getProperty("Usrname"));
		logger.info("user name is entered" +prop.getProperty("Usrname"));
		Password.sendKeys(prop.getProperty("paswrd"));
		logger.info("password is entered" +prop.getProperty("paswrd"));
		Takescreenshot.screenshot(driver, "Loginpage");
		Password.sendKeys(Keys.ENTER);
		Takescreenshot.screenshot(driver, "successfullylogedin");
		return Loginvaliadtion.getText();
	}
}
