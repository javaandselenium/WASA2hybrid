package com.Educational.SkillRaryApp.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	
	@FindBy(name="name")
	private WebElement fullName;
	
	@FindBy(name="sender")
	private WebElement email;
	
	@FindBy(name="subject")
	private WebElement subject;
	
	@FindBy(name="message")
	private WebElement messagetb;
	
	@FindBy(xpath="//button[text()='Send us mail']")
	private WebElement sendusmail;
	
	
	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void sndusEmail(String fullname,String emailaddress,String sub,String msg) {
		fullName.sendKeys(fullname);
		email.sendKeys(emailaddress);
		subject.sendKeys(sub);
		messagetb.sendKeys(msg);
		sendusmail.click();
	}

	public WebElement getFullName() {
		return fullName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getSubject() {
		return subject;
	}

	public WebElement getMessagetb() {
		return messagetb;
	}

	public WebElement getSendusmail() {
		return sendusmail;
	}

}
