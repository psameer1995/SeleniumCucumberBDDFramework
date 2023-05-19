package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import java.util.Properties;


//imported the linked file of steps.java here.
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class baseClass {

	
	//keep the common code of Steps.java file here and extends the baseClass inside the Steps.javafile
	//if the steps.java file code linked to otherfile (then that linked file we need to import here)
	
	//GlobalVariables of Steps.java file.
	public WebDriver driver;
	public LoginPage lp;
	public AddcustomerPage addcust;
	public SearchCustomerPage searchcust;
	
	
	//to configure properties files.
	public Properties configProp;

	
	
	
	
	
	
	//Create a method to generate the random string data for unique email id
	public static String randomestring() {
		
		//RandomStringutils is a apache class which contains so many methods to generate data.
		//for non void method- we must need to write return with some value object/variable.
		
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
		
	}
	
	
}
