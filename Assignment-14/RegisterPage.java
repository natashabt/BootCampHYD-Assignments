package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {

	this.driver = driver;

	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='xreg_usr']")
	WebElement displayName;

	@FindBy(xpath = "//input[@id='xreg_email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='xreg_pass']")
	WebElement password;

	@FindBy(id = "//input[@id='xreg_confirm']")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@id='xreg_submit']")
	WebElement registerButton;

	public void enterDisplayName(String name) {

	displayName.sendKeys(name);
	}

	public void enterEmail(String mail) {

	email.sendKeys(mail);
	}

	public void enterPassword(String pass) {

	password.sendKeys(pass);
	}

	public void enterConfirmPassword(String cpass) {

	confirmPassword.sendKeys(cpass);
	}

	public void clickRegister() {

	registerButton.click();
	}
	}
