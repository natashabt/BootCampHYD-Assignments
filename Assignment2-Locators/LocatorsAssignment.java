package com.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class LocatorsAssignment {
	
	WebDriver driver;
	String url = "https://www.easycalculation.com/index.php";
	
	@BeforeTest
	public void SetUp() {
		
		driver =  new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
	
	}
	
	@Test
	public void Loactors() throws Exception {
		
		WebElement ageCalculator  = driver.findElement(By.linkText("Age Calculator"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ageCalculator);
		//Thread.sleep(3000);
		ageCalculator.click();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total no. of links: " + links.size());
		
		List<WebElement> img = driver.findElements(By.tagName("img"));
		System.out.println("Total no. of images: " + img.size());
		
		for(int i = 0; i<10; i++) {
			System.out.println(links.get(i).getText());
		}
		
		for(int j = 0; j<5; j++) {
			System.out.println(img.get(j).getAttribute("src"));
		}
		
		WebElement age = driver.findElement(By.linkText("Age Calculator"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", age);
		
		
		driver.findElement(By.id("i21")).sendKeys("24");
		driver.findElement(By.id("i22")).sendKeys("10");
		driver.findElement(By.id("i23")).sendKeys("2004");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"dispCalcConts\"]/div[3]/form/table/tbody/tr[10]/td/input[1]")).click();	
		
		System.out.println("Your Age is: " + driver.findElement(By.xpath("//*[@id=\"r1\"]")).getAttribute("value"));
		System.out.println("Your Age in Days: " + driver.findElement(By.xpath("//*[@id=\"r4\"]")).getAttribute("value"));
		System.out.println("Your Age in Hours: " + driver.findElement(By.xpath("//*[@id=\"r3\"]")).getAttribute("value"));
		System.out.println("Your Age in Minutes: " + driver.findElement(By.xpath("//*[@id=\"r2\"]")).getAttribute("value"));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"dispCalcConts\"]/div[3]/form/table/tbody/tr[10]/td/input[2]")).click();
	
	}
	
	@AfterTest
	public void teardown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	
}
