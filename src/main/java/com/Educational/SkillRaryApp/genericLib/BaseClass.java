package com.Educational.SkillRaryApp.genericLib;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.xssf.usermodel.ListAutoNumber;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mongodb.connection.Connection;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public WebDriverFileUtilies fileUtilies = new WebDriverFileUtilies();
	public static java.sql.Connection con;
	public ExtentHtmlReporter htmlreport;
	public ExtentReports reports;
	public WebDriverUtiles driverUtilies=new WebDriverUtiles();
	public static ExtentTest test;

	@BeforeSuite
	public void configBS() throws SQLException {
		con = fileUtilies.getDataDb();

		htmlreport = new ExtentHtmlReporter(AutoConstant.reportPath);
		htmlreport.config().setDocumentTitle("SkillraryReports");
		htmlreport.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(htmlreport);

	}
	
	
	@BeforeMethod
	public void configBM() throws FileNotFoundException, IOException {
	ChromeDriverManager.chromedriver().setup();	
	driver=new ChromeDriver();
	driverUtilies.maxmizeWin(driver);
	//driver.get(fileUtilies.getPropertyData("url"));
	driver.get("https://demoapp.skillrary.com/profile_update.php");
	driverUtilies.waitForElementsLoad(driver);
	
	
	}
	
	@AfterMethod
	public void closeApp(ITestResult res) {
		int status = res.getStatus();
		if(status==ITestResult.FAILURE) {
			test.log(Status.FAIL,res.getName()+"Test case failed");
			test.log(Status.FAIL,res.getThrowable()+"Test case failed eception");
		}
		else if(status==ITestResult.SUCCESS) {
			test.log(Status.PASS,res.getName()+"Test case passed");
			
		}
		else if(status==ITestResult.SKIP) {
			test.log(Status.SKIP,res.getName()+"Test case skipped");
		}
		
	}
	
	
	@AfterSuite
	public void configAS() throws SQLException {
		htmlreport.flush();
		reports.flush();
		fileUtilies.closeDb();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
