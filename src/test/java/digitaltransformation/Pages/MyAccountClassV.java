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

public class MyAccountClassV 
{

	 public WebDriver driver;
	 public WebDriverWait wait;
	 ExtentTest logger;
	
	 
	 public MyAccountClassV(WebDriver ldriver) 
		{		
		 this.driver = ldriver;   
		 PageFactory.initElements(ldriver, this);
		}
	 
	 Utility ut=new Utility(driver);
//WebElements using @find by initialization

	@FindBy(xpath="//input[@id='lbe_accountnumber']")
	public WebElement CTaccountnumber_textbox;

	//Action for the webelement

	public void accountnumber(String sheetname)
	{ try { CTaccountnumber_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
	catch(Exception e)
	{ e.printStackTrace(); }    }


	//Need to add Postcode


	@FindBy(xpath="//input[@id='lbe_accountholderfirstname']")
	public WebElement First_name_diplomat_textbox;


	public void Enter_FirstNameofdiplomat(String sheetname, int a, int b)
	{ try { First_name_diplomat_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	catch(Exception e)
	{ e.printStackTrace(); }    }


	@FindBy(xpath="//input[@id='lbe_accountholdersurname']")
	public WebElement Last_name_diplomat_textbox;


	public void Enter_LastNameofdiplomat(String sheetname,int a, int b)
	{ try {Last_name_diplomat_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	catch(Exception e)
	{ e.printStackTrace(); }    }


	@FindBy(xpath="//input[@id='lbe_account_phonemobilenumber']")
	public WebElement mobilenumber_textbox;


	public void phonemobilenumber(String sheetname)
	{ try { mobilenumber_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
	catch(Exception e)
	{ e.printStackTrace(); }    }

	

	//Application details

	@FindBy(xpath="//select[@id='lbe_ispropertyyourmainresidence']")
	public WebElement property_residence_Dpd;

	public void Select_Residence_UnitedKingdom1(int a)
	{ try { 

		Select property_residence=new Select(property_residence_Dpd);
	property_residence.selectByIndex(a); 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
	catch(Exception e)
	{ e.printStackTrace(); }	}

//------------------------------------------------------------------------------
	@FindBy(xpath="//select[@id='lbe_havetenancyagreementfortheproperty']")
	public WebElement tenancy_agreement_Dpd;

	public void tenancyagreementproperty(String sheetname, int a)
	{ try { Select tenancy_agreement=new Select(tenancy_agreement_Dpd);
	tenancy_agreement.selectByIndex(a); 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
	catch(Exception e)
	{ e.printStackTrace(); }	}

//------------------------------------------------------------------------------
	@FindBy(xpath="//input[@id='lbe_datethepropertybecomethemainredsidence_datepicker_description']")
	public WebElement residence_UK_diplomat_date;

	public void EnterDate_residence_UK_diplomat(String sheetname,int a,int b)
	{ try { residence_UK_diplomat_date.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	catch(Exception e)
	{ e.printStackTrace(); }	} 

//------------------------------------------------------------------------------
	@FindBy(xpath="//input[@id='lbe_diplomaticstatus']")
	public WebElement Diplomatic_rank_textbox;

	public void Enter_Diplomatic_RankStatusPosition(String sheetname, int a,int b)
	{ try { Diplomatic_rank_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	catch(Exception e)
	{ e.printStackTrace(); }    }

//------------------------------------------------------------------------------
	@FindBy(xpath="//input[@id='lbe_countryconferringdiplomaticstatus']")
	public WebElement international_organisation_textbox;

	public void Enter_CountryInternational_organisation(String sheetname,int a,int b)
	{ try { international_organisation_textbox.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	catch(Exception e)
	{ e.printStackTrace(); }    }

	
//------------------------------------------------------------------------------
	@FindBy(xpath="//select[@id='lbe_diplomatabritishsubjectorbritishcitizen']")
	public WebElement British_citizen_Dpd;

	public void Britishcitizen(String sheetname, int a)
	{ 
		try { Select British_citizen=new Select(British_citizen_Dpd);
	British_citizen.selectByIndex(a); 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
	catch(Exception e)
	{ e.printStackTrace(); }	}

	
//------------------------------------------------------------------------------
	@FindBy(xpath="//select[@id='lbe_diplomatapermanentukresident']")
	public WebElement permanent_UK_resident_Dpd;


	public void permanentUKresident(String sheetname, int a)
	{ try { Select permanent_UK_resident=new Select(permanent_UK_resident_Dpd);
	permanent_UK_resident.selectByIndex(a); 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
	catch(Exception e)
	{ e.printStackTrace(); }	}


	 
}	 

