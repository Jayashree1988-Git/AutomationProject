package com.Automation_project.TestCases;

import static org.junit.Assert.assertTrue;

//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Automation_project.AutomationUtilities.BaseClass;
import com.Automation_project.PageObjects.DemocartPageLayout;
import com.Automation_project.PageObjects.FormPage;
import com.Automation_project.PageObjects.PaginationWebTable;

public class PaginationTest002 extends BaseClass{
	
	
	@Test
	public void PaginationTest() throws InterruptedException
	{
		//System.out.println(driver.toString());
		
	    log.info("starting Pagination test");
	    //DemocartPageLayout dp=new DemocartPageLayout(driver);
	    PaginationWebTable p=new PaginationWebTable(driver);
		//dp.ClickMarketingAffliate();
		String pagetitle=p.getPageTitle();
		
		if(pagetitle.equals("Pagination Web Table")) {
			Assert.assertTrue(true);
			
		}
		else {
			Assert.assertTrue(false);
		}
		p.pagination();
	}

}
