

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class SmartMember

{
	public static WebDriver driver;
	
	@BeforeTest
	public static void login() 
	{
		
		System.setProperty("webdriver.chrome.driver","D:/QA/chromedriver_win32 (1)/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://192.168.1.21:9213/#/");
		
	}
	
	@Test(priority = 0)
	
	public void loginTest() throws InterruptedException
	{
		
		  ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/SmartMember.html");
		    
		  ExtentReports extent = new ExtentReports();
		 
		  extent.attachReporter(reporter);
		  
		  ExtentTest logger = (ExtentTest) extent.createTest("Title Verified Test");
		  
		  if(driver.getTitle().equals("SmartTown Portal"))
		  {
			  logger.log(Status.INFO, "Open the Browser and Enter Valid URL");
			  
			  logger.log(Status.INFO, "Welcome to SmartTown Portal");
			  
			  logger.log(Status.PASS, "Title Verified and Welcome to SmartTown Portal");  
		  }
		  
		  else
		  {
			  logger.log(Status.FAIL, "Title is not Verified and Mismatch");
			  
		  }
		 
		  ExtentTest logger2 =  (ExtentTest) extent.createTest("Valid Login Test");
		  
		  driver.findElement(By.id("btnSave")).click();
		  
		  logger2.log(Status.INFO, "Redirected to the Signin Page");
		  
		  driver.findElement(By.id("txtUserName")).click();
		  
		  driver.findElement(By.id("txtUserName")).sendKeys("9909900457");
		  
		  Thread.sleep(2000);
		  
		  logger2.log(Status.INFO, "Enter Valid Username");
		  
		  driver.findElement(By.id("txtPwd")).click();
		  
		  driver.findElement(By.id("txtPwd")).sendKeys("9909900457");
		  
		  logger2.log(Status.INFO, "Enter Valid Password");
		  
		  Thread.sleep(2000);
		  
		  driver.findElement(By.id("btnSave")).click();
		  
		  logger2.log(Status.PASS, "Signin Successfully.");
		  
		  ExtentTest logger3 = (ExtentTest) extent.createTest("Gate Activity Test");
		  
		  Thread.sleep(2000);
		  
		  logger3.log(Status.INFO, "Redirect and click on Gate Activities Menu");
		  
		  driver.findElement(By.id("liActivity")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.linkText("Pre-Gate Entry")).click();
		  
		  logger3.log(Status.INFO, "click on Pre-Gate Entry");
		  
		  Thread.sleep(2000);
		  
		  driver.findElement(By.id("addVisitor")).click();
		  
		  driver.findElement(By.id("complainsusubmit")).click();
		  
		  String errorMesg = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div")).getText();
		  Thread.sleep(2000);
		  
		  if(errorMesg.equals("Please enter visitor date time."))
		  {
			  	logger3.log(Status.FAIL, "Empty Mandatory and Optional Fields of Visitor Entry");
		  }
		  else
		  {
			  logger3.log(Status.FAIL, "Not Enter Mandatory and Optional Fields of Visitor");
		  }
		  
		  driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
		  
		  logger3.log(Status.INFO, "Enter Mandatory Field and Click on Submit Button");
		  
		  Thread.sleep(2000);
		  
		  driver.findElement(By.id("txtVisitorDateTime")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("txtVisitorDateTime")).sendKeys("12/13/2019 16:34");
		  Thread.sleep(2000);
		  driver.findElement(By.id("txtVisitorName")).sendKeys("viraj");
		  Thread.sleep(2000);
		  driver.findElement(By.id("txtMobileNo")).sendKeys("9898831709");
		  Thread.sleep(2000);
		  driver.findElement(By.id("txtNoOfPerson")).sendKeys("1");
		  Thread.sleep(2000);
		  driver.findElement(By.id("complainsusubmit")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
		  
		  logger3.log(Status.PASS, "Visitor Entry is Added Successfully.");
		  
		  ExtentTest logger4 = (ExtentTest) extent.createTest("Guidelines Test");
		  
		  Thread.sleep(2000);
		  
		  logger4.log(Status.INFO, "Click on Guidelines Menu");
		  
		  logger4.log(Status.INFO, "Redirect to Guidelines Page");
		  
		  driver.findElement(By.id("liGuidelines")).click();
		  
		  Thread.sleep(2000);
		  
		  logger4.log(Status.PASS, "Guidelines Title is seen successfully.");
		  
		  ExtentTest logger5 = (ExtentTest) extent.createTest("My Township Test");
		  
		  logger5.log(Status.INFO, "Click on MY TOWNSHIP Button");
		  driver.findElement(By.id("liTowenship")).click();
		  
		  logger5.log(Status.INFO, "Click on Committee Menu");
		  driver.findElement(By.id("liCommittee")).click();
		  
		  Thread.sleep(2000);
		  driver.findElement(By.id("txtCommittee")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("txtCommittee")).sendKeys("vice presi");
		  
		  logger5.log(Status.PASS, "Committee Members are search and display successfully");
		  
		  driver.findElement(By.id("liTowenship")).click();
		  Thread.sleep(2000);
		  
		  logger5.log(Status.INFO, "Click on Document Menu");
		  
		  logger5.log(Status.INFO, "Display and Redirect to Document Page");
		  
		  driver.findElement(By.linkText("Documents")).click();
		  Thread.sleep(2000);
		  
		  driver.findElement(By.xpath("/html/body/my-app/documents/section/div/div/div[2]/div[2]/a/div")).click();
		  
		  driver.findElement(By.xpath("/html/body/my-app/documents/section/div/div/div[2]/div[1]/a/div")).click();
		  
		  logger5.log(Status.PASS, "Documens are viewed, download and open in new tab successfully");
		  
		  driver.findElement(By.id("liTowenship")).click();
		  Thread.sleep(2000);
		  
		  driver.findElement(By.linkText("Member Directory")).click();
		  logger5.log(Status.INFO, "Click on Member Directory Menu");
		  logger5.log(Status.INFO, "Click on Search button");
		  
		  driver.findElement(By.id("txtMember")).click();
		  Thread.sleep(2000);
		  
		  driver.findElement(By.id("txtMember")).sendKeys("rajan");
		  
		  logger5.log(Status.PASS, "Members in the directory are search and display successfully");
		  
		  
		  driver.findElement(By.id("liTowenship")).click();
		  Thread.sleep(2000);
		  logger5.log(Status.INFO, "Click on Service Directory Menu");
		  logger5.log(Status.INFO, "Redirect and Display on Service Directory Page");
		  
		  driver.findElement(By.linkText("Service Directory")).click();
		  Thread.sleep(2000);
		  
		  
		  logger5.log(Status.INFO, "Click on GIVEN RATINGS button");
		  
		  driver.findElement(By.xpath("/html/body/my-app/vendorlist/section/div/div[2]/div/div/div[2]/div/table/tbody/tr[1]/td[6]/a")).click();
		  Thread.sleep(2000);
		  
		  logger5.log(Status.INFO, "Open the pop up Message. Rate the vendors out of 5 stars");
		  logger5.log(Status.INFO, "Give the rate out of 5");
		  driver.findElement(By.xpath("//div[@id='giveratings']/div/div/div/div/div[3]/div/span[4]")).click();
		  
		  logger5.log(Status.PASS, "Ratings will be given and display it in the service directory listing page");
		  
		  logger5.log(Status.INFO, "Click on Search Button");
		  Thread.sleep(2000);
		  driver.findElement(By.id("txtVendor")).sendKeys("Security");
		  
		  logger5.log(Status.PASS, "Service Directory with search functionality is search successfully");
		  
		  driver.findElement(By.id("liTowenship")).click();
		  Thread.sleep(2000);
		  logger5.log(Status.INFO, "Click on Facility Booking Menu");
		  driver.findElement(By.linkText("Facility Booking")).click();
		  Thread.sleep(2000);
		  
		  logger5.log(Status.INFO, "Click on View Details Button");
		  driver.findElement(By.linkText("View Details")).click();
		  logger5.log(Status.INFO, "Click on Back Button");
		  driver.findElement(By.linkText("Back")).click();
		 
		  logger5.log(Status.INFO, "Click on Book Now Button");
		  Thread.sleep(2000);
		  
		  driver.findElement(By.linkText("Book Now")).click();	
		  Thread.sleep(2000);
		  logger5.log(Status.INFO, "Enter Booking Date");
		  driver.findElement(By.id("Date")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.cssSelector("body > div > div.datepicker-days > table > tbody > tr:nth-child(5) > td.active.day")).click();
		  logger5.log(Status.INFO, "Enter And Select Start Time");
		  driver.findElement(By.id("StartTime")).click();
		  Thread.sleep(2000);
		  new Select(driver.findElement(By.id("StartTime"))).selectByVisibleText("18");
		  driver.findElement(By.id("StartTime")).click();
		  Thread.sleep(2000);
		  logger5.log(Status.INFO, "Enter and Select End Time");
		  driver.findElement(By.id("EndTime")).click();
		  new Select(driver.findElement(By.id("EndTime"))).selectByVisibleText("19");
		  driver.findElement(By.id("EndTime")).click();
		  Thread.sleep(2000);
		  logger5.log(Status.INFO, "Click on Save Button");
		  driver.findElement(By.id("save")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
		  logger5.log(Status.PASS, "Facility is booked successfully.");
		 
		  
		  
		  ExtentTest logger6 = (ExtentTest) extent.createTest("Account Test");
		  logger6.log(Status.INFO, "Click on Account Menu");
		  
		  driver.findElement(By.id("liAccount")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("liMyAccount")).click();
		  logger6.log(Status.INFO, "Enter the From Date");
		  Thread.sleep(2000);
		  driver.findElement(By.id("txtFromDate")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("txtFromDate")).clear();
		  Thread.sleep(2000);
		  driver.findElement(By.id("txtFromDate")).sendKeys("01/01/2019");
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/my-app/myaccount/div/section/div/div[2]/div[4]/div[1]/div/div[3]/a")).click();
		  logger6.log(Status.PASS, "Ledger is listed successfully.");
		  logger6.log(Status.INFO, "Click on My Account");
		  Thread.sleep(2000);
		  logger6.log(Status.INFO, "Click on View Your Invoice Checkbox button");
		  driver.findElement(By.id("invoicelist_5522")).click();
		  Thread.sleep(2000);
		  logger6.log(Status.INFO, "Click on View Button to view the invoice");
		  
		  driver.findElement(By.linkText("View")).click();
		  logger6.log(Status.PASS, "Invoice is to be viewd successfully");
		  
		  driver.findElement(By.id("liAccount")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("liMyReceipts")).click();
		  //driver.findElement(By.linkText("My Receipts")).click();
		  logger6.log(Status.INFO, "Click on My Receipts");
		  logger6.log(Status.INFO, "Click on Print Icon");
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/my-app/myreceipts/div/section/div/div[2]/div[2]/table/tbody/tr[1]/td[7]/a/i")).click();
		  logger6.log(Status.PASS, "Receipt is listed and printed successfully.");
		  
		  ExtentTest logger7 = (ExtentTest) extent.createTest("Maintenance Test");
		  driver.findElement(By.id("liMaintenance")).click();
		  logger7.log(Status.INFO, "Click on Service Request Menu");
		  driver.findElement(By.id("liServiceRequest")).click();
		  logger7.log(Status.INFO, "Without Enter any Mandatory and Optional Field click on Add Service Request Button");
		  driver.findElement(By.xpath("/html/body/my-app/servicerequest/section/div/div[2]/div[1]/div/div/div[5]/div[2]/a")).click();
		  Thread.sleep(2000);
		  
		  String errorMesg2 = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Please select service type.'])[1]/following::button[1]")).getText();
		  Thread.sleep(2000);
		  
		  if(errorMesg2.equals("Please select service type."))
		  {
			  	logger7.log(Status.FAIL, "Empty Mandatory and Optional Fields of service request");
		  }
		  else
		  {
			  logger7.log(Status.FAIL, "Not Enter Mandatory and Optional Fields of Service Request");
		  }
		  driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Please select service type.'])[1]/following::button[1]")).click();
		  
		  extent.flush();
		  
	}
}