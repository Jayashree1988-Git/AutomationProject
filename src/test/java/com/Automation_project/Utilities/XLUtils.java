package com.Automation_project.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	private FileInputStream fi;
	private XSSFWorkbook wb;
	private XSSFSheet ws;
	private XSSFRow row;
	private XSSFCell cell;
	
	public XLUtils(String path,String sheet) {
		try {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheet);
		}
		catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	
	public int getRowCount(){
	
		int rowCount=ws.getLastRowNum();
		Close();
		return rowCount;
		
	}
	
	public String getCellData(int rowIndex,int colIndex) {
		row=ws.getRow(rowIndex);
        cell=row.getCell(colIndex);
        DataFormatter formatter=new DataFormatter();
        String data;
        try {
        	data=formatter.formatCellValue(cell);
        }
        catch(Exception e) {
        	data="";
        }
		Close();
		return data;
		
	}
	
	public int getCellCount(int rowIndex) {
		row=ws.getRow(rowIndex);
		int cellCount=row.getLastCellNum();
		Close();
		return cellCount;
		
	}
	
	private  void Close()  {
		try {
			wb.close();
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	
	


}
