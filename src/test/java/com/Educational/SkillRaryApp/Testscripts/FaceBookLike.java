package com.Educational.SkillRaryApp.Testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Educational.SkillRaryApp.PomPages.AddtocartPage;
import com.Educational.SkillRaryApp.PomPages.FaceBookLikePage;
import com.Educational.SkillRaryApp.PomPages.SkillraryDemoLoginPage;
import com.Educational.SkillRaryApp.PomPages.SkillraryLoginPage;
import com.Educational.SkillRaryApp.genericLib.BaseClass;
import com.Educational.SkillRaryApp.genericLib.ListenerImp;

@Listeners(ListenerImp.class)
public class FaceBookLike extends BaseClass{
	@Test
	public void tc1() throws SQLException, FileNotFoundException, IOException, InterruptedException {
		test=reports.createTest("tc1");
		
		SkillraryLoginPage s=new SkillraryLoginPage(driver);
		SkillraryDemoLoginPage ds = s.skillraryDemoApplication();
		driverUtilies.switchTabs(driver);
		System.out.println("control switched");
		
	    driverUtilies.mouseHover(driver,ds.getCoursetab());
	
	     AddtocartPage mu = ds.selectMunitSelecting();
	   
	     String data = fileUtilies.queryExecution("select * from munitcp;",1,"INR 19.00");
	     driverUtilies.verify(data,"INR 19.00","CoursePge");
	     
	     
	     driverUtilies.doubleClick(driver,mu.getPlusbtn());
	     mu.getAddtocartbtn().click();
	     driverUtilies.acceptAlert(driver);
	     
	    FaceBookLikePage fb = mu.facebooktab();
	    fb.likeButton();
	    
	    driverUtilies.verify(driver.getTitle(),fileUtilies.getPropertyData("fbTitle"),"FacebookloginPage");
		
		
		
		
	
	
	}
	
	

}
