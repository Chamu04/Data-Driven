package Datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Annot {
	
	public WebDriver driver= null;
	
	@Test
	public void Login() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Pramod\\eclipse-workspace\\DataDriven\\Properties.properties");
		prop.load(fis);
		
		//System.out.println(prop.getProperty("username"));
		
		if(prop.getProperty("browser").equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Work\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else
		{
			System.setProperty("webdriver.ie.driver", "C:\\Work\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		
		driver.get(prop.getProperty("url"));
		
	}

}
