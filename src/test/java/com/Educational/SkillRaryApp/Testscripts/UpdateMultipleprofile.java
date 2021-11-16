package com.Educational.SkillRaryApp.Testscripts;

import org.testng.annotations.Test;

import com.Educational.SkillRaryApp.PomPages.Profilepage;
import com.Educational.SkillRaryApp.genericLib.ExcelUtilies;

public class UpdateMultipleprofile extends ExcelUtilies{
	@Test(dataProvider = "readData")
	public void tc3(String fn,String ln,String email,String pwd,String contact,String add)  {
		Profilepage p=new Profilepage(driver);
	p.updateDetails(fn, ln, email, pwd, contact, add);
	}

}
