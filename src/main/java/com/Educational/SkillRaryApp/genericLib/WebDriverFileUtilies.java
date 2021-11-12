package com.Educational.SkillRaryApp.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

import com.aventstack.extentreports.reporter.AbstractReporter;
import com.mysql.cj.jdbc.Driver;

/**
 * 
 * @author Bharani
 *
 */

public class WebDriverFileUtilies {
	public static Connection con;

	/**
	 * read the data from property file
	 * 
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getPropertyData(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileInputStream(AutoConstant.propertyFilePath));
		return p.getProperty(key);
	}

	/**
	 * read the data from excel sheet
	 * 
	 * @param name
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String getExcelData(String name, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(AutoConstant.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		String s = wb.getSheet(name).getRow(rownum).getCell(cellnum).getStringCellValue();
		return s;

	}
	
	/**
	 * Register the database
	 * @return
	 * @throws SQLException
	 */

	public static Connection getDataDb() throws SQLException {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		return con = DriverManager.getConnection(AutoConstant.mysqlUrl,"root","root");

	}
	/**
	 * Execute the query and compare
	 * @param query
	 * @param column
	 * @param ExceptedData
	 * @return
	 * @throws SQLException
	 */
	
	public static String queryExecution(String query,int column,String ExceptedData) throws SQLException {
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		
		while(result.next()) {
			if(result.getString(column).equals(ExceptedData)) {
				break;
			}
			else
			{
				Reporter.log("Data not found",true);
				
			}
		}
		return ExceptedData;
	}
	
	/**
	 * close the database
	 * @throws SQLException
	 */
	public static void closeDb() throws SQLException {
		con.close();
	}
	

}
