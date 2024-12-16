package com.Automation_project.TestCases;

import static org.junit.Assert.assertTrue;

//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Automation_project.AutomationUtilities.BaseClass;
import com.Automation_project.AutomationUtilities.TestData;
import com.Automation_project.PageObjects.DemocartPageLayout;
import com.Automation_project.PageObjects.FormPage;
import com.Automation_project.PageObjects.PaginationWebTable;

public class FormFillupTest001 extends BaseClass{
	
	
	@Test(priority=1,dataProvider="TestData",dataProviderClass=com.Automation_project.AutomationUtilities.TestData.class)
	public void FillPersonalTest(String Name,String Email,String Phone,String Address,String Gender,String Days, String Country, String Colors,String Animals) throws InterruptedException
	{
		
		
		
		//System.out.println(driver.toString());
		
	    log.info("starting FillFormTest test");
	    //DemocartPageLayout dp=new DemocartPageLayout(driver);
	    FormPage f=new FormPage(driver);
		//dp.ClickMarketingAffliate();
		f.EnterName(Name);
		f.EnterEmail(Email);
		f.EnterPhone(Phone);
		f.EnterAddress(Address);
		f.ClickGender(Gender);
		f.ClickDays(Days);
		f.SelectCountry(Country);
		f.SelectColors(Colors);
		f.SelectAnimals(Animals);

		
	}
	
	@Test(priority=2,dataProvider="TestData",dataProviderClass=com.Automation_project.AutomationUtilities.TestData.class)
	public void FillDates(String Date,String Month,String Year) throws InterruptedException
	{
		
		
		
		System.out.println(driver.toString());
		
	    log.info("starting FillDates test");
	    //DemocartPageLayout dp=new DemocartPageLayout(driver);
	    FormPage f=new FormPage(driver);
		//dp.ClickMarketingAffliate();
		f.fillDates(Date, Month, Year);
		
	}
	
	
	

}
