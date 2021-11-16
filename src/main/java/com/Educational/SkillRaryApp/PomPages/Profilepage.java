package com.Educational.SkillRaryApp.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Profilepage {
	@FindBy(id="firstname")
	private WebElement firstName;
	
	@FindBy(id="lastname")
	private WebElement lastName;
	
	@FindBy(id="email")
	private WebElement emailtb;
	
	@FindBy(id="password")
	private WebElement passwordtb;
	
	@FindBy(id="contact")
	private WebElement contactinfo;
	
	@FindBy(id="address")
	private WebElement addresstb;
	
	@FindBy(id="curr_password")
	private WebElement password;
	
	@FindBy(xpath="//button[text()='Update']")
	private WebElement updatebtn;
	
	@FindBy(xpath="//input[@type='file']")
	private WebElement photo;
	
	public Profilepage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void updateDetails(String fn,String ln,String email,String pwd,String contact,String add) {
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		emailtb.sendKeys(email);
		password.sendKeys(pwd);
		contactinfo.sendKeys(contact);
		addresstb.sendKeys(add);
		
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmailtb() {
		return emailtb;
	}

	public WebElement getPasswordtb() {
		return passwordtb;
	}

	public WebElement getContactinfo() {
		return contactinfo;
	}

	public WebElement getAddresstb() {
		return addresstb;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getUpdatebtn() {
		return updatebtn;
	}

	public WebElement getPhoto() {
		return photo;
	}

}
