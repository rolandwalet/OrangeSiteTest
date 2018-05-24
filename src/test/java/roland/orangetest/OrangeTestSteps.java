package roland.orangetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeTestSteps {
	
	private ExtentReports report;
	private ExtentTest test;
	private WebDriver driver;
	private OrangeLandingPage landingPage;
	private OrangeAddEmployeePage addPage;
	private OrangeEmployeeDetailsPage detailsPage;
	
	
	@Before
	public void setup() {
		//**WARNING** Check Web Driver is correctly placed before running - or edit file path below
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\WebDev\\chromedriver_win32\\chromedriver.exe");
		
		//**WARNING** Check Report output is pointing to correct location before running
		//**WARNING** Will overwrite previous reports
		report = new ExtentReports("C:\\Users\\Admin\\Java EE\\OrangeTest\\reports\\orange-report.html", true);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://opensource.demo.orangehrmlive.com/index.php/auth/login");
		
		landingPage = PageFactory.initElements(driver, OrangeLandingPage.class);
		landingPage.login("Admin", "admin");
		
		
	}
	
	@Given("^the Add Employee Tab$")
	public void the_Add_Employee_Tab() {
		test = report.startTest("Test Login Feature");
		test.log(LogStatus.INFO, "Accessing add employee page...");
		driver.get("http://opensource.demo.orangehrmlive.com/index.php/pim/addEmployee");
		test.log(LogStatus.PASS, "Success");
	}
	
	@When("^I fill out the Employee Details correctly$")
	public void i_fill_out_the_Employee_Details_correctly() {
		test.log(LogStatus.INFO, "Entering new employee details...");
		addPage = PageFactory.initElements(driver, OrangeAddEmployeePage.class);
		addPage.enterFirstName("Joe");
		addPage.enterLastName("Bloggs");
		addPage.enterEmployeeID("5263");
	}
	
	@When("^I choose to create Login Details$")
	public void i_choose_to_create_Login_Details() {
		test.log(LogStatus.INFO, "Ticking create login details...");
		addPage.toggleLoginCheck();
	}
	
	@When("^I fill out the Login Details correctly$")
	public void i_fill_out_the_Login_Details_correctly() {
		test.log(LogStatus.INFO, "Creating login information...");
		addPage.setUserName("jbloggs2");
		addPage.setPassword("password");
	}
	
	@When("^I click the Save button$")
	public void i_click_the_Save_button() {
		test.log(LogStatus.INFO, "Saving employee details...");
		addPage.clickSave();
	}
	
	@Then("^I can see information about the user$")
	public void i_can_see_information_about_the_user() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		detailsPage = PageFactory.initElements(driver, OrangeEmployeeDetailsPage.class);
		if (detailsPage.getNameField().getText().equals("Joe Bloggs")) {
			test.log(LogStatus.PASS, "Success");
		} else {
			test.log(LogStatus.FAIL, "Unsuccessful");
		}
		assertEquals("Joe Bloggs", detailsPage.getNameField().getText());
	}
	
	@After
	public void teardown() {
		driver.close();
	}
	
}
