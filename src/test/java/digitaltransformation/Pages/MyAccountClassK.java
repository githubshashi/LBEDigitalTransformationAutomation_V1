package digitaltransformation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class MyAccountClassK
{

	 WebDriver driver;
	 WebDriverWait wait;
	 ExtentTest logger;
	 
	 public MyAccountClassK(WebDriver ldriver) 
		{		this.driver = ldriver;   
		PageFactory.initElements(ldriver, this);
		}
}
