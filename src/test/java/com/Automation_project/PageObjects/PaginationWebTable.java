package com.Automation_project.PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation_project.AutomationUtilities.ActionControls;
import com.Automation_project.AutomationUtilities.AutomationControls;
import com.Automation_project.AutomationUtilities.DriverControls;
import com.Automation_project.AutomationUtilities.JSEControls;

public class PaginationWebTable {
	
	private  WebDriver ldriver;
	private AutomationControls ac;
	private JSEControls jse;
	private ActionControls act;
	private DriverControls dc;
	
	public PaginationWebTable( WebDriver rdriver) {
		
		ldriver=rdriver;
		System.out.println("rdriver"+rdriver.toString());
		System.out.println("rdriver"+ldriver.toString());
		ac=new AutomationControls(ldriver);
		dc=new DriverControls(ldriver);
//		jse=new JSEControls(ldriver);
//		act=new ActionControls(ldriver);
		PageFactory.initElements(rdriver, this);
		
		
	}
	
	

   @FindBy(xpath=".//div[@class='column-center-inner']//*[text()='Pagination Web Table']") @CacheLookup  WebElement PagenationTitle;
   @FindBy(xpath="//form[@id='form-affiliate']//*[contains(text(),'Pages')]") @CacheLookup  WebElement PaginationPages;
  
   
   
   public String getPageTitle() {
	 String Pagination=  ac.getText(PagenationTitle, 5);
	 System.out.println(Pagination);
	 return Pagination;
	  
   }
   public void pagination() throws InterruptedException {
	   By PageCount=By.xpath(".//ul[@id='pagination']//li");
	   List<WebElement> PageList = dc.FindElements(PageCount, 5);
	   int pCount=PageList.size();
       //int nPages=Integer.parseInt(ToP.substring(ToP.indexOf("(")+1,ToP.indexOf("Pages")-1));
       System.out.println(pCount);
       selectCheckBox();
       for(int i=2;i<=pCount;i++) {
    	    By Pagelocator=By.xpath(".//ul[@id='pagination']//*[text()="+i+"]");
			WebElement PageClick=dc.FindElement(Pagelocator, 5);
			Thread.sleep(2000);
			ac.Click(PageClick, 5);
			selectCheckBox();
       }
	   
	   
	   
   }
   public void selectCheckBox() throws InterruptedException {
	   By RowCount=By.xpath(".//table[@id='productTable']//child::tbody//child::tr");
	   List<WebElement> RowList = dc.FindElements(RowCount, 5);
	   int rowCount=RowList.size();
       //int nPages=Integer.parseInt(ToP.substring(ToP.indexOf("(")+1,ToP.indexOf("Pages")-1));
       System.out.println(rowCount);
       for(int i=1;i<=rowCount;i++) {
    	    By CheckBoxlocator=By.xpath(".//table[@id='productTable']//child::tbody//child::tr["+i+"]//input");
			WebElement CheckBoxClick=dc.FindElement(CheckBoxlocator, 5);
			boolean Result=ac.IsSelected(CheckBoxClick);
			Thread.sleep(1000);
			if(!Result) 
			ac.Click(CheckBoxClick, 5);
       }
   }

}
