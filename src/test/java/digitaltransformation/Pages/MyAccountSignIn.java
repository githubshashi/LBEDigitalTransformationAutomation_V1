package digitaltransformation.Pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import digitaltransformation.Utilities.ExcelReadWrite;
import digitaltransformation.Utilities.Utility;



public class MyAccountSignIn {

	
	 WebDriver ldriver;
	 WebDriverWait wait;
	
	public MyAccountSignIn(WebDriver rdriver) 
	{
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//WebElements list
	
	@FindBy(xpath="//input[@id='logonIdentifier']")
	@CacheLookup
	public WebElement Username;
	
	@FindBy(xpath="//input[@id='password']")
	@CacheLookup
	public WebElement Password;
	
	@FindBy(xpath="//button[@id='next']")
	@CacheLookup
	public WebElement SignInbutton;
	
	//Action for the WebElements
	public void Enter_Username(int a , int b) throws InterruptedException
	{		
		
		Username.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, Utility.Sh_CommonDetails,a,b));
	}
	public void Enter_Password(int a, int c)
	{	
		Password.sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, Utility.Sh_CommonDetails,a,c));
	}
	public void Click_SignIn(int a, int b , int c) throws InterruptedException
	{	
		Thread.sleep(2000);
		Enter_Username(a, b);
		Enter_Password(a, c);
		JavascriptExecutor js = (JavascriptExecutor) ldriver;	
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");  //This will scroll the web page till end.
		//SignInbutton.click();
        js.executeScript("arguments[0].click()", SignInbutton);
	}
}
