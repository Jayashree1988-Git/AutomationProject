package com.Automation_project.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	private Properties pro;
	public ReadConfig(String path) {
		File src=new File(path);
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
				
		}
		catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
				
	
	public String getExcelPath(String ExcelPath) {
		String ExcelSheetPath=pro.getProperty(ExcelPath);
		return ExcelSheetPath;
		
	}
	public String getExcelSheet(String sheetname) {
		String ExcelSheetName=pro.getProperty(sheetname);
		return ExcelSheetName;
		
	}
	public String getBaseURL() {
		String URL=pro.getProperty("baseURL");
		return URL;
		
	}
	
//	public String getLoginUserName() {
//		String UserName=pro.getProperty("loginusername");
//		return UserName;
//		
//	}
//
//	public String getLoginPassword() {
//		String Password=pro.getProperty("password");
//		return Password;
//		
//	}
	public String getChromePath() {
		String CPath=pro.getProperty("chromepath");
		return CPath;
		
	}
	
	public String getFirefoxPath() {
		String fPath=pro.getProperty("firefoxpath");
		return fPath;
		
	}
	
	public String getScreenShotPath() {
		String sPath=pro.getProperty("ScreenshotPath");
		return sPath;
		
	}
	
	
	public String getExtentReportsPath() {
		String erPath=pro.getProperty("ExtentReportsPath");
		return erPath;
		
	}
	

}
