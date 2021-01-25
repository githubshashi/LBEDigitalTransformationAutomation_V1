package digitaltransformation.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import digitaltransformation.Utilities.ExcelReadWrite;
import digitaltransformation.Utilities.Utility;



public class MyAccountClassH 
{

	WebDriver driver;
	WebDriverWait wait;
	ExtentTest logger;
	
	public MyAccountClassH(WebDriver rdriver)
	{
		this.driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

//WebElements using @find by initialization

	@FindBy(xpath="//input[@id='lbe_accountnumber']")
	public WebElement CT_number_textbox;

	public void Counciltaxnumber(String sheetname)
	{ try { CT_number_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
	catch(Exception e)
	{ e.printStackTrace(); }    }

//Need to add address

	@FindBy(xpath="//input[@id='lbe_fullnameoftheorganisationliable']")
	public WebElement Full_name_organisation_textbox;


	public void Enter_Full_name_organisationORperson(String sheetname,int a,int b)
	{ try { Full_name_organisation_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	catch(Exception e)
	{ e.printStackTrace(); }    }

//Need to add address

	@FindBy(xpath="//input[@id='lbe_contactnameforanyenquiries']")
	public WebElement Contact_name_textbox;

	public void Enter_Contact_name(String sheetname,int a,int b)
	{ try { Contact_name_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	catch(Exception e)
	{ e.printStackTrace(); }    }

	@FindBy(xpath="//input[@id='lbe_account_phonemobilenumber']")
	public WebElement Contact_telephone_number_textbox;

	public void Telephone_number_textbo(String sheetname)
	{ try { Contact_telephone_number_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
	catch(Exception e)
	{ e.printStackTrace(); }    }


//Application details

	@FindBy(xpath="//input[@id='lbe_propertyreleasedate_datepicker_description']")
	public WebElement property_became_unoccupied_date;

	public void Enter_Dateofproperty_unoccupied(String sheetname,int a,int b)
	{ try { property_became_unoccupied_date.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	catch(Exception e)
	{ e.printStackTrace(); }	} 

	@FindBy(xpath="//select[@id='lbe_willthenextoccupantbeaministerofreligion']")
	public WebElement property_occupied_Dpd;

//	public void propertyoccupied(String sheetname, int a)
//	{ try { Select property_occupied=new Select(property_occupied_Dpd);
//	property_occupied.selectByIndex(a); 
//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
//	catch(Exception e)
//	{ e.printStackTrace(); }	}

	@FindBy(xpath="//input[@id='lbe_dateexpectedforpropertyoccupied_datepicker_description']")
	public WebElement property_become_occupied_date;

	public void Enter_Dateofproperty_become_occupied(String sheetname,int a,int b)
	{ try { property_become_occupied_date.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	catch(Exception e)
	{ e.printStackTrace(); }	}

	@FindBy(xpath="//input[@id='lbe_religiousdenominationoftheminister']")
	public WebElement denomination_minister_religion_textbox;

	public void Enter_denominationministerreligion(String sheetname,int a,int b)
	{ try { denomination_minister_religion_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
	catch(Exception e)
	{ e.printStackTrace(); }    }

	@FindBy(xpath="//input[@id='lbe_denominationwebsiteaddress']")
	public WebElement denomination_website_address_textbox;

	public void Enter_denominationwebsiteaddress(String sheetname,int a,int b)
	{ try { denomination_website_address_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
	catch(Exception e)
	{ e.printStackTrace(); }    }

	@FindBy(xpath="//textarea[@id='lbe_howministerofreligionwillusetheproperty']")
	public WebElement minister_religion_textbox;

	public void Enter_Ministerofreligion(String sheetname,int a,int b)
	{ try { minister_religion_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
	catch(Exception e)
	{ e.printStackTrace(); }    }


}
