package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Helper {
	
	public static WebDriver startBrowser(String Browser) {
		WebDriver driver = null;
		 if(Browser.equalsIgnoreCase("GC")) {
			 driver = new ChromeDriver();
		 }
		 else if (Browser.equalsIgnoreCase("Edge")){
			 driver = new EdgeDriver();
			 
		 }
		 
		 driver.manage().window().maximize();
		 return driver;
	}

}
