package com.Educational.SkillRaryApp.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookLikePage {

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement likebtn;

	public FaceBookLikePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void likeButton() {
		likebtn.click();
	}
}
