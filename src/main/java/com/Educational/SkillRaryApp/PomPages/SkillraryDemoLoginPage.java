package com.Educational.SkillRaryApp.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryDemoLoginPage {
	public WebDriver driver;
	
	@FindBy(id="course")
	private WebElement coursetab;
	
	@FindBy(xpath="//a[text()='munit testing ']")
	private WebElement munit;
	
	@FindBy(xpath="//i[@class='fa fa-shopping-cart']")
	private WebElement cartbtn;
	
	@FindBy(xpath="//a[text()='Go to Cart']")
	private WebElement gotocart;
	
	public SkillraryDemoLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public AddtocartPage selectMunitSelecting() {
		munit.click();
		return new AddtocartPage(driver);
	}

	

	public WebElement getCoursetab() {
		return coursetab;
	}

	public WebElement getMunit() {
		return munit;
	}

}
