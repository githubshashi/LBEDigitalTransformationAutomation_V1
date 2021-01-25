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

public class MyAccountClassG 
{

	 WebDriver driver;
	 WebDriverWait wait;
	 ExtentTest logger;
	 
	 public MyAccountClassG(WebDriver ldriver) 
		{		this.driver = ldriver;   
		PageFactory.initElements(ldriver, this);
		}

		 //WebElements using @find by initialization

		 @FindBy(xpath="//input[@id='lbe_accountnumber']")
		 public WebElement CT_number_textbox;

		 //Action for the webelement

		 public void Counciltaxnumber(String sheetname)
		 { try { CT_number_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
		 catch(Exception e)
		 { e.printStackTrace(); }    }


		 //Need to add postcode

		 @FindBy(xpath="//input[@id='lbe_fullnameoftheorganisationliable']")
		 public WebElement name_person_organisation_textbox;


		 public void Enter_FullNameof_Person_Organisation(String sheetname, int a, int b)
		 { try { name_person_organisation_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
		 catch(Exception e)
		 { e.printStackTrace(); }    }

		 //Need to add postcode

		 @FindBy(xpath="//input[@id='lbe_account_phonemobilenumber']")
		 public WebElement telephone_number_textbox;


		 public void telephonenumber(String sheetname)
		 { try { telephone_number_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
		 catch(Exception e)
		 { e.printStackTrace(); }    }

	//Appliaction details-----------------------------

		 @FindBy(xpath="//input[@id='lbe_datethepropertybecameunoccupied_datepicker_description']")
		 public WebElement property_became_unoccupied_date;

		 public void Enter_DateOfPropertyUnoccupied(String sheetname,int a,int b)
		 { try { property_became_unoccupied_date.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
		 catch(Exception e)
		 { e.printStackTrace(); }	} 


		 @FindBy(xpath="//select[@id='lbe_whatnoticehasbeenissued']")
		 public WebElement legal_notice_Dpd;


		 @FindBy(xpath="//input[@id='lbe_whatistheeffectivedateofprohibition_datepicker_description']")
		 public WebElement prohibition_occupation_date;

		 public void Enter_EffectiveDate_prohibitionofoccupation(String sheetname,int a,int b)
		 { try { prohibition_occupation_date.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
		 catch(Exception e)
		 { e.printStackTrace(); }	} 

		 @FindBy(xpath="//textarea[@id='lbe_description']")
		 public WebElement provide_further_information_textbox;


		 public void Enter_AnyFurtherInformation(String sheetname,int a,int b)
		 { try { provide_further_information_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
		 catch(Exception e)
		 { e.printStackTrace(); }    }
		 


}
