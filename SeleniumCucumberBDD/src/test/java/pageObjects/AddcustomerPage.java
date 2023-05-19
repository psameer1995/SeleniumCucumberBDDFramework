package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage {

	//create a local WebDriver driver as global variable to access in all AddcustomerPage class Level methods.
	private WebDriver ldriver;

	
	//Create a Constructor with same class name, which is used to access the created methods from the stepDefiniton files.
	//constructor driver is a runner driver (rdriver) to access form step definitons.
	//PageFactory is Selenium class which is used to initalize the Webelements.
	public AddcustomerPage(WebDriver driver) {
		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Locators------------------------------------------------------------
	By lnkcustomersMenu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkcusotmers_menuItem=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	By btnAddnew = By.xpath("//a[normalize-space()='Add new']");
	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");
	

	By txtcustomerRoles = By.xpath("//div[@class='input-group-append input-group-required']");
	By lstitemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemRegistered = By.xpath("//li[contains(text(),'Registered')]");
	By lstitemGuests = By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors = By.xpath("//li[contains(text(),'vendors')]");
	
	By drpmgrOfVendor = By.xpath("//*[@id='VendorId']");
	By rdMaleGender = By.xpath("//input[@id='Gender_Male']");
	By rdFeMaleGender = By.xpath("//input[@id='Gender_Female']");
	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");
	By txtDob = By.xpath("//input[@id='DateOfBirth']");
	By txtCompanyName = By.xpath("//input[@id='Company']");
	By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");
	By btnSave = By.xpath("//button[@name='save']");
	
	By successMsg=By.xpath("//div[@class='content-wrapper']");

	
	
	
	//ActionMethods---------------------------
	
	//one method newly added which is not there in feature file, but just to validate the title as checklist to start of these testcase.
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	
	public void clickOnCustomersMenu() {
		ldriver.findElement(lnkcustomersMenu).click();
		
	}
	
	public void clickOnCustomersMenuItem() {
		ldriver.findElement(lnkcusotmers_menuItem).click();
		
	}
	
	
	public void clickOnAddItem() {
		ldriver.findElement(btnAddnew).click();
		
	}
	
	
	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
		
	}
	
	public void setPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
		
	}	
	
	
	//dropdown
	public void setCustomersRoles(String role) throws InterruptedException {
		

		ldriver.findElement(txtcustomerRoles).click();
		
		WebElement listitem;
		
		Thread.sleep(5000);
		
		if(role.equals("Administrators")) 
		{
			listitem=ldriver.findElement(lstitemAdministrators);
		}
		
		else if(role.equals("Guests")) 
		{
			listitem=ldriver.findElement(lstitemGuests);
		}
		
		else if(role.equals("Registered")) 
		{
			listitem=ldriver.findElement(lstitemRegistered);
		}
		
		else if(role.equals("Vendors")) 
		{
			listitem=ldriver.findElement(lstitemVendors);
		}
		else
		{
			listitem=ldriver.findElement(lstitemGuests);
		}
		
		listitem.click();
		
		/*
		//if click() action not works use JavascriptExecutor to click the action.
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("argument[0].click();", listitem);	
		*/
		
		//to scroll down:
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("window.scrollBy(0,350)", "");
		
	}
	
	
	
	//its a dropdown and we are using Select class to handle it.
	//String value is coming from actual testcase/feature file.
	public void setManagerOfVendor(String value1)
	{
		
		Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value1);
	}
	
	
	
	//radio buttons selection (male/female)
	//gender is coming from the test case/feature file.
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdMaleGender).click();
		}
		else if(gender.equals("Female"))
		{
			ldriver.findElement(rdFeMaleGender).click();
		}
		else
		{
			ldriver.findElement(rdMaleGender).click();   //as default option.
		}
	}
	
	//String parameter value is coming from feature file. via steps definition file when it called pageObjects.
	public void setFirstName(String fname)
	{
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		ldriver.findElement(txtLastName).sendKeys(lname);
	}
	
	public void setDob(String dob) 
	{
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	
	
	public void setCompanyName(String comname) 
	{
		ldriver.findElement(txtCompanyName).sendKeys(comname);
	}
	
	public void setAdminContent(String content)
	{
		ldriver.findElement(txtAdminContent).sendKeys(content);
		
		//to perform scroll up
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("window.scrollBy(0,-350)", "");
	}
	
	public void clickOnSave()
	{
		ldriver.findElement(btnSave).click();
	}
	
	//only used under the validation.
	public String getSuccessMessage() {
		String obj1=ldriver.findElement(successMsg).getText();
		return obj1;

	}
	

}
