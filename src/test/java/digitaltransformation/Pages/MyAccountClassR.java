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

public class MyAccountClassR 
{

	 WebDriver driver;
	 WebDriverWait wait;
	 ExtentTest logger;
	 
	 public MyAccountClassR(WebDriver ldriver) 
		{		this.driver = ldriver;   
		PageFactory.initElements(ldriver, this);
		}

	 
	//WebElements using @find by initialization

	 @FindBy(xpath="//input[@id='lbe_accountnumber']")
	 public WebElement Council_tax_number_textbox;

	 //Action for the webelement

	 public void Counciltaxnumber(String sheetname)
	 { try { Council_tax_number_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
	 catch(Exception e)
	 { e.printStackTrace(); }    }

	 //Need to add address

	 @FindBy(xpath="//input[@id='lbe_contactnameforanyenquiries']")
	 public WebElement Name_owner_pitch_textbox;

	 public void Enter_Name_Owner_pitch_mooring(String sheetname,int a,int b)
	 { try { Name_owner_pitch_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	 catch(Exception e)
	 { e.printStackTrace(); }    }

	 //Need to add address

	 @FindBy(xpath="//input[@id='lbe_account_phonemobilenumber']")
	 public WebElement Contact_telephone_number_textbox;

	 public void telephonenumber(String sheetname)
	 { try { Contact_telephone_number_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
	 catch(Exception e)
	 { e.printStackTrace(); }    }

	 //Application details

	 @FindBy(xpath="//select[@id='lbe_propertyaboatmooringoracaravanpitch']")
	 public WebElement caravan_pitch_Dpd;

//	 public void caravanpitch(String sheetname, int a)
//	 { try { Select caravan_pitch=new Select(caravan_pitch_Dpd);
//	 caravan_pitch.selectByIndex(a); 
//	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
//	 catch(Exception e)
//	 { e.printStackTrace(); }	}

	 @FindBy(xpath="//input[@id='lbe_datethepropertybecameunoccupied_datepicker_description']")
	 public WebElement date_mooring_vacated_date;

	 public void Enter_Mooring_Pitch_Vacated_Date(String sheetname,int a,int b)
	 { try { date_mooring_vacated_date.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	 catch(Exception e)
	 { e.printStackTrace(); }	} 
	




}
