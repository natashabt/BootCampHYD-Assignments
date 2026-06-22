package com.testcase;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pagefactory.RegisterPage;
import com.utility.ExcelReader;

public class RegisterTest {
	WebDriver driver;

	String url = "https://www.login.hiox.com/register?referrer=easycalculation.com";

	@Parameters("browsername")
	@BeforeTest
	public void setup(String browsername) {

	if (browsername.equalsIgnoreCase("chrome")) {

	driver = new ChromeDriver();

	} else if (browsername.equalsIgnoreCase("firefox")) {

	driver = new FirefoxDriver();

	} else if (browsername.equalsIgnoreCase("edge")) {

	driver = new EdgeDriver();
	}

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void registerUser() throws IOException {
	XSSFSheet sheet = ExcelReader.getSheet();
	int rows = sheet.getLastRowNum();
	for (int i = 1; i <= rows; i++) {
	String displayName = sheet.getRow(i).getCell(0).getStringCellValue();
	String email = sheet.getRow(i).getCell(1).getStringCellValue();
	String password = sheet.getRow(i).getCell(2).getStringCellValue();
	String confirmPassword = sheet.getRow(i).getCell(3).getStringCellValue();
	driver.get(url);
	RegisterPage page = new RegisterPage(driver);
	page.enterDisplayName(displayName);
	page.enterEmail(email);
	page.enterPassword(password);
	page.enterConfirmPassword(confirmPassword);
	page.clickRegister();
	}
}

	@AfterTest
	public void tearDown() {

	if (driver != null) {

	driver.quit();
	}
  }
}
