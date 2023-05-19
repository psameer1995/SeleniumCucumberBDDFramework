package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	
	//create a local WebDriver driver as global variable to access in all AddcustomerPage class Level methods.
	WebDriver ldriver;
	
	//create a global variable of WaitHelper class. bcz this variable will be used across the SearchCustomerPage class level.
	WaitHelper waithelper;
	
	//Create a Constructor with same class name, which is used to access the created methods from the stepDefiniton files.
	//constructor driver is a runner driver (rdriver) to access form step definitons.
	//PageFactory is Selenium class which is used to initalize the Webelements.
	public SearchCustomerPage(WebDriver driver) {
		this.ldriver = driver;
		PageFactory.initElements(driver, this);
		
		//to utilize the WaitHelper methods here, we need to create a object of the WaitHelper clas constructor and we can call it.
		//instantition.
		waithelper=new WaitHelper(ldriver);
		
	}
	
	
	
	
	//Locators------------------------------------------------------------
	By txtEmail = By.xpath("//input[@id='SearchEmail']");
	By txtFirstName=By.xpath("//input[@id='SearchFirstName']");
	By txtLastName = By.xpath("//input[@id='SearchLastName']");
	By btnSearch = By.xpath("//button[@id='search-customers']");
	By table=By.xpath("//div[@id='customers-grid_wrapper']");
	//By tableRows=By.xpath("//div[@id='customers-grid_wrapper']//tbody/tr");
	//By tableCols=By.xpath("//div[@id='customers-grid_wrapper']//tbody/tr/td");
	
	//ifnotworks
	/*
	By table=By.xpath("//table[@id='customers-grid_wrapper']");
	By tableRows=By.xpath("//table[@id='customers-grid_wrapper']//tbody/tr");
	By tableCols=By.xpath("//table[@id='customers-grid_wrapper']//tbody/tr/td");
	*/
	
	//to keep multiple data we have to write inside the webElement like below.

	
    @FindAll(@FindBy(how = How.XPATH, using = "//div[@id='customers-grid_wrapper']//tbody/tr"))
    List<WebElement> tableRows;

    @FindAll(@FindBy(how = How.XPATH, using = "//div[@id='customers-grid_wrapper']//tbody/tr/td"))
    List<WebElement> tableCols;
    
    
    
    
	//ActionMethods---------------------------
    
    public void setEMailID(String email) throws InterruptedException {
    	
    	//using Waithelper variable we can define the explicity wait for each webelement.
    	
    	//waithelper.waitforElement(txtEmail,30);
    	//waithelper.wait(30);
    	
    	//define the created webelement and actions here.
    	ldriver.findElement(txtEmail).clear();
    	ldriver.findElement(txtEmail).sendKeys(email);

    }
    
    
    public void setFirstName(String fname) throws InterruptedException {
    	//waithelper.wait(30);
    	ldriver.findElement(txtFirstName).clear();
    	ldriver.findElement(txtFirstName).sendKeys(fname);

    }
    
    
    public void setLastName(String lname) throws InterruptedException {
    	ldriver.findElement(txtLastName).clear();
    	ldriver.findElement(txtLastName).sendKeys(lname);

    }   
    
    public void clickSearch() throws InterruptedException {
    	ldriver.findElement(btnSearch).click();
    	//waithelper.wait(30);
		//to scroll down:
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("window.scrollBy(0,350)", "");
    }
    
     
    
    //Additional methods to get the size of rows and columns of a table.
    //another way of calling the locators for  @FindAll locator is.
    public int getNoOfRows() {
    	return (tableRows.size());
    }
    
   
    public int getNoOfColumns() {
    	return (tableCols.size());
    }
    
    
    
    //scenario2: additional pageObject method to search the customer by emailId:.
    //Write a logic to loop the whole table for the searched record/item. if the email id or name have multple records inside a table..
    //if it a non void method then return must.
    
    public boolean searchCustomerByEmail(String email1) {
    	
    	//define boolean flag as defualt false as no record found on the data table. as a first step.(just as a declaration)
    	//i<=getNoOfRows() method will be called from above-and verify the condition.
    	boolean flag=false;
    	
    	for(int i=1; i<=getNoOfRows(); i++) {
    		
    		String emailid=ldriver.findElement(By.xpath("//div[@id='customers-grid_wrapper']//tbody/tr["+i+"]/td[2]")).getText();
    		System.out.println(emailid);
    		
    		//email1 is coming from actual test/feature/wecan hardcode in stepmethod by passing value.
    		if(emailid.equals(email1))
    		{
    			flag=true;
    			//if match found then flag status will be true. and give the boolean status as "True."
    		}
    	}
		return flag;
    		
    }
    
    
  //scenario3; additional pageObject method to search the customer by firstName and SecondName.
    public boolean searchCustomerByName(String Name) {
    	
    	//define boolean flag as defualt false as no record found on the data table. as a first step.(just as a declaration)
    	//i<=getNoOfRows() method will be called from above-and verify the condition.
    	//td[3] is for Name column on the datatable.
    	
    	boolean flag=false;
    	
    	for(int i=1; i<=getNoOfRows(); i++) {
    		
    		String name=ldriver.findElement(By.xpath("//div[@id='customers-grid_wrapper']//tbody/tr["+i+"]/td[3]")).getText();
    		System.out.println(name);
    	
    		//spliting the captured name using "space" to verify firstname and lastname.
    		//String arraytype[]variable hold two values now. using index 0,1.
    		String names[]=name.split(" ");
    		
    		//Values is coming from actual test/feature/wecan hardcode in stepmethods by passing value.
    		if(names[0].equals("Victoria") && names[1].equals("Terces"))
    		{
    			flag=true;
    			//if match found then flag status will be true. and give the boolean status as "True."
    		}
    	}
		return flag;
    		
    }
    
    
    


}
