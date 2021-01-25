package digitaltransformation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountProfile 
{

	 public WebDriver ldriver;
	 WebDriverWait wait;
	
	 //PageFactory initializing
	public MyAccountProfile(WebDriver rdriver) 
	{
		this.ldriver = rdriver;	
		PageFactory.initElements(rdriver, this);
	}
	
	
	
	// Web Elements list 
		@FindBy(xpath="//body/div[1]/div[3]/div[2]/div[1]/ul[1]/li[1]/a[1]")
		@CacheLookup
		public WebElement homeicon;
	
	// Action on the perticular WebElements
		public void ClickHomeIcon()
		{
			homeicon.click();
		}	
	
}
