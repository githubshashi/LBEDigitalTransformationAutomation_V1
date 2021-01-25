package digitaltransformation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class MyAccountClassJ 
{

	WebDriver driver;
	WebDriverWait wait;
	ExtentTest logger;
	
	public MyAccountClassJ(WebDriver rdriver) 
	{
	 this.driver=rdriver;
	 PageFactory.initElements(rdriver, this);
	}
	
}
