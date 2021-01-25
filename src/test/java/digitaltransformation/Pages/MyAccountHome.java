package digitaltransformation.Pages;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountHome {

	 public WebDriver ldriver;
	 WebDriverWait wait;
	 
	public MyAccountHome(WebDriver rdriver) 
	{
		this.ldriver = rdriver;	
		PageFactory.initElements(rdriver, this);
	}
	
// Web Elements list 
	@FindBy(xpath="//div[@class='container-fluid']//li[1]//a[1]")
	@CacheLookup
	public WebElement homeicon;
	
	@FindBy(xpath="//button[@id='coll2']")
	@CacheLookup
	public WebElement WhatSerivice_button;
	
	@FindBy(xpath="//ul[@class='dropdown-list']//a[contains(text(),'Council tax')]")
	@CacheLookup
	public WebElement CouncilTax_linkbutton;
		
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	@CacheLookup
	public WebElement signInlink;
		
	
// Action on the perticular WebElements
	public void ClickHomeIcon()
	{
		homeicon.click();
	}	
	public void ClickonSignIn() 
	{
		signInlink.click();
	}	
	public void Click_WhatSerivice()
	{
		WhatSerivice_button.click();	
	}
	public void ClickonCounciltax()
	{
		CouncilTax_linkbutton.click();
	}
	
}
