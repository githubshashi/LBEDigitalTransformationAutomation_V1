package digitaltransformation.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import digitaltransformation.Utilities.ExcelReadWrite;
import digitaltransformation.Utilities.Utility;

public class MyAccountClassT 
{

	 WebDriver driver;
	 WebDriverWait wait;
	 ExtentTest logger;
	 
	 public MyAccountClassT(WebDriver ldriver) 
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
	 public WebElement First_name_person_textbox;
	 
	 @FindBy(linkText="First name of the person liable for council tax for the unoccupied annexe - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed")  //Firstname invalid error message
	 public WebElement FirstnameErrorText;

	 public void Enter_Firstnameperson(String sheetname,int a, int b)
	 { try { First_name_person_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	 catch(Exception e)
	 { e.printStackTrace(); }    }

	 @FindBy(xpath="//input[@id='lbe_accountholdersurname']")
	 public WebElement Last_name_person_textbox;
	 
	 @FindBy(linkText="Last name of the person liable for council tax for the unoccupied annexe - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed")  //Lastname invalid error message
	  public WebElement LastnameErrorText;
	 
	 @FindBy(linkText="Last name of the person liable for council tax for the unoccupied annexe- Error: this field should contain at least two characters")  //Lastname invalid error message for atleast one character
	 public WebElement LastnameErrorTextAtleastTwochar;
	 
	 public void Enter_Lastnameperson(String sheetname,int a, int b)
	 { try { Last_name_person_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	 catch(Exception e)
	 { e.printStackTrace(); }    }

	 @FindBy(xpath="//input[@id='lbe_account_phonemobilenumber']")
	 public WebElement Contact_telephone_number_textbox;

	 public void Contacttelephonenumber(String sheetname)
	 { try { Contact_telephone_number_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
	 catch(Exception e)
	 { e.printStackTrace(); }    }

//Application details

	 @FindBy(xpath="//input[@id='lbe_datethepropertybecameunoccupied_datepicker_description']")
	 public WebElement annexe_unoccupied_date;

	 public void Date_AnnexeUnoccupied(String sheetname,int a,int b)
	 { try { annexe_unoccupied_date.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	 catch(Exception e)
	 { e.printStackTrace(); }	} 

	 @FindBy(xpath="//textarea[@id='lbe_reasonpropertyisunoccupied']")
	 public WebElement Why_annexe_become_unoccupied_textbox;

	 public void Why_AnnexeUnoccupied(String sheetname,int a, int b)
	 { try { Why_annexe_become_unoccupied_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	 catch(Exception e)
	 { e.printStackTrace(); }    }

	 @FindBy(xpath="//textarea[@id='lbe_purposeannexedusedfor']")
	 public WebElement What_annexe_textbox;

	 public void Enter_AnnexeUsed_beforeUnoccupied(String sheetname,int a, int b)
	 { try { What_annexe_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	 catch(Exception e)
	 { e.printStackTrace(); }    }


	 @FindBy(xpath="//select[@id='lbe_istheannexeusedaspartofthemaindwelling']")
	 public WebElement council_Planning_Department_Dpd;








}
