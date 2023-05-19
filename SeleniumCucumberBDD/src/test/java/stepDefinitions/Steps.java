package stepDefinitions;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import pageObjects.AddcustomerPage;



public class Steps extends baseClass{
	
	//Implement step definition methods here, for every step in a feature file.
	//copy from the generated feature console and paste the all feature step methods here.
	//And import the Given,when,then annotations io.cucumber.java.en.Given/when/Then
	
	
	/*-------------------keep this global variables inside the baseClass as a common code-------------------------
	//As a first step 
	//we need to interact with pageObject for that create a WebDriver driver;
	//At class level.
	public WebDriver driver;
	
	//As a second step;
	//We need to create a object of the constructor of the stepsdefiniton file(Steps).
	//and import the LoginPage: import pageObjects.LoginPage;
	//using the object we can access the all the pageObject methods/webements/actions.
	//constructor object lp instantiation at method level and pass the localdriver to map.
	public LoginPage lp;
	------------------------------------------------*/
	
	/*
	//Note: @cucumeber annotations and methods should only be written in stepsfile only. if you write in another file and extends it wont work.
	
	//to maintain setup part in separate method/to run on differnt browsers;
	@Before
	public void setup() throws IOException {
		
		//instantiate the configProp object here.
		//to read the properties from config.properties file.
		//and load object
		configProp=new Properties();
		FileInputStream configPropfile=new FileInputStream("config.properties");
		configProp.load(configPropfile);
		//now read to access the properties from config.properties file.
		
		String br=configProp.getProperty("browser");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		}
		else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver",configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();			
		}
		else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver",configProp.getProperty("iepath"));
			driver = new InternetExplorerDriver();			
		}
		
	}
	
	*/
	
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		
		
		//launch browser 1 way;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\psame\\Sameer_Work\\CucumberBDD\\SeleniumCucumberBDD\\Drivers\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		//launch browser 2 way:
		//WebDriverManager.chromedriver().setup();
		
		//local driver instantiation at method level and import ChromeDriver.
		driver = new ChromeDriver();
		
		//object instantiation and pass the local driver to map.
		lp = new LoginPage(driver);
	}

	
	
	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();

	}

	
	
	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		//here we are getting two parameters String email, String password from feature file.
		//lp constructor object is used to implement the pageobject methods.
		lp.setUserName(email);
		lp.setPassword(password);  //feature file value is passing to pageobjectMethod using string variable.
	}

	
	
	@When("Click on login")
	public void click_on_login() throws InterruptedException {
		lp.clickLogin();
		Thread.sleep(4000);
		
	}

	
	
	
	@SuppressWarnings("deprecation")
	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		//actually here we need to capture the title and compare with expected value.
		
		if(driver.getPageSource().contains("Login was unsuccessful"))
		{
			driver.close();
			Assert.assertTrue(false);
		}else 
		{
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	
	
	@When("User click on Logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		
		Thread.sleep(4000);
		lp.clickLogout();
	}


	
	@Then("close browser")
	public void close_browser() {
		driver.close();
	}
	
	
	
	
	
	//-------------------------------------------------------------------------------------------------------------
	//Customers feature --Steps definition methods.
	//easy way: run feature file as cucumberfeature and copy the unimplemented methods to here.
	
	
	// Add a new customer (scenario) methods
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		
		//to access the pageObjects of AddcustomerPage here
		//object instantiation and pass the local driver to map.
		addcust = new AddcustomerPage(driver);
		
		
		//we have create getpagetitle() method in pageobjects file. refer it.
		Assert.assertEquals("Dashboard / nopCommerce administration", addcust.getPageTitle());

	}

	
	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException 
	{
		Thread.sleep(3000);
		addcust.clickOnCustomersMenu();
	}

	
	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException 
	{
		Thread.sleep(3000);
		addcust.clickOnCustomersMenuItem();
	}

	
	
	@When("click on Add new button")
	public void click_on_add_new_button() 
	{
		addcust.clickOnAddItem();
	}

	////we have create getpagetitle() method in pageobjects file. refer it.
	//we can use the pageObject methods n number of times.
	@Then("User can view Add new customer page.")
	public void user_can_view_add_new_customer_page() throws InterruptedException 
	{
		Thread.sleep(3000);
		Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getPageTitle());
	}

	
	//without creating a object we can call (non void method) of baseClass/anyclass.
	//use the randomestring method data and append it to value and store it in email object.
	//pass the randomgenerated value to the setEmail field.
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException 
	{
		String email=randomestring()+"@gmail.com";
		addcust.setEmail(email);	
		addcust.setPassword("XYZ1234");
		
		//fill the form here using addcust object of AddcustomerPage objects repository.
		//addcust.setCustomersRoles("Administrators");
		Thread.sleep(3000);
		
		addcust.setManagerOfVendor("Vendor 2");
		addcust.setAdminContent("this for testing----------");

		addcust.setGender("Male");
		addcust.setFirstName("Pavan");
		addcust.setLastName("Patan");
		addcust.setDob("1/29/1995");
		addcust.setCompanyName("OSI");
	}

	
	
	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException 
	{
		addcust.clickOnSave();
		Thread.sleep(3000);
	}

	
	//
	@Then("User can view confirmation mesage {string}")
	public void user_can_view_confirmation_mesage(String msg) 
	{
		Assert.assertTrue(addcust.getSuccessMessage().contains("The new customer has been added successfully."));

	}
	
	
	
	
	
	
	//Step methods for searching a customer by using email id.
	//scenario2: step methods
	@When("Enter customer EMail")
	public void enter_customer_e_mail() throws InterruptedException {
		
		//to access the pageObjects of searchCustomerPage here
		//import the add the public SearchCustomerPage searchcust; at baseClass.java
		//create -object instantiation & import and pass the local driver to map.
		searchcust=new SearchCustomerPage(driver);
		Thread.sleep(5000);
		searchcust.setEMailID("victoria_victoria@nopCommerce.com");

	}
	
	@When("User click on search button")
	public void user_click_on_search_button() throws InterruptedException {
		searchcust.clickSearch();
		Thread.sleep(5000);

	}
	
	
	@Then("User should found EMail in the Search table")
	public void user_should_found_e_mail_in_the_search_table() {
		
		//passing the value is to verify the search/given value present in the table or not.
		boolean status=searchcust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		//to make test pass/fail clarification.
		Assert.assertEquals(true, status);

	}
	
	
	
	//Note: for every new scenario we must have do object instantiation (mandatory)
	
	//Step methods for searching a customer by using firstname and lastname.
	//scenario3: step methods
	
	@When("Enter customer FirstName")
	public void enter_customer_first_name() throws InterruptedException {
		
		//to access the pageObjects of searchCustomerPage here
		//import the add the public SearchCustomerPage searchcust; at baseClass.java
		//create -object instantiation & import and pass the local driver to map.
		searchcust=new SearchCustomerPage(driver);
		Thread.sleep(5000);
		searchcust.setFirstName("Victoria");

	}
	
	
	@When("Enter customer LastName")
	public void enter_customer_last_name() throws InterruptedException {
		searchcust.setLastName("Terces");

	}
	
	
	
	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		
		boolean status=searchcust.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);

	}

	
	


}
