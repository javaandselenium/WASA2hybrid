package com.Educational.SkillRaryApp.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtilies extends BaseClass{
	
	@DataProvider
	public Object[][] readData() throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(AutoConstant.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rowNum = sh.getLastRowNum();
		System.out.println(rowNum);
		short cellNum = sh.getRow(1).getLastCellNum();
		System.out.println(cellNum);
		
		Object obj[][]=new Object[rowNum][cellNum];
		for(int i=0;i<rowNum;i++) {
			for(int j=0;j<cellNum;j++) {
				obj[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				System.out.println(obj[i][j]);
			}
		}
		return obj;
		
		
	}
	
	
}
