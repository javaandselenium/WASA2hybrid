package com.Educational.SkillRaryApp.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryLoginPage {
	public WebDriver driver;
	
@FindBy(xpath="//a[text()=' GEARS ']")
private WebElement gerasBtn;

public WebElement getGerasBtn() {
	return gerasBtn;
}

public WebElement getSkillraryDemoapp() {
	return skillraryDemoapp;
}

@FindBy(xpath="(//a[text()=' SkillRary Demo APP'])[2]")
private WebElement skillraryDemoapp;


@FindBy(xpath="//a[contains(text(),'Contact Us')]")
private WebElement contactusbtn;

public SkillraryLoginPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
	this.driver=driver;
}

public SkillraryDemoLoginPage skillraryDemoApplication() {
	gerasBtn.click();
	skillraryDemoapp.click();
	return new SkillraryDemoLoginPage(driver);
	
	
}

public WebElement getContactusbtn() {
	return contactusbtn;
}


public ContactUsPage contact() {
	contactusbtn.click();
	return new ContactUsPage(driver);
}
	
	
}
