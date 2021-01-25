package digitaltransformation.Pages;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import digitaltransformation.Utilities.ExcelReadWrite;
import digitaltransformation.Utilities.Utility;



public class MyAccountClassD 
{

// Declarization
	WebDriver driver;
	WebDriverWait wait;
	
	 String Mandatory_ExpectedResult="The form could not be submitted for the following reasons:";
	 String MandatoryMobileNumber_ExpectedResult="Contact telephone number - Error: this number is not valid. Please re-enter.";
	 String FirtName_Alphanumaric_ExpectRes="First name of person who is being detained - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed";
	 String LastName_Aplhanumaric_ExpectRes="Last name of person who is being detained - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed";
	 String ContactNumber_Invalid_ExpectRes="Contact telephone number - Error: this number is not valid. Please re-enter.";
	 

	 
	public MyAccountClassD(WebDriver rdriver)
	{
		this.driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

//WebElements using @find by initialization
	
	@FindBy(xpath="//input[@id='lbe_accountholderfirstname']")
	public WebElement DetainedFirstname_textbox;
	
	@FindBy(xpath="//input[@id='lbe_accountholdersurname']")
	public WebElement DetainedLastname_textbox;
	
	@FindBy(xpath="//input[@id='NextButton']")
	public WebElement NEXT_Button;
	
	@FindBy(xpath="//a[contains(text(),'First name of person who is being detained - Error')]")
	public WebElement Firstname_Alphanumaric_checkErrormessage;
	
	@FindBy(xpath="//a[contains(text(),'Last name of person who is being detained - Error:')]")
	public WebElement Lastname_Alphanumaric_checkErrormessage;
	
	@FindBy(xpath="//input[@id='lbe_accountholderfirstname2']")
	public WebElement Onbehalffirstname_textbox;
	
	@FindBy(xpath="//input[@id='lbe_accountholdersurname2']")
	public WebElement Onbehalflastname_textbox;
	
	@FindBy(xpath="//input[@id='lbe_thedatedetentioncommenced_datepicker_description']")
	public WebElement Enter_DateDetention_txtbox;
	
	@FindBy(xpath="//textarea[@id='lbe_thenameandaddressoftheproperty']")
	public WebElement Enter_NameAddressPrison_textbox;
	
	@FindBy(xpath="//input[@id='lbe_prisonernumber']")
	public WebElement Enter_Prisonernumber_textbox;
	
	@FindBy(xpath="//input[@id='lbe_dateofbirth_datepicker_description']")
	public WebElement Enter_PrisonerDOB_textbox;
	
	@FindBy(xpath="//select[@id='lbe_hasthepersonremandedincustodypendingtrial']")
	public WebElement custody_dpd;
	
	@FindBy(xpath="//input[@id='lbe_expectedreleasedate_datepicker_description']")
	public WebElement expectedrelease_date;
	
	@FindBy(xpath="//select[@id='lbe_persondetainedfornonpaymentofcounciltax']")
	public WebElement NonPayment_dpd;
	
	
// Method Actions	(Utilization)		

	public void Enter_DetainedFirstname(String sheetname,int a,int b)
	{ try 
	{ 	JavascriptExecutor js=(JavascriptExecutor) driver;
			wait=new WebDriverWait(driver, 30);
		DetainedFirstname_textbox.sendKeys("9876fdhgdhdhd");
		js.executeScript("window.scrollBy(0, 1000)");
		NEXT_Button.click();                               //  Clicks NEXT button before Enter data to check mandatory message displayed or not	
		wait.until(ExpectedConditions.visibilityOf(Firstname_Alphanumaric_checkErrormessage));
		String Actual_result1 = Firstname_Alphanumaric_checkErrormessage.getText();
		Assert.assertEquals(Actual_result1, FirtName_Alphanumaric_ExpectRes, " --(Detained FirstName field value is Invalid (OR) Something went wrong here please check)-- " ); //Checks for Alphanumaric should not allow in Firstname.  
		js.executeScript("window.scrollBy(0, 1000)");
		DetainedFirstname_textbox.clear();
		DetainedFirstname_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	
	public void Enter_Detainedlastname(String sheetname,int a, int b)
	{ try 
	{   JavascriptExecutor js=(JavascriptExecutor) driver;
		wait=new WebDriverWait(driver, 50);	
		DetainedLastname_textbox.sendKeys("98fdhgdhdhd");
		js.executeScript("window.scrollBy(0, 1000)"); 
		NEXT_Button.click();
		wait.until(ExpectedConditions.visibilityOf(Lastname_Alphanumaric_checkErrormessage));		
		String Actual_result2 = Lastname_Alphanumaric_checkErrormessage.getText();
		Assert.assertEquals(Actual_result2, LastName_Aplhanumaric_ExpectRes, " --(Detained LastName field value is Invalid (OR) Something went wrong here please check)-- " ); //Checks for Alphanumaric should not allow in Lastname. 
		js.executeScript("window.scrollBy(0, 1000)"); 
		DetainedLastname_textbox.clear();
		DetainedLastname_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	
	
	
//------------------------------------Application Details Page---------------------------------------------------------------
	
		public void Datedetentioncommenced(String sheetname)
		{ try { Enter_DateDetention_txtbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		public void Name_Address(String sheetname)
		{ try { Enter_NameAddressPrison_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,13)); }
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		public void PrisonerNumber(String sheetname)
		{ try { Enter_Prisonernumber_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,14)); }
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		public void PersonDOB(String sheetname)
		{ try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			Enter_PrisonerDOB_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,15));
		}
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		public void RemandedinCustody(String sheetname)
		{ try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Select custody=new Select(custody_dpd);
				custody.selectByIndex(1); 
		}
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		public void ExpectedReleasedate(String sheetname)
		{ try {driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			expectedrelease_date.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,16));
		}
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		public void NonPayment()
		{ try { Select payment=new Select(NonPayment_dpd);
					payment.selectByIndex(1);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
	
//	public void onbehalfFirstname(String sheetname)
//	{ try { Onbehalffirstname_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,6)); }
//	catch(Exception e)
//	{ e.printStackTrace(); }	}
//	
//	public void onbehalflastname(String sheetname)
//	{ try { Onbehalflastname_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,7)); }
//	catch(Exception e)
//	{ e.printStackTrace(); }	}
	
//	public void onbehalfPostcodeAddress()
//	{ try { driver.findElement(By.xpath(conf.enteronbehalfpostcode())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,8)); }
//	catch(Exception e)
//	{ e.printStackTrace(); }	}
	
//	public void onbehalfClick_Go()
//	{ try { driver.findElement(By.xpath(conf.clickonbhalfGo())).click(); }
//	catch(Exception e)
//	{ e.printStackTrace(); }	}
//	
//	public void onbehalfselectAddress()
//	{ try {  Select address=new Select(driver.findElement(By.xpath(conf.selectonbehalfaddress())));
//	address.selectByIndex(6);  }
//	catch(Exception e)
//	{ e.printStackTrace(); }	}
	
//	public void telphonenumber()
//	{ try { 
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.findElement(By.xpath(conf.telphonenumbertxt())).sendKeys("9876fdhgdhdhd");		
//			driver.findElement(By.xpath(conf.nextbtn2())).click(); 
//			String Actual_result = driver.findElement(By.xpath(conf.Mobilenumber_Invalid_check())).getText();
//			Assert.assertEquals(Actual_result , ContactNumber_Invalid_ExpectRes, " --(Contact Number field value is Invalid (OR) Something went wrong here please check)-- " ); //Checks for Alphanumaric should not allow in Contact Number.  
//			js.executeScript("window.scrollBy(0, 1000)"); 
//			driver.findElement(By.xpath(conf.telphonenumbertxt())).clear();
//			driver.findElement(By.xpath(conf.telphonenumbertxt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, Utility.Sh_CommonDetails,1,3)); }
//	catch(Exception e)
//	{ e.printStackTrace(); }	}
	
//	public void emailaddress()
//	{ try { driver.findElement(By.xpath(conf.emailaddresstxt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, Utility.Sheet2Name,1,10)); }
//	catch(Exception e)
//	{ e.printStackTrace(); }	}
//	
//	public void Accountdetailspage_nextbtn()
//	{ try {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.findElement(By.xpath(conf.nextbtn2())).click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		}
//	catch(Exception e)
//	{ e.printStackTrace(); }	}
//	
//	public void Accountdetailspage_SaveExit()
//	{ try {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath(conf.SaveExit())).click();
//	}
//	catch(Exception e)
//	{ e.printStackTrace(); }	}
//	
//	
	
	
	
	
	
	






}
