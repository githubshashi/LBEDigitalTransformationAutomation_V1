package digitaltransformation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class MyAccountClassE 
{

	WebDriver driver;
	WebDriverWait wait;
	ExtentTest logger;
	
	public MyAccountClassE(WebDriver rdriver)
	{
		this.driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
//WebElements using @find by initialization
	
	 @FindBy(linkText="First name of the person who is now residing in a hospital or care home - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed")  //Firstname invalid error message
	 public WebElement FirstnameErrorText;
	 
	 @FindBy(linkText="First name of the person who is now residing in a hospital or care home- Error: this field should contain at least one character")  //Firstname invalid error message for atleast one character
	 public WebElement FirstnameErrorTextAtleastOnechar;
	 
	 @FindBy(linkText="Last name of the person who is now residing in a hospital or care home - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed")  //Lastname invalid error message
	  public WebElement LastnameErrorText;
	 
	 @FindBy(linkText="Last name of the person who is now residing in a hospital or care home- Error: this field should contain at least two characters")  //Lastname invalid error message for atleast two character
	 public WebElement LastnameErrorTextAtleastTwochar;
	
}
