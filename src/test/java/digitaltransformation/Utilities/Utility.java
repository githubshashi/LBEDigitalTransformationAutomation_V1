package digitaltransformation.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Utility 
{
	
	ConfigReaderMyAccount conf = new ConfigReaderMyAccount();
	 public WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static Logger log4j_report;
	 public WebDriverWait wait;
	
	public Utility(WebDriver ldriver) 
	{
		this.driver = ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	String Delegation_FirtName_Alphanumaric_ExpRes="First Name - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed";
	String Delegation_LastName_Alphanumaric_ExpRes="Last Name - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed";
	String ContactNumber_Invalid_ExpectRes="Contact telephone number - Error: Please enter your telephone number with no spaces.";
	String Mandatory_Feilds_Expected="The form could not be submitted for the following reasons:";
	String MandatoryMobileNumber_ExpectedResult="Contact telephone number - Error: this number is not valid. Please re-enter."; 
	
	public static final String UploadFilepath=System.getProperty("user.dir");
	public static final String Uploaddocument="\\src\\test\\java\\digitaltransformation\\TestData\\Document.jpg";
	public static final String excelfilepath=System.getProperty("user.dir")+"/src/test/java/digitaltransformation/TestData/MyAccountTestData.xlsx";
	public static final String Sh_CommonDetails="CommonDetails";

	
	//WebElements using @FindBy
	@FindBy(xpath="//select[@id='lbe_applyingforyourselforanotherparty']")
	public WebElement self_onbehalf;
	
	@FindBy(xpath="//input[@id='InsertButton']")
	public WebElement StartFormbutton;
	
	@FindBy(xpath="//h2[@class='tab-title']")
	public WebElement ReturnPage_HeadingText;
	
	@FindBy(xpath="//input[@id='lbe_manuallyrequired']")
	public WebElement CheckBox_EnterManual;
	
	@FindBy(xpath="//input[@id='NextButton']")
	public WebElement NEXT_Button;
	
	@FindBy(xpath="//h4[@class='validation-header']")
	public WebElement Mandatory_ErrorMessage;
	
	//------------Address Post code--------------------------------
					@FindBy(xpath="//input[@id='lbe_postcode_lbe_hiddenpersonaddress']")
					public WebElement Postcode_Textbox;
					
					@FindBy(xpath="//button[@id='button_lbe_hiddenpersonaddress']")
					public WebElement PostCode_Go_Button;
					
					@FindBy(xpath="//select[@id='lbe_addressOption_lbe_hiddenpersonaddress']")
					public WebElement PostCode_AddresslistWindow;
					
					@FindBy(xpath="//address[@id='addressTag_address_lbe_hiddenpersonaddress']")
					public WebElement PostCode_Addresslistwindow_Option;
	//------------------------------------------------------------------------------------------------
	
	//------------Address On behalf Post code--------------------------------
					@FindBy(xpath="//input[@id='lbe_postcode_lbe_hiddenpersononbehalfaddress']")
					public WebElement OnbehalfPostcode_txt;
					
					@FindBy(xpath="//button[@id='button_lbe_hiddenpersononbehalfaddress']")
					public WebElement OnbehalfGo_btn;
					
					@FindBy(xpath="//select[@id='lbe_addressOption_lbe_hiddenpersononbehalfaddress']")
					public WebElement OnbehalfPostcodeAddress_Options_txt;
					
					@FindBy(xpath="//address[@id='addressTag_address_lbe_hiddenpersononbehalfaddress']")
					public WebElement OnbehalfPostcodeAddress_Optionsselected_txt;
	//------------------------------------------------------------------------------------------------
					
	@FindBy(xpath="//a[@class='add-file btn btn-primary action']")
	public WebElement Addfiles_btn;
	
	@FindBy(xpath="//input[@name='file']")
	public WebElement Choose_btn;
	
	@FindBy(xpath="//button[contains(text(),'Add files')]")
	public WebElement ADD_btn_popup;
	
	@FindBy(xpath="//section[@class='modal fade modal-add-file in']//button[@class='cancel btn btn-default'][contains(text(),'Cancel')]")
	public WebElement Cancel_btn_popup;
	
	@FindBy(xpath="//p[contains(text(),\"We're sorry, but something went wrong. Please try\")]")
	public WebElement Click_AddFile_before;
	
	@FindBy(xpath="//div[contains(text(),'Supporting information and declaration')]")
	public WebElement Declarationpage_heading;
	
	@FindBy(xpath="//select[@id='lbe_specialqueueflag']")
	public WebElement summons_dpd__DeclarationPage;
	
	@FindBy(xpath="//input[@id='lbe_specialqueueflag_0']")
	public WebElement summons_YES__DeclarationPage;
	
	@FindBy(xpath="//input[@id='lbe_specialqueueflag_1']")
	public WebElement summons_NO__DeclarationPage;
	
	@FindBy(xpath="//input[@id='lbe_declaration']")
	public WebElement Checkbox_DeclarationPage;
	
	@FindBy(xpath="//button[@id='idViewSummary']")
	public WebElement Review_btn__DeclarationPage;
	
	@FindBy(xpath="//button[@id='idPrevious']")
	public WebElement Edit_btn__DeclarationPage;
	
	@FindBy(xpath="//button[contains(text(),'Save and Close')]")
	public WebElement SaveClose_btn__DeclarationPage;
	
	@FindBy(xpath="//input[@id='UpdateButton']")
	public WebElement Submit_btn__DeclarationPage;
	
	@FindBy(xpath="//button[@id='btnNext']")
	public WebElement Gotohome_button;
	
	@FindBy(xpath="//label[@id='idComplete']")
	public WebElement Case_number;
	
	@FindBy(xpath="//h2[@class='tab-title']")
	public WebElement ServiceSummary_heading_txt;
	
	@FindBy(xpath="//input[@id='lbe_account_phonemobilenumber']")
	public WebElement Telephone_textbox;
	
	@FindBy(xpath="//input[@id='lbe_account_emailaddress']")
	public WebElement Email_textbox;
	
	@FindBy(xpath="//a[contains(text(),'Contact telephone number - Error: Please enter you')]")
	public WebElement Mobilenumber_InvalidCheck_txtbox;
	
	@FindBy(xpath="//input[@id='lbe_accountnumber']")
	public WebElement CTAccountnumber_textbox;
	
	@FindBy(xpath="//select[@id='lbe_applyingforyourselforanotherparty']")
	public WebElement Self_Onbehalf_dpd;
	
	@FindBy(xpath="//select[@id='lbe_wishtohavetheauthoritytoact']")
	public WebElement Authority_Act_dpd;
	
	@FindBy(xpath="//select[@id='lbe_customer']")
	public WebElement RepresentPerson_dpd;
	
	@FindBy(xpath="//input[@id='lbe_requestdelegation']")
	public WebElement ForDelegation_checktbox;
	
	@FindBy(xpath="//input[@id='lbe_citizenfirstname']")
	public WebElement DelegationFirstName_Textbox;
	
	@FindBy(xpath="//input[@id='lbe_citizenlastname']")
	public WebElement DelegationLastName_Textbox;
	
	@FindBy(xpath="//input[@id='lbe_postcode_lbe_hiddendelegateaddresscitizen']")
	public WebElement DelegationPostcode_textbox;
	
	@FindBy(xpath="//address[@id='addressTag_address_lbe_hiddendelegateaddresscitizen']")
	public WebElement hiddendelegateaddresstag_textbox;
	
	@FindBy(xpath="//button[@id='button_lbe_hiddendelegateaddresscitizen']")
	public WebElement DelegationGo_btn;
	
	@FindBy(xpath="//select[@id='lbe_addressOption_lbe_hiddendelegateaddresscitizen']")
	public WebElement DelegationAddress_list;
	
	@FindBy(xpath="//i[contains(text(),'Please complete details of the person you wish to')]")
	public WebElement DelegationPageHeading;
		
	@FindBy(xpath="//a[contains(text(),'First Name - Error: this field should contain alph')]")
	public WebElement Delegation_Firstname_Alphanumaric_Chk;
	
	@FindBy(xpath="//a[contains(text(),'Last Name - Error: this field should contain alpha')]")
	public WebElement Delegation_Lastname_Alphanumaric_Chk;
	

	
	
	
	
		
	// Action methods of the WebElements
	
	//--------------To open the Council UAT Portal Url--------------
	
		public void Open_UAT_PORTAL_URL() 
		{		
			try { 	driver.get(conf.getURL());  } 
			catch (Exception e) {  e.printStackTrace();  }
		}
	
	//-------------------------Verify the SubService Title page-----------------------
		
		public void Verify_SubService_titlepage() {
			try {
				Assert.assertEquals(driver.getTitle(), conf.SubServicetitle_labelName());
			} catch (Exception e) {
			e.printStackTrace();	}	}
	
	//--------------- To Capture Screen shot when testcase is pass/failed----------------------
	
	public  String captureScrenshot(String screenshotName) {

		try {
			String dateName = new SimpleDateFormat("ddMMMyyyyHHmmss").format(new Date());
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String dest = ".\\Screenshots\\" + screenshotName + dateName+ ".png";
			
			FileUtils.copyFile(src, new File(dest));      // Copy the screenshot to desired location using copyFile method
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			return dest;		
		} 
		catch (Exception e)
		{				return e.getMessage();      	}
	}
	
	
	public void Switch_Newtab()
	{
		driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL+"t");
		
	}
	
	//--------------------Common feild occurs in all pages---------------------------------
	
	public void telphonenumber()
	{ try { 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait=new WebDriverWait(driver, 30);	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Telephone_textbox.sendKeys("9876fdhgdhdhd");		
			NEXT_Button.click(); 
			wait.until(ExpectedConditions.visibilityOf(Mobilenumber_InvalidCheck_txtbox));
			String Actual_result = Mobilenumber_InvalidCheck_txtbox.getText();
			Assert.assertEquals(Actual_result, ContactNumber_Invalid_ExpectRes, " --(Contact Number field value is Invalid (OR) Something went wrong here please check)-- " ); //Checks for Alphanumaric should not allow in Contact Number.  
			js.executeScript("window.scrollBy(0, 1000)"); 
			Telephone_textbox.clear();
			Telephone_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, Sh_CommonDetails,1,3)); }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	public void Enter_CTAccountnumber(String filepath,int a,int b)
	{ try { CTAccountnumber_textbox.sendKeys(ExcelReadWrite.getCellData(filepath,Sh_CommonDetails,a,b)); }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	public void MandatoryFieldCheck()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
        NEXT_Button.click();                            //  Clicks NEXT button before Enter data to check mandatory message displayed or not
		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(Mandatory_ErrorMessage,"The form could not be submitted for the following reasons:"));
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		String Actual_result = Mandatory_ErrorMessage.getText();
		Assert.assertEquals(Actual_result , Mandatory_Feilds_Expected);
	}
	
	
	
	
	//--------------------Select Apply for self OR On behalf of another party drop down--------------------------------------
	
	public void select_self_onbehalf(int i)
	{ 		try { 		Select selfbehalf=new Select(self_onbehalf);
						selfbehalf.selectByIndex(i);  }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	
	public void select_Authority_act(int i)
	{ try { driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Select authority=new Select(Authority_Act_dpd);
			authority.selectByIndex(i);  }
			catch(Exception e)
			{ e.printStackTrace(); }
	}
	
	public void select_RepresentPerson(int i)
	{ try { driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Select Rep_Person=new Select(RepresentPerson_dpd);
			Rep_Person.selectByIndex(i); 
			} 
			catch(Exception e)
			{ e.printStackTrace(); }
	}
	
	public void tickdelegationcheckbox()
	{
		try { ForDelegation_checktbox.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); }
	}
	
	public void FirstNamedelegationTextbox(String Sheetname,int a,int b)
	{
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			DelegationFirstName_Textbox.click();
			DelegationFirstName_Textbox.sendKeys("9876fdhgdhdhd");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			NEXT_Button.click(); //  Clicks NEXT button After entering data to check alphanumaric should not allow in First name
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)"); 
		String Actual_result1 = Delegation_Firstname_Alphanumaric_Chk.getText();
		Assert.assertEquals(Actual_result1 , Delegation_FirtName_Alphanumaric_ExpRes, " --(Delegation FirstName field value is Invalid (OR) Something went wrong here please check)-- " ); //Checks for Alphanumaric should not allow in Firstname.  
		DelegationFirstName_Textbox.clear();
		DelegationFirstName_Textbox.sendKeys(ExcelReadWrite.getCellData(excelfilepath,Sheetname,a,b));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); }
	}
	
	public void LastNamedelegationTextbox(String SheetName,int a,int b)
	{
		try { 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			DelegationLastName_Textbox.sendKeys("9876fdhgd32432hd");
			js.executeScript("window.scrollBy(0, 1000)"); 
			NEXT_Button.click();                               //  Clicks NEXT button After entering data to check alphanumaric should not allow in First name
			js.executeScript("window.scrollBy(0, -1000)"); 
			String Actual_result2 = Delegation_Lastname_Alphanumaric_Chk.getText();
			Assert.assertEquals(Actual_result2 , Delegation_LastName_Alphanumaric_ExpRes, " --(Delegation LastName field value is Invalid (OR) Something went wrong here please check)-- " ); //Checks for Alphanumaric should not allow in Firstname.  
			DelegationLastName_Textbox.clear();
			DelegationLastName_Textbox.sendKeys(ExcelReadWrite.getCellData(excelfilepath,SheetName,a,b));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); }
	}
	
	public void AddressdelegationTextbox(String SheetName,int a, int b, int c)
	{
		try { 
			wait=new WebDriverWait(driver, 20);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			DelegationPostcode_textbox.sendKeys(ExcelReadWrite.getCellData(excelfilepath,SheetName,a,b));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			DelegationGo_btn.click();
			wait.until(ExpectedConditions.visibilityOf(DelegationAddress_list));
			Select address=new Select(DelegationAddress_list);		
			int s_value=Integer.parseInt(ExcelReadWrite.getCellData(excelfilepath,SheetName,a,c));
			address.selectByIndex(s_value);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//address[@id='addressTag_address_lbe_hiddendelegateaddresscitizen']")));
			wait.until(ExpectedConditions.visibilityOf(hiddendelegateaddresstag_textbox));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		}
		catch(Exception e)
		{ e.printStackTrace(); }
	}	
	

	//-------------------------------From second Page onwards- NEXT buttons----------------------------
	
	public void NEXT_2()
	{try { 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
		NEXT_Button.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
	catch(Exception e)
		{ e.printStackTrace(); }	}
	
	
	//-----------------------------From second Page onwards- Save and Exit buttons------------------------
	
	public void SAVE_AND_EXIT_2()
	{try { driver.findElement(By.xpath(conf.SaveExit())).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	//----------------------------From second Page onwards- Previous buttons------------------------------
	public void PREVIOUS_1()
	{try { driver.findElement(By.xpath(conf.Previous_btn())).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
	catch(Exception e)
	{ e.printStackTrace(); }	}
	

	//-----------------------------------Address look_up for All the Pages-------------------------------------------

	public void Postcode_SelectAddress(String sheetname, int a,int b,int c)
	{
		try { 	
				Postcode_Textbox.sendKeys(ExcelReadWrite.getCellData(excelfilepath,sheetname,a,b));
				PostCode_Go_Button.click();
				wait=new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOf(PostCode_AddresslistWindow));
				Select address=new Select(PostCode_AddresslistWindow);
				int s_value=Integer.parseInt(ExcelReadWrite.getCellData(excelfilepath,sheetname,a,c));
				address.selectByIndex(s_value);						
				wait.until(ExpectedConditions.visibilityOf(PostCode_Addresslistwindow_Option));
	
			}
		catch(Exception e)
		{ e.printStackTrace(); }	
	}
	
	public void PostcodeOnbehalf_SelectAddress(String sheetname,int a,int b,int c)
	{
		try { 
			OnbehalfPostcode_txt.sendKeys(ExcelReadWrite.getCellData(excelfilepath,sheetname,a,b));
			OnbehalfGo_btn.click();
			wait=new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(OnbehalfPostcodeAddress_Options_txt));
			Select address=new Select(OnbehalfPostcodeAddress_Options_txt);
			int s_value=Integer.parseInt(ExcelReadWrite.getCellData(excelfilepath,sheetname,a,c));
			address.selectByIndex(s_value);						
			wait.until(ExpectedConditions.visibilityOf(OnbehalfPostcodeAddress_Optionsselected_txt));
				
			}
		catch(Exception e)
		{ e.printStackTrace(); }	
	}
	
	
	//---------------------------------------------------------------Upload Documents-------------------------------
	
	public void Uploadedocument()
	{
		try { 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Addfiles_btn.click();
			Choose_btn.sendKeys(UploadFilepath+Uploaddocument);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ADD_btn_popup.click();
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			driver.navigate().refresh();
		}
		catch(Exception e)
		{  e.printStackTrace(); }
	}
	
	
	public void PopupCancel()
	{try { driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Cancel_btn_popup.click(); 
	}
	
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	
	//------------------------------------------------Introduction page page NEXT button (Start Form Button)----------------------------------------

	public void Click_StartForm()   
	{ try
	{ 			JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
		StartFormbutton.click();  
	}
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	//------------------------------------------If Customer willing to  enter CTA manually-------------------------
	
	public void tickboxCouncilTaxAccNo()
	{
		try { 
			CheckBox_EnterManual.click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);  }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	
	
	//----------------------------------------Customer Received summons YES or NO--------------------------
	  
		public void Select_summons(int a)
		{ 
			try { 
				if (a==0)
				{  	summons_YES__DeclarationPage.click();   				}
				else 
				{  summons_NO__DeclarationPage.click();  }
				
//				Select summons=new Select(summons_dpd__DeclarationPage);
//				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//				summons.selectByIndex(1);  
				}
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		
	
			public void ClickCheckBox()
			{try { Checkbox_DeclarationPage.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);}
			catch(Exception e)
			{ e.printStackTrace(); } } 
	
					public void ClickSubmit_btn()
					{try { 
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 	
					    js.executeScript("arguments[0].click()", Submit_btn__DeclarationPage);
					}
					catch(Exception e)
						{ e.printStackTrace(); } }
	
//------------------------------------------------- Page Heading Text ------------------------------------------------------------
	
	public String Page_heading()
	{	
		String Heading1= ReturnPage_HeadingText.getText();
		return Heading1;	
	}
	
	public String Declarationheading()
	{ 
		wait=new WebDriverWait(driver, 20);
	//	wait.until(ExpectedConditions.textToBePresentInElementValue(Declarationpage_heading, "Supporting information and declaration"));
		wait.until(ExpectedConditions.visibilityOf(Declarationpage_heading));
		String Heading1= Declarationpage_heading.getText();
		return Heading1 ;	}
	
	public String Delegationheading()
	{   
		wait=new WebDriverWait(driver, 30);
	//	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(conf.Delegationheadingtext()), "Please complete details of the person you wish to act on behalf of."));
		wait.until(ExpectedConditions.visibilityOf(DelegationPageHeading));
		String Heading2= DelegationPageHeading.getText();		
		return Heading2 ;	}

	//------------------------------------------------Submition Page------------------
	
		public void ClickGotohome_btn()
		{try { JavascriptExecutor js = (JavascriptExecutor) driver;
		 		js.executeScript("window.scrollBy(0, -250)");  
		 	//	driver.findElement(By.xpath(conf.Gotohome_btn())).click();
		 	
		 		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		 		 WebElement element = driver.findElement(By.xpath(conf.Gotohome_btn()));     
			        js.executeScript("arguments[0].click()", element);	
			}
		catch(Exception e)
			{ e.printStackTrace(); } }
		
		
		public String Casenumber(String Casenumber)
		{try { Casenumber = Case_number.getText();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); }
		catch(Exception e)
		{ e.printStackTrace(); } 
		return Casenumber; }
		
		public String Servicesummaryheading()
		{
			wait=new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.textToBePresentInElement(ServiceSummary_heading_txt, "Service summary"));
			String Servicesummarytxt= ServiceSummary_heading_txt.getText();		
			return Servicesummarytxt ;	
		}



		
		
//----------------------------------------------------Select DropDown Value Commonfield---------------------------------------------
		
		public void selectdropdownvalue(WebElement ele, String type, String value)
		{
			wait=new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(ele));
			Select select=new Select(ele);
			switch (type)
			{
			case "Index":
				select.selectByIndex(Integer.parseInt(value));
				break;
			case "value":
				select.selectByValue(value);
				break;
			case "visibletext":
				select.selectByVisibleText(value);
				break;
			default:
				System.out.println("please pass the correct value");
				break;
			}
		}
		
//--------------------------------Firstname and last validation--------------------------------------------------------------------------------------------

	public void FirstnamefieldValidation(WebElement Firstname, WebElement FirstnameError_ele, String FirstnameErrortext, ExtentTest logger ) 
	{
		String[] invalidChars = {"#!$@%^6&'","1234567890"};
	    String namecheck1 = "abcdefghijklmnopqrstuvwxyz";
	    String namecheck2 = "SS";
	    int flag=0;
	    for (String invalid : invalidChars) 
	    {
	    	Firstname.clear();
	    	Firstname.sendKeys(namecheck1 + invalid);
	    	NEXT_Button.click();
	    	String ErrorMessage = FirstnameError_ele.getText();
	        if (ErrorMessage.equals(FirstnameErrortext)) 
	        {  	   flag = 0;   }
	       else 
	        {      flag = 1;     }
	    }
	    if(flag==0)
	    {	    System.out.println("PASS: Firstname Special character and Numbers Not accepting -->  ValidationCheck PASS"); 
	    logger.log(LogStatus.INFO, "Firstname field Validation check (Special character and Numbers) are not accepting -->  WORKING AS EXPECTED");
		}
	    else
	    {  		System.out.println("FAIL: Firstname Special charecter and Numbers accepting -->  ValidationCheck FAIL"); 
	    logger.log(LogStatus.INFO, "Firstname field Validation check (Special character and Numbers) are accepting -->  NOT WORKING AS EXPECTED");}
	 
	    Firstname.clear();
	    Firstname.sendKeys(" "+namecheck2+"     ");
	    NEXT_Button.click();
	    Firstname.click();
//    	String Spacecheck = Firstname.getText();
//    	System.out.println("Space check value="+Spacecheck);
//    	if(Spacecheck.equalsIgnoreCase(namecheck2))
//    	{     		System.out.println("PASS: Firstname accepted Single charecter");       	}
//    	else
//    	{	System.out.println("FAIL: Error displayed: First name of person who is being detained- Error: this field should contain at least one character");  }
//    	
    	Firstname.clear();	
    	
	}
	
	public void LastnamefieldValidation(WebElement Lastname, WebElement LastnameError_ele, WebElement LastnameErrorAtleastTwoChar_ele, String LastnameErrortext, String LastnameErrortextatleasttwochar, ExtentTest logger ) 
	{
		
		String[] invalidChars = {"#!$@%^6&'","1234567890"};
	    String namecheck1 = "abcdefghijklmnopqrstuvwxyz";
	    String namecheck2 = "S";
	    int flag=0;
	    for (String invalid : invalidChars) 
	    {
	    	Lastname.clear();
	    	Lastname.sendKeys(namecheck1 + invalid);
	    	NEXT_Button.click();        
	    	String ErrorMessage = LastnameError_ele.getText();
	        if (ErrorMessage.equals(LastnameErrortext)) 
	        {  	   flag = 0;   }
	       else 
	        {      flag = 1;     }
	    }
	    if(flag==0)
	    {	    System.out.println("PASS: Firstname Special character and Numbers Not accepting -->  ValidationCheck PASS"); 
	    logger.log(LogStatus.PASS, "Lastname field Validation check (Special character and Numbers) are not accepting -->  WORKING AS EXPECTED");
		}
	    else
	    {  		System.out.println("FAIL: Firstname Special charecter and Numbers accepting -->  ValidationCheck FAIL"); 
	    logger.log(LogStatus.FAIL, "Lastname field Validation check (Special character and Numbers) are accepting -->  NOT WORKING AS EXPECTED");}
	    Lastname.clear();
	    Lastname.sendKeys(namecheck2);
	    NEXT_Button.click();
	    String ErrorMessageAtleastonechar = LastnameErrorAtleastTwoChar_ele.getText();
	   
	    if (ErrorMessageAtleastonechar.equals(LastnameErrortextatleasttwochar)) 
        {  	System.out.println("PASS: Lastname one character not accepting -->  ValidationCheck PASS-working as expected");  
        	logger.log(LogStatus.PASS, "Lastname field Validation check (One character should not accept )  -->  WORKING AS EXPECTED");
        }
	    else 
        {       System.out.println("FAIL: Lastname one character accepting -->  ValidationCheck FAIL-Not working as expected");   
        logger.log(LogStatus.FAIL, "Lastname field Validation check (One character should not accept )  --> NOT WORKING AS EXPECTED");
        }  
	    Lastname.sendKeys(" "+namecheck2+"     ");
	    NEXT_Button.click();
	    Lastname.click();
	
//    	String Spacecheck = Lastname.getText();
//    	System.out.println("Space check value="+Spacecheck);
//    	if(Spacecheck.equalsIgnoreCase(namecheck2))
//    	{     		System.out.println("PASS: Last accepted Single charecter");       	}
//    	else
//    	{	System.out.println("FAIL: Error displayed: Last name of person who is being detained- Error: this field should contain at least one character");  }
//    	
    	Lastname.clear();
    	
	}
	
	
}
