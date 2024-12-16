package com.Automation_project.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation_project.AutomationUtilities.ActionControls;
import com.Automation_project.AutomationUtilities.AutomationControls;
import com.Automation_project.AutomationUtilities.JSEControls;

public class DemocartPageLayout {
	
	private  WebDriver ldriver;
	private AutomationControls ac;
	private JSEControls jse;
	private ActionControls act;
	
	public DemocartPageLayout( WebDriver rdriver) {
		
		ldriver=rdriver;
		System.out.println("rdriver"+rdriver.toString());
		System.out.println("rdriver"+ldriver.toString());
		ac=new AutomationControls(ldriver);
//		jse=new JSEControls(ldriver);
//		act=new ActionControls(ldriver);
		PageFactory.initElements(rdriver, this);
		
		
	}



    @FindBy(xpath=".//span[contains(text(),'Logout')]") @CacheLookup  WebElement logout;
    @FindBy(xpath=".//ul[@id='menu']//*[text()=' Marketing']") @CacheLookup WebElement marketing;
    @FindBy(xpath=".//li[@id='menu-marketing']//*[text()='Affiliate']") @CacheLookup  WebElement affiliate;
    
    //Marketing menu click
	public void ClickMarketingAffliate() throws InterruptedException {
		
		
		ac.Click(marketing, 15);
		ac.Click(affiliate, 5);
		Thread.sleep(5000);
		
	}
	
	

	public void clickLogout() throws InterruptedException {
		ac.Click(logout, 5);
	
		
		Thread.sleep(5000);
		
		
	}

}
