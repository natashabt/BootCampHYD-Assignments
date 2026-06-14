package com.Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utility.Helper;

public class AlertsTest {
	
	@Test
	public void TestPopups() {
		
		WebDriver driver = Helper.startBrowser("GC");		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
		
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.accept();
		String result1 = driver.findElement(By.id("result")).getText();
		System.out.println("Result : " + result1);
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert confirmAlert = driver.switchTo().alert();
        
        System.out.println("Confirm Alert Message : " + confirmAlert.getText());
        confirmAlert.dismiss();
        String result2 = driver.findElement(By.id("result")).getText();
        System.out.println("Result : " + result2);
        
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        Alert promptAlert = driver.switchTo().alert();

        promptAlert.sendKeys("Natasha");

        promptAlert.accept();

        String result3 = driver.findElement(By.id("result")).getText();
        System.out.println("Result : " + result3);

        driver.quit();
		
		
		
		
		
	}

}
