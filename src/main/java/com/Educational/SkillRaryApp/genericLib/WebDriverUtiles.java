package com.Educational.SkillRaryApp.genericLib;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.io.Files;
/**
 * 
 * @author Bharani
 *
 */

public class WebDriverUtiles {
	
	/**
	 * To select the option from the dropdown using visibletext
	 * @param ele
	 * @param text
	 */
	public void dropDown(WebElement ele,String text) {
		Select s=new Select(ele);
		s.selectByVisibleText(text);
	}
	
	/**
	 * Fileuplaod
	 * @param command
	 * @throws IOException
	 */
	public void uploadFile(String command) throws IOException {
		Runtime.getRuntime().exec(command);
	}
	
	/**
	 * To mouse hover the element
	 * @param driver
	 * @param ele
	 */
	
	public void mouseHover(WebDriver driver,WebElement ele) {
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		}
	
	/**
	 * To perform right click
	 * @param driver
	 * @param ele
	 */
	public void rightClick(WebDriver driver,WebElement ele) {
		Actions a=new Actions(driver);
		a.contextClick(ele).perform();
		
	}
	/**
	 * To perform drag and drop
	 * @param driver
	 * @param src
	 * @param target
	 */
	
	public void dragandDrop(WebDriver driver,WebElement src,WebElement target) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, target).perform();
		
	}
	/**
	 * To perform doubleClick
	 * @param driver
	 * @param ele
	 */
	
	public void doubleClick(WebDriver driver,WebElement ele) {
		Actions a=new Actions(driver);
		a.doubleClick(ele).perform();
		
	}
	/**
	 * To switch the control to frame
	 * @param driver
	 */
	
	public void switchFrame(WebDriver driver) {
		driver.switchTo().frame(0);
	}
	
	/**
	 * To switch the control back from frame
	 * @param driver
	 */
	
	public void switchBack(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * To scroll to particular Element
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);
	}
	
	
	/**
	 * To switch the controlto alert and click on OK
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	
	/**
	 * To switch the controlto alert and click on Cancel
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * To maxmize the window
	 * @param driver
	 */
	public void maxmizeWin(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * To wait untill the page is loaded
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
	}
	
	/**
	 * To wait untill the elements are loaded
	 * @param driver
	 */
	
	public void waitForElementsLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	}
	
	
	/**
	 * To take screenshot of failed testcases
	 * @param driver
	 * @param name
	 * @throws IOException
	 */
	public File screenShot(WebDriver driver,String name) throws IOException {

		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(AutoConstant.photoPath+name+".png");
		Files.copy(src,dest);
		return dest;
		
	}
	/**
	 * To verify
	 * @param actual
	 * @param expected
	 * @param page
	 */
	
	public void verify(String actual,String expected,String page) {
		Assert.assertEquals(actual, expected);
		Reporter.log(page +"Is dispalyed ",true);
	}
	
	
	/**
	 * Switch between the windows
	 * @param driver
	 */
	
	public void switchTabs(WebDriver driver) {
		Set<String> window = driver.getWindowHandles();
		
		for(String allWin:window) {
			driver.switchTo().window(allWin);
		}
		
		
		
	
	}
	
	
	
	
	

}
