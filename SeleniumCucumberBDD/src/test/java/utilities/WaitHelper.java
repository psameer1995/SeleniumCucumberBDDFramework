package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	//create a variable of WebDriver driver;
	//And create a constructor - so that we utilise the methods in other class using the constructor.
	//
	
	public WebDriver driver;
	
	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}

	
	
	//create a common code like: user define method (ex: WaitForelement)
	
	public void WaitForElement(WebElement element,Duration timeOutInSeconds) {
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
}
