package com.RadioButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtonTest {
	
	public void radioAndCheckBoxTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///D:/LTI%20SeleniuList<A>Samples/RadioButtons.html");
		
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("Total checkboxes = " + checkBoxes.size());
		
		for(WebElement cb : checkBoxes) {
			if(!cb.isSelected()) {
				cb.click();
			}
			System.out.println("Checkboxes selected = " + cb.isSelected());
		}
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println("Total Radio Buttons = \" + radioButtons.size()");
		
		for(WebElement rb : radioButtons) {
			rb.click();
			System.out.println("Radio Button Selected = " + rb.isSelected());
		}
	}
	
}
