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

public class MyAccountClassL 
{

	 WebDriver driver;
	 WebDriverWait wait;
	 ExtentTest logger;
	 
	 public MyAccountClassL(WebDriver ldriver) 
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

		 @FindBy(xpath="//input[@id='lbe_accountholderfirstname']")
		 public WebElement First_name_council_payer_textbox;

		 public void Enter_Firstname_CT_Payer(String sheetname, int a, int b)
		 { try { First_name_council_payer_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
		 catch(Exception e)
		 { e.printStackTrace(); }    }


		 @FindBy(xpath="//input[@id='lbe_accountholdersurname']")
		 public WebElement Last_name_council_payer_textbox;

		 public void Enter_Lastname_CT_Payer(String sheetname, int a, int b)
		 { try { Last_name_council_payer_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
		 catch(Exception e)
		 { e.printStackTrace(); }    }


		 @FindBy(xpath="//input[@id='lbe_account_phonemobilenumber']")
		 public WebElement telephone_number_textbox;

		 public void Contacttelephonenumber(String sheetname)
		 { try { telephone_number_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
		 catch(Exception e)
		 { e.printStackTrace(); }    }
		 

		 @FindBy(xpath="//input[@id='lbe_account_emailaddress']")
		 public WebElement Email_textbox;

		 public void Enter_Email(String sheetname,int a, int b)
		 { try { Email_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
		 catch(Exception e)
		 { e.printStackTrace(); }    }

 //Application details page-----------------------------------------------------

		 @FindBy(xpath="//input[@id='lbe_datethepropertybecameunoccupied_datepicker_description']")
		 public WebElement property_became_unoccupied_date;

		 public void Enter_Property_Unoccupied_Date(String sheetname,int a,int b)
		 { try { property_became_unoccupied_date.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
		 catch(Exception e)
		 { e.printStackTrace(); }	} 


		 @FindBy(xpath="//select[@id='lbe_isthepropertyfurnished']")
		 public WebElement property_unfurnished_vacation_Dpd;

		 @FindBy(xpath="//input[@id='lbe_repossessiondate_datepicker_description']")
		 public WebElement date_repossession_Date;

		 public void Enter_DateOfRepossesion(String sheetname,int a,int b)
		 { try { date_repossession_Date.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
		 catch(Exception e)
		 { e.printStackTrace(); }	}

		 @FindBy(xpath="//input[@id='lbe_mortgagelendername']")
		 public WebElement repossessed_the_property_textbox;

		 public void Enter_Bank_Building_repossessed(String sheetname,int a,int b)
		 { try { repossessed_the_property_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
		 catch(Exception e)
		 { e.printStackTrace(); }    }

		 @FindBy(xpath="//input[@id='lbe_referencenumberoftherepossession']")
		 public WebElement reference_number_repossession_textbox;

		 public void Enter_further_Enquiry_ReferenceNumber(String sheetname,int a,int b)
		 { try { reference_number_repossession_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
		 catch(Exception e)
		 { e.printStackTrace(); }    }

		 //Need to add address

		 @FindBy(xpath="//input[@id='lbe_newtenancycommencedate_datepicker_description']")
		 public WebElement London_Borough_Ealing_Date;

		 public void Enter_TanencyStartDate(String sheetname,int a,int b)
		 { try { London_Borough_Ealing_Date.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
		 catch(Exception e)
		 { e.printStackTrace(); }	}

	
}
