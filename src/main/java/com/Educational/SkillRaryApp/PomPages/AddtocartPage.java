package com.Educational.SkillRaryApp.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtocartPage {
	public WebDriver driver;
	
	@FindBy(id="add")
	private WebElement plusbtn;
	
	@FindBy(xpath="//button[@ondblclick='addtocart()']")
    private WebElement addtocartbtn;
	
	@FindBy(xpath="//i[@class='fa fa-facebook']")
	private WebElement facebook;
	
	public AddtocartPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
				
	}
	
	public WebElement getPlusbtn() {
		return plusbtn;
	}

	public WebElement getAddtocartbtn() {
		return addtocartbtn;
	}

	public WebElement getFacebook() {
		return facebook;
	}

	public FaceBookLikePage facebooktab() {
		facebook.click();
		return new FaceBookLikePage(driver);
	}
}
