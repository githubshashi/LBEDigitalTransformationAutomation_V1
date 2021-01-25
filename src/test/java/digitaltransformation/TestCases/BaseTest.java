package digitaltransformation.TestCases;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import digitaltransformation.Pages.MyAccountHome;
import digitaltransformation.Pages.MyAccountProfile;
import digitaltransformation.Pages.MyAccountSignIn;
import digitaltransformation.Utilities.BrowserFactory;

import digitaltransformation.Utilities.ReadConfig;


public class BaseTest 
{
	
	public static ExtentReports report;
	public static ExtentTest logger;
	
	
	public static Logger log4j_report;


	ReadConfig readconfig = new ReadConfig();
	public WebDriver driver;
	public WebDriverWait wait;
	
	BrowserFactory bf=new BrowserFactory(driver);
	//----------------------------------------------------------------------------------
	
	//MyAccountHome hp;
	public static MyAccountHome hp;
	public static MyAccountSignIn sp;
	public static MyAccountProfile pf;
	
	protected String TestCasePass;
	protected String TestCaseFail;
	protected String TestCaseSkip;
	protected String TestName;
	
	//protected String browser="chrome";
	
	
	
	@BeforeSuite (groups = {"Apply_for_self","Onbehalf_of_SomeOneElse"})
	@Parameters({"browser"})
	public void BrowserLaunch_ReportInitiate(String br)
	{
		driver= bf.startBrowser(br);
		hp= new MyAccountHome(driver);
		sp= new MyAccountSignIn(driver);
		pf= new MyAccountProfile(driver);
		
		PropertyConfigurator.configure("Log4j.properties");
		log4j_report = Logger.getLogger("LBE Digital Transformation");
		
	//--------------------------------
		
		String dateName = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date()); //time stamp
	
		report = new ExtentReports("./TestReport/ValidationCheck_SubmitCase_"+dateName+".html",true);	
		report.addSystemInfo("Project Name", "LBE_DigitalTransfermation");
		report.addSystemInfo("Envirnoment", "UAT");
		//report.loadConfig(TC01_ClassD_ValidationCheck_SubmitCase.class,"resources", "extent-config.xml");
		//report.loadConfig(TC01_ClassD_ValidationCheck_SubmitCase.class,System.getProperty("User.dir"),"extent-config.xml");
		report.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	
	@AfterSuite (groups = {"Apply_for_self","Onbehalf_of_SomeOneElse"})
	public void BrowserClosed_ReportGenerated()
	{		
		//driver.close();
		//driver.quit();
		report.flush();
		report.close();	
		
	}
	
	@BeforeTest (groups = {"Apply_for_self","Onbehalf_of_SomeOneElse"})
	public void CouncilWebsiteOpened() throws InterruptedException
	{	

		
//	   ut.Open_UAT_PORTAL_URL();
		Explicitwait(hp.homeicon,10);
		hp.ClickHomeIcon();
	   
		
		Explicitwait(hp.signInlink,10);
		hp.ClickonSignIn();
//	   sp.SignInPageTitle();
	
		Explicitwait(sp.SignInbutton,10);
		sp.Click_SignIn(1,0,1);
	   
	   Explicitwait(pf.homeicon,30);
	   pf.ClickHomeIcon();
	   TestName="Services";
	}
	
	@BeforeClass (groups = {"Apply_for_self","Onbehalf_of_SomeOneElse"})
	public void ToStartReport()
	{
				
		if(TestName==null)
		{		//TestName = (this.getClass().getName()).substring(41, 68); 
			TestName = (this.getClass().getName()).substring(32); 
			logger = report.startTest(TestName).assignCategory("Functional Testing, Field Validations Testing ");
		}  
		else 
		{	TestName = (this.getClass().getName()).substring(32);	
			logger = report.startTest(TestName).assignCategory("Functional Testing, Field Validations Testing ");
		}
		//hp.HomeIcon();
	}
	
	@AfterClass (groups = {"Apply_for_self","Onbehalf_of_SomeOneElse"})
	public void ToEndReport()
	{
		
		report.endTest(logger); //It ends the current test and prepares to create HTML report
		report.flush();
		//driver.navigate().refresh();	
	}

	
	@AfterMethod (groups = {"Apply_for_self","Onbehalf_of_SomeOneElse"})
	public void tearDown(ITestResult result) 
	{
//		String FailureScreenshot="TestCase_Failed"; 
//		String SkippedScreenshot="TestCase_Skipped"; 
	
		if (result.getStatus() == ITestResult.SUCCESS)
		{	
			logger.log(LogStatus.PASS, TestCasePass);
		 		
		} 		
		else if(result.getStatus() == ITestResult.FAILURE) 
		{
			logger.log(LogStatus.FAIL, logger.addScreenCapture(captureScrenshot(result.getName())));	
			logger.log(LogStatus.FAIL, "Error found at :" +result.getThrowable());
			logger.log(LogStatus.FAIL, result.getName()+" -Test Case Failed.");
		}
		else if(result.getStatus() == ITestResult.SKIP) 
		{
				 logger.log(LogStatus.SKIP, result.getName()+ "This test Case is Skipped");	
		}	
	}

	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

	public void Explicitwait(WebElement ele, long t1)
	{
		WebDriverWait wait=new WebDriverWait(driver, t1);
		wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
	}
	
	public  String captureScrenshot(String screenshotName) {
		try {
			String dateName = new SimpleDateFormat("ddMMMyyyyHHmmss").format(new Date());
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String dest = ".\\Screenshots\\" + screenshotName + dateName+ ".png";
			File FinalDest= new File(dest);
			FileUtils.copyFile(src, FinalDest);      // Copy the screenshot to desired location using copyFile method
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			//System.out.println(dest);
			return FinalDest.getAbsolutePath();		
		} 
		catch (Exception e)
		{				return e.getMessage();      	}
	}
	
	
	
		
	
}
