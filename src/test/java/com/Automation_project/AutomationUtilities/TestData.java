 package com.Automation_project.AutomationUtilities; 
                    
import java.util.HashMap;

import org.testng.annotations.DataProvider;

import com.Automation_project.Utilities.ReadConfig;
import com.Automation_project.Utilities.XLUtils;
//import com.sun.org.apache.bcel.internal.classfile.Method;
import java.lang.reflect.Method;

public class TestData {


	
	@SuppressWarnings("restriction")
	@DataProvider(name = "TestData")
    public Object[][]  DataForTest(Method m){
	
		
     	System.out.println("inside getdata method");
		ReadConfig readconfig=new ReadConfig("./Configuration/TestDataConfig.properties");
		String ExcelPath=readconfig.getExcelPath("ExcelPath1");
		Object Data[][]=null;
		String ExcelSheet="";
		System.out.println(m.getName());
		switch(m.getName()) {
   		  case "FillPersonalTest":
			ExcelSheet=readconfig.getExcelPath("sheet1");
			Data=ExtractData(ExcelPath,ExcelSheet);
			break;
   		  case "FillDates":
  			ExcelSheet=readconfig.getExcelPath("sheet2");
  			Data=ExtractData(ExcelPath,ExcelSheet);
  			break;
			
	   }
		return Data;

	}
	
	public String[][] ExtractData(String XlPath,String XlSheet){
		XLUtils XL=new XLUtils(XlPath,XlSheet);
		int rownum=XL.getRowCount();
		int colCount=XL.getCellCount(0);
		String data[][]=new String[rownum][colCount];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colCount;j++) {
				data[i-1][j]=XL.getCellData(i, j);
				//System.out.println(logindata[i-1][j]);
				
			}
			
		}
		return data;
		
	}
	

}
