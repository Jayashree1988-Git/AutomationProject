package com.Automation_project.PageObjects;

import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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

public class FormPage {
	
	private  WebDriver ldriver;
	private AutomationControls ac;
	private JSEControls jse;
	private ActionControls act;
	private DriverControls dc;
	
	public FormPage( WebDriver rdriver) {
		
		ldriver=rdriver;
		System.out.println("rdriver"+rdriver.toString());
		System.out.println("rdriver"+ldriver.toString());
		ac=new AutomationControls(ldriver);
		jse=new JSEControls(ldriver);
		act=new ActionControls(ldriver);
		dc=new DriverControls(ldriver);
		PageFactory.initElements(rdriver, this);
		
		
	}
	
	@FindBy(xpath=".//input[@class='hasDatepicker']")
	@CacheLookup
	WebElement DatePicker;
	
	@FindBy(id="datepicker")
	@CacheLookup
	WebElement DatePickerText;
	
	
	@FindBy(xpath=".//span[@class='ui-datepicker-month']")
	@CacheLookup
	WebElement DatePickerMonth;
	
	@FindBy(xpath=".//span[@class='ui-datepicker-year']")
	@CacheLookup
	WebElement DatePickerYear;
	
	@FindBy(xpath=".//a[contains(@class,'prev ui') and @title='Prev']")
	@CacheLookup
	WebElement PrevLink;
	
	
	@FindBy(xpath=".//a[contains(@class,'next ui') and @title='Next']")
	@CacheLookup
	WebElement NextLink;
	
	
	
	@FindBy(xpath=".//select[@id='country']")
	@CacheLookup
	WebElement country;
	

	@FindBy(xpath=".//select[@id='colors']")
	@CacheLookup
	WebElement colors;
	

	@FindBy(xpath=".//select[@id='animals']")
	@CacheLookup
	WebElement animals;
	
	@FindBy(xpath=".//input[@placeholder='Enter Name']")
	@CacheLookup
	WebElement txtName;
	
