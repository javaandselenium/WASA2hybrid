package com.Educational.SkillRaryApp.Testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Educational.SkillRaryApp.genericLib.BaseClass;

public class Demo extends BaseClass {
	@Test
	public void tc1() throws IOException {
		
		driver.findElement(By.id("photo")).click();
		Runtime.getRuntime().exec("C:\\Users\\QSP\\Desktop\\Autoit\\srupload1.exe");
	}

}
