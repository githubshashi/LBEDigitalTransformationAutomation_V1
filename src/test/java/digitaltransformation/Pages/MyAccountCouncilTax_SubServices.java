package digitaltransformation.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountCouncilTax_SubServices 

{
		WebDriver driver;
		WebDriverWait wait;
	 
	public MyAccountCouncilTax_SubServices(WebDriver rdriver)
	{
	this.driver=rdriver;
	PageFactory.initElements(rdriver, this);
	}

	//WebElements initialization
	@FindBy(xpath="//div[@id='6UnoccupiedpropertiesApplyforit']//div[8]")
	@CacheLookup
	public WebElement ClassBServicelink;
	
	@FindBy(xpath="//a[contains(text(),'Properties left empty by persons detained elsewher')]")
	@CacheLookup
	public WebElement ClassDServicelink;
	
	@FindBy(xpath="//a[contains(text(),'Annexe unoccupied due to a planning restriction ex')]")
	@CacheLookup
	public WebElement ClassTServicelink;
	
	@FindBy(xpath="//a[contains(text(),'Properties left empty by patients in hospitals and')]")
	@CacheLookup
	public WebElement ClassEServicelink;
	
	@FindBy(xpath="//a[contains(text(),'Properties left empty following the death of the l')]")
	@CacheLookup
	public WebElement ClassFServicelink;
	
	@FindBy(xpath="//a[contains(text(),'Properties that cannot be lived in by law (Class G')]")
	@CacheLookup
	public WebElement ClassGServicelink;
	
	@FindBy(xpath="//a[contains(text(),'Property empty awaiting occupation by ministers of')]")
	@CacheLookup
	public WebElement ClassHServicelink;
	
	@FindBy(xpath="//a[contains(text(),'Properties left empty by people receiving care els')]")
	@CacheLookup
	public WebElement ClassIServicelink;
	
	@FindBy(xpath="//a[contains(text(),'Properties left empty by people providing care els')]")
	@CacheLookup
	public WebElement ClassJServicelink;
	
	@FindBy(xpath="//a[contains(text(),'Properties left empty by students, if one of the s')]")
	@CacheLookup
	public WebElement ClassKServicelink;
	
	@FindBy(xpath="//a[contains(text(),'Properties left empty due to repossession exemptio')]")
	@CacheLookup
	public WebElement ClassLServicelink;
	
	@FindBy(xpath="//a[contains(text(),'Properties lived in by diplomat')]")
	@CacheLookup
	public WebElement ClassVServicelink;
	
	@FindBy(xpath="//a[contains(text(),'Properties left empty by people who have been made')]")
	@CacheLookup
	public WebElement ClassQServicelink;
	
	@FindBy(xpath="//a[contains(text(),'Unoccupied caravan pitch or boat mooring exemption')]")
	@CacheLookup
	public WebElement ClassRServicelink;
	
	@FindBy(xpath="//a[contains(text(),'Vacant property discount application')]")
	@CacheLookup
	public WebElement VPDAServicelink;
	
	//Action for that WebElements
	
	public void ClickonclassBlink()
	{		ClassBServicelink.click();  	}
	
	public void ClickonclassDlink()
	{		ClassDServicelink.click();  	}
	
	public void ClickonclassTlink()
	{		ClassTServicelink.click();   	}
	
	public void ClickonclassElink()
	{		ClassEServicelink.click();   	}
	
	public void ClickonclassFlink()
	{		ClassFServicelink.click();   	}
	
	public void ClickonclassGlink()
	{		ClassGServicelink.click();   	}
	
	public void ClickonclassHlink()
	{		ClassHServicelink.click();   	}
	
	public void ClickonclassIlink()
	{		ClassIServicelink.click();   	}
	
	public void ClickonclassJlink()
	{		ClassJServicelink.click();   	}
	
	public void ClickonclassKlink()
	{		ClassKServicelink.click();   	}
	
	public void ClickonclassLlink()
	{		ClassLServicelink.click();   	}
	
	public void ClickonclassVlink()
	{		ClassVServicelink.click();   	}
	
	public void ClickonclassQlink()
	{		ClassQServicelink.click();   	}
	
	public void ClickonclassRlink()
	{		ClassRServicelink.click();   	}
	
	public void ClickonVPDAlink()
	{		VPDAServicelink.click();   	}
	

	
}
