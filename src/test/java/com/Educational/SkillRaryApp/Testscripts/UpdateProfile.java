package com.Educational.SkillRaryApp.Testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Educational.SkillRaryApp.PomPages.Profilepage;
import com.Educational.SkillRaryApp.genericLib.AutoConstant;
import com.Educational.SkillRaryApp.genericLib.BaseClass;

public class UpdateProfile extends BaseClass{
	@Test
	public void tc3() throws IOException, InterruptedException  {
	Profilepage p=new Profilepage(driver);
	//p.updateDetails();
	Thread.sleep(5000);
	p.getPhoto().click();
	Thread.sleep(5000);
	driverUtilies.uploadFile("‪C:\\Users\\QSP\\Desktop\\Autoit\\srupload1.exe");
	
	p.getPasswordtb().sendKeys("5645645");
	p.getUpdatebtn().click();
	}
	

}
