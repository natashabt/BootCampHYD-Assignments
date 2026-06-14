package com.Waits;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utility.Helper;

public class ImplicitWait {
	
	@Test
	public void spicejetTest() {
		WebDriver driver = Helper.startBrowser("gc");
		
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.navigate().to("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Map<String, Object> prf = new HashMap<>();
		prf.put("Profile.default_content_setting_values.geolocation", 2);
		prf.put("Profile.default_content_setting_values.notifications", 2);
		
		ChromeOptions options = new ChromeOptions();
		
		options.setExperimentalOption("prefs", prf);
		driver = new ChromeDriver(options);
		
		driver.findElement(By.id("FromSector_Show")).sendKeys("Amritsar", Keys.ENTER);
		driver.findElement(By.id("Editbox13_show")).click();
		driver.findElement(By.xpath("//input[@data-focusvisible-polyfill='true']")).click();
		
		driver.findElement(By.id("ddate")).click();
		driver.findElement(By.id("fst_5_03/07/2026")).click();
		driver.findElement(By.className("srchBtnSe")).click();
		
		
		
	}

}
