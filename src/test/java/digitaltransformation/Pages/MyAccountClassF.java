package digitaltransformation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountClassF 
{

	WebDriver driver;
	WebDriverWait wait;
	
	public MyAccountClassF(WebDriver rdriver)
	{
		this.driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
}
