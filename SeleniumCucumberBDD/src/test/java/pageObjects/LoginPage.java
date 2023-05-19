package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//create a local WebDriver driver as global variable to access in all this -class Level methods.
	public WebDriver ldriver;
	
	//Create a Constructor with same class name, which is used to access the created methods from the stepDefiniton files.
	//constructor driver is a runner driver (rdriver) to access form step definitons.
	//PageFactory is Selenium class which is used to initalize the Webelements.
	public LoginPage(WebDriver driver) {
		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Locators------------------------------------------------------------
	By txtEmail = By.id("Email");
	By txtPassword = By.id("Password");
	By btnLogin = By.xpath("//button[normalize-space()='Log in']");
	By lnkLogout = By.linkText("Logout"); //<a>Logout</a> tag text
	
	
	
	
	//Action methods-------------------------------------------------------------------
	public void setUserName(String uname) {	
		//use local driver and inside findElement add the created By object.
		//String uname and .sendKeys(uname) value is passing from the feature file.
		ldriver.findElement(txtEmail).click();
		ldriver.findElement(txtEmail).clear();
		ldriver.findElement(txtEmail).sendKeys(uname);
	}
	
	
	public void setPassword(String pwd) {	
		//use local driver and inside findElement add the created By object.
		//String pwd and .sendKeys(pwd) value is passing from the feature file.
		ldriver.findElement(txtPassword).click();
		ldriver.findElement(txtPassword).clear();
		ldriver.findElement(txtPassword).sendKeys(pwd);
	}
	
	
	public void clickLogin() {
		ldriver.findElement(btnLogin).click();
	}
	
	public void clickLogout() throws InterruptedException {
		ldriver.findElement(lnkLogout).click();
	}
		
	

}
