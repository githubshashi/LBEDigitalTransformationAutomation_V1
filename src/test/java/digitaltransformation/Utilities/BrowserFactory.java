package digitaltransformation.Utilities;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory 

{
		WebDriver driver;
		public static Logger logger;
		ReadConfig readconfig = new ReadConfig();
		public String baseURL=readconfig.getPortalURL();
		
		
	public BrowserFactory(WebDriver ldriver) {
		this.driver = ldriver;
	}

	public WebDriver startBrowser(String br ) 
	{	
		
		logger = Logger.getLogger("LBE Digital Transformation");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
		return driver;
		
	}	





}
