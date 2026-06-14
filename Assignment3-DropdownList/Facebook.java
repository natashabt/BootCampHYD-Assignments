package com.DropDownBox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Facebook {

    @Test
    public void dropdownTest() throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();

        // Open URL
        driver.get("https://www.facebook.com/campaign/landing.php");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        // Day Dropdown - selectByIndex
        Select day = new Select(driver.findElement(By.id("day")));
        day.selectByIndex(5);
        System.out.println("Selected Day : "
                + day.getFirstSelectedOption().getText());

        // Month Dropdown - selectByValue
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByValue("3");
        System.out.println("Selected Month : "
                + month.getFirstSelectedOption().getText());

        // Year Dropdown - selectByVisibleText
        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByVisibleText("2000");
        System.out.println("Selected Year : "
                + year.getFirstSelectedOption().getText());

        // Count Day Items
        List<WebElement> dayList = day.getOptions();
        System.out.println("Total Day Values = " + dayList.size());

        // Count Year Items
        List<WebElement> yearList = year.getOptions();
        System.out.println("Total Year Values = " + yearList.size());

        Thread.sleep(3000);

        driver.quit();
    }
}