	@FindBy(xpath=".//input[@placeholder='Enter EMail']")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath=".//input[@placeholder='Enter Phone']")
	@CacheLookup
	WebElement txtEnterPhone;
	
	@FindBy(xpath=".//div[@class='form-group']/child::label[text()='Address:']/following-sibling::textarea")
	@CacheLookup
	WebElement txtEnterAddress;
	@FindBy(xpath=".//input[@id='female' and @type='radio']")
	@CacheLookup
	WebElement radioFemale;
	
	
	@FindBy(xpath=".//input[@id='male' and @type='radio']")
	@CacheLookup
	WebElement radiomale;
	

	
	
	@FindBy(xpath=".//input[@id='sunday' and @type='checkbox']")
	@CacheLookup
	WebElement CheckSunday;
	
	
	@FindBy(xpath=".//input[@id='friday' and @type='checkbox']")
	@CacheLookup
	WebElement CheckFriday;
	
	
	
	@FindBy(xpath=".//a[text()='Home']")
	@CacheLookup
	WebElement clickHome;
	
	
	public void EnterName(String name) {
		if(txtName!=null) {
			ac.Clear(txtName, 2);
		}
		
		ac.SendKeys(txtName, name,5);
		
	}
	
	public void EnterEmail(String Email) throws InterruptedException {
		if(txtEmail!=null) {
			ac.Clear(txtEmail, 2);
		}
		
		ac.SendKeys(txtEmail, Email,5);
		
		

		
		
	}
	
	public void EnterPhone(String Phone) throws InterruptedException {
		if(txtEnterPhone!=null) {
			ac.Clear(txtEnterPhone, 2);
		}
		
		ac.SendKeys(txtEnterPhone, Phone,5);
		
		

		
		
	}
	public void ClickGender(String Gender) throws InterruptedException {
		if(Gender.equals("Female")) {
			ac.Click(radioFemale, 5);
		}
		
		if(Gender.equals("Male")) {
			ac.Click(radiomale, 5);
		}
		
		

		
		
	}
	
	public void ClickDays(String Days) throws InterruptedException {
		if(Days.equals("Sunday")) {
			ac.Click(CheckSunday, 5);
		}
		
		if(Days.equals("Friday")) {
			ac.Click(CheckFriday, 5);
		}
		
		

		
		
	}
	

	public void SelectCountry(String Country) throws InterruptedException {
		List<WebElement> options=ac.DropDown(country, 5);
		int TotalOptions=options.size();
	    for(int i=0;i<TotalOptions;i++) {
	    	String selCountry=options.get(i).getText();
	    	if(selCountry.equalsIgnoreCase(Country)) {
	    		options.get(i).click();
	    		break;
	    	}
	    	


	    }
		
		

		
		
	}
	public void SelectColors(String Colours) throws InterruptedException {
		List<WebElement> options=ac.DropDown(colors, 5);
		int TotalOptions=options.size();
	    for(int i=0;i<TotalOptions;i++) {
	    	String selColours=options.get(i).getText();
	    	if(selColours.equalsIgnoreCase(Colours)) {
	    		options.get(i).click();
	    		break;
	    	}
	    	


	    }
		
		}
	public void SelectAnimals(String Animal) throws InterruptedException {
		List<WebElement> options=ac.DropDown(animals, 5);
		int TotalOptions=options.size();
	    for(int i=0;i<TotalOptions;i++) {
	    	String selanimal=options.get(i).getText();
	    	if(selanimal.equalsIgnoreCase(Animal)) {
	    		options.get(i).click();
	    		break;
	    	}
	    	


	    }
		
		}
	public void EnterAddress(String Address) throws InterruptedException {
		if(txtEnterAddress!=null) {
			ac.Clear(txtEnterAddress, 2);
		}
		
		ac.SendKeys(txtEnterAddress, Address,5);
		
		

		
		
	}
	
	public void fillDates(String Date,String Month,String Year) {
		ac.Click(DatePicker, 5);
		String currentyear=ac.getText(DatePickerYear, 5);
		String currentmonth=ac.getText(DatePickerMonth, 5);
		if(Integer.parseInt(Year)>Integer.parseInt(currentyear)) {
			FutureDate(Date,Month,Year,currentmonth,currentyear);
		}
		if(Integer.parseInt(Year)<Integer.parseInt(currentyear)) {
			PastDate(Date,Month,Year,currentmonth,currentyear);
		}
		if(Integer.parseInt(Year)==Integer.parseInt(currentyear)){
		    Integer CurrentmonthValue=convertMonth(currentmonth);
		    Integer ReqMonthValue=convertMonth(Month);
		
		    if(CurrentmonthValue>ReqMonthValue) {
			    PastDate(Date,Month,Year,currentmonth,currentyear);
		    }
		    if(CurrentmonthValue<ReqMonthValue) {
			    FutureDate(Date,Month,Year,currentmonth,currentyear);
		    }
		}
	}
	
   static Integer convertMonth(String Month) {
	   HashMap<String,Integer> monthMap=new HashMap<String, Integer>();
	   monthMap.put("January", 0);
	   monthMap.put("February", 1);
	   monthMap.put("March", 2);
	   monthMap.put("April", 3);
	   monthMap.put("May", 4);
	   monthMap.put("June", 5);
	   monthMap.put("July", 6);
	   monthMap.put("August", 7);
	   monthMap.put("September", 8);
	   monthMap.put("October", 9);
	   monthMap.put("November", 10);
	   monthMap.put("December", 11);
	   Integer result=monthMap.get(Month);
	   return result;
	  
	  
  }
	
   public void FutureDate(String Date,String Month,String Year,String currentmonth,String currentyear) {
	   By DateLocator=By.xpath("//table[@class='ui-datepicker-calendar']//a[contains(text(),"+Date+")]");
	   By NextLink=By.xpath(".//a[contains(@class,'next ui') and @title='Next']");
	   By currentmonLocator=By.xpath(".//span[@class='ui-datepicker-month']");
	   By currentYearLoctor=By.xpath(".//span[@class='ui-datepicker-year']");
	   
	   
	   while(true) {
		   if(currentmonth.equals(Month)&& currentyear.equals(Year)) {
			   break;
		   }
		   WebElement NextLinkEle=dc.FindElement(NextLink, 5);
		   ac.Click(NextLinkEle, 5);
		   WebElement currentmonthEle=dc.FindElement(currentmonLocator, 5);
		   currentmonth=ac.getText(currentmonthEle, 5);
		   WebElement currentYearEle=dc.FindElement(currentYearLoctor, 5);
		   currentyear=ac.getText(currentYearEle, 5);
		   
		   
		   
	   }
	   WebElement DateElement=dc.FindElement(DateLocator, 5);
	   ac.Click(DateElement, 5);
	   
   }
   
   public  void PastDate(String Date,String Month,String Year,String currentmonth,String currentyear) {
	   By DateLocator=By.xpath("//table[@class='ui-datepicker-calendar']//a[contains(text(),"+Date+")]");
       By PrevLink=By.xpath(".//a[contains(@class,'prev ui') and @title='Prev']");
       By currentmonLocator=By.xpath(".//span[@class='ui-datepicker-month']");
	   By currentYearLoctor=By.xpath(".//span[@class='ui-datepicker-year']");
	   
	   while(true) {
		   if(currentmonth.equals(Month)&& currentyear.equals(Year)) {
			   break;
		   }
		   WebElement PrevLinkEle=dc.FindElement(PrevLink, 5);
		   ac.Click(PrevLinkEle, 5);
		   WebElement currentmonthEle=dc.FindElement(currentmonLocator, 5);
		   currentmonth=ac.getText(currentmonthEle, 5);
		   WebElement currentYearEle=dc.FindElement(currentYearLoctor, 5);
		   currentyear=ac.getText(currentYearEle, 5);
		   
	   }
	   WebElement DateElement=dc.FindElement(DateLocator, 5);
	   ac.Click(DateElement, 5);
	   
   }
	
//	public void clickSubmit() throws InterruptedException {
//		try {
//		ac.Click(btnLogin, 10);
//		Thread.sleep(2000);
//		}
//		catch(StaleElementReferenceException e) {
//			By Loginlocator=By.xpath(".//button[@type='submit']");
//			WebElement btnclick=dc.FindElement(Loginlocator, 5);
//			
//			ac.Click(btnclick, 10);
//			Thread.sleep(5000);
//		}
////		ac.Click(btnLogin, 10);
//		
//		
//		
//	}

}
