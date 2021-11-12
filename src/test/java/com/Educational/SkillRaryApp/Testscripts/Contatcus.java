package com.Educational.SkillRaryApp.Testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.Educational.SkillRaryApp.PomPages.ContactUsPage;
import com.Educational.SkillRaryApp.PomPages.SkillraryDemoLoginPage;
import com.Educational.SkillRaryApp.PomPages.SkillraryLoginPage;
import com.Educational.SkillRaryApp.genericLib.BaseClass;

public class Contatcus extends BaseClass{
	@Test
	public void tc2() throws FileNotFoundException, IOException {
		SkillraryLoginPage s=new SkillraryLoginPage(driver);
		driverUtilies.scrollToWebElement(driver,s.getContactusbtn());
		s.getContactusbtn().click();
	      ContactUsPage c = s.contact();
	      c.sndusEmail(fileUtilies.getPropertyData("fullname"),fileUtilies.getPropertyData("email"),fileUtilies.getPropertyData("subject"),fileUtilies.getPropertyData("message"));
	
	}
	

}
