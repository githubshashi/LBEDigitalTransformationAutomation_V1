package digitaltransformation.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import digitaltransformation.Utilities.ExcelReadWrite;
import digitaltransformation.Utilities.Utility;

public class MyAccountClassI 
{

	 WebDriver driver;
	 WebDriverWait wait;
	 ExtentTest logger;
	 
	 public MyAccountClassI(WebDriver ldriver) 
		{		this.driver = ldriver;   
		PageFactory.initElements(ldriver, this);
		}

	//WebElements using @find by initialization

	 @FindBy(xpath="//input[@id='lbe_accountnumber']")
	 public WebElement CT_Number_textbox;

	 //Action for the webelement

	 public void Counciltax_Number(String sheetname)
	 { try { CT_Number_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
	 catch(Exception e)
	 { e.printStackTrace(); }    }

	 //Need to add address

	 @FindBy(xpath="//input[@id='lbe_accountholderfirstname2']")
	 public WebElement First_name_person_textbox;


	 public void Enter_Firstname_person_left_property(String sheetname, int a, int b)
	 { try { First_name_person_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	 catch(Exception e)
	 { e.printStackTrace(); }    }
	 
	 @FindBy(linkText="First name of the person who has left the property to receive care - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed")  //Firstname invalid error message
	 public WebElement FirstnameErrorText;
	 

	 @FindBy(xpath="//input[@id='lbe_accountholdersurname2']")
	 public WebElement Last_name_person_textbox;
	 
	 @FindBy(linkText="Last name of the person who has left the property to receive care - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed")  //Lastname invalid error message
	  public WebElement LastnameErrorText;
	 
	 @FindBy(linkText="Last name of the person who has left the property to receive care- Error: this field should contain at least two characters")  //Lastname invalid error message for atleast one character
	 public WebElement LastnameErrorTextAtleastTwochar;
	 
	 public void Enter_Lastname_person_left_property(String sheetname, int a, int b)
	 { try { Last_name_person_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	 catch(Exception e)
	 { e.printStackTrace(); }    }

	 @FindBy(xpath="//input[@id='lbe_account_phonemobilenumber']")
	 public WebElement Mobile_number_textbox;

	 public void MobileNumber(String sheetname)
	 { try { Mobile_number_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
	 catch(Exception e)
	 { e.printStackTrace(); }    }


	 //Application details

	 @FindBy(xpath="//input[@id='lbe_datethepropertybecameunoccupied_datepicker_description']")
	 public WebElement date_property_unoccupied_date;

	 public void Enter_Date_PropertyOccupied(String sheetname,int a,int b)
	 { try { date_property_unoccupied_date.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	 catch(Exception e)
	 { e.printStackTrace(); }	}

	 @FindBy(xpath="//select[@id='lbe_tenantorowner']")
	 public WebElement Person_owner_tenant_Dpd;


//Address_receiving_care Field
	 		@FindBy(xpath="//input[@id='lbe_postcode_lbe_hiddenpropertyaddress']")
	 		public WebElement  Address_receiving_care_Postcode;
	 
	 		@FindBy(xpath="//button[@id='button_lbe_hiddenpropertyaddress']")
	 		public WebElement  Address_receiving_care_GoButton;
	 		
	 		@FindBy(xpath="//select[@id='lbe_addressOption_lbe_hiddenpropertyaddress']")
	 		public WebElement  Address_receiving_care_AddresslistWindow;
	 		
	 		@FindBy(xpath="//select[@id='lbe_addressOption_lbe_hiddenpropertyaddress']")
	 		public WebElement  Address_receiving_care_AddresslistOptionselected;
	 		
	 
	 		public void SelectAddress_Person_receiving_care(String sheetname,int a,int b,int c)
	 		{
			try { Address_receiving_care_Postcode.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath,sheetname,a,b));
					Address_receiving_care_GoButton.click();
					wait=new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.visibilityOf(Address_receiving_care_AddresslistWindow));
					Select address=new Select(Address_receiving_care_AddresslistWindow);
					int s_value=Integer.parseInt(ExcelReadWrite.getCellData(Utility.excelfilepath,sheetname,a,c));
					address.selectByIndex(s_value);						
					wait.until(ExpectedConditions.visibilityOf(Address_receiving_care_AddresslistOptionselected));
					
				}
			catch(Exception e)
			{ e.printStackTrace(); }	
	 		}
	 

	 @FindBy(xpath="//input[@id='lbe_datethepersonmovedtothisaddress_datepicker_description']")
	 public WebElement  date_person_date;

	 public void Enter_Date_PersonMovedAddress(String sheetname,int a,int b)
	 { try { date_person_date.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	 catch(Exception e)
	 { e.printStackTrace(); }	}

	 @FindBy(xpath="//select[@id='lbe_whichcategoryofcareapplies']")
	 public WebElement Please_advise_reason_Dpd;

	 @FindBy(xpath="//textarea[@id='lbe_description']")
	 public WebElement nature_care_textbox;


	 public void Enter_Describe_NatureOfCare(String sheetname, int a, int b)
	 { try { nature_care_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	 catch(Exception e)
	 { e.printStackTrace(); }    }


}
