package com.Automation_project.AutomationUtilities;


import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationControls {
	  
	
	public   WebDriver acdriver;
	private WebDriverWait wait;
	public AutomationControls(WebDriver driver){
		acdriver=driver;
		
	}
	
	public void SendKeys(WebElement we,String text,int seconds) {
		 wait=new WebDriverWait(acdriver,Duration.ofSeconds(seconds));
		 wait.until(ExpectedConditions.visibilityOf(we));
		 we.sendKeys(text);
	}
	
	public void SendKeys(Alert al,String text,int seconds) {
	    wait=new WebDriverWait(acdriver,Duration.ofSeconds(seconds));
	    wait.until(ExpectedConditions.alertIsPresent());
		al.sendKeys(text);
	}

	public void Click(WebElement we,int seconds) {
	    wait=new WebDriverWait(acdriver,Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(we));
		we.click();
	}
	public void Clear(WebElement we,int seconds) {
		WebDriverWait wait=new WebDriverWait(acdriver,Duration.ofSeconds(seconds));
	    wait.until(ExpectedConditions.elementToBeClickable(we));
		we.clear();
	}
	public List<WebElement> DropDown(WebElement we,int seconds) {
		List <WebElement> options;
		WebDriverWait wait=new WebDriverWait(acdriver,Duration.ofSeconds(seconds));
	    wait.until(ExpectedConditions.visibilityOf(we));
		Select se=new Select(we);
		options =se.getOptions();
				
		return options;
		
	}
	public String getText(WebElement we,int seconds) {
		WebDriverWait wait=new WebDriverWait(acdriver,Duration.ofSeconds(seconds));
	    wait.until(ExpectedConditions.visibilityOf(we));
		return we.getText();
	}
	public String getText(Alert al,int seconds) {
		WebDriverWait wait=new WebDriverWait(acdriver,Duration.ofSeconds(seconds));
	    wait.until(ExpectedConditions.alertIsPresent());
		return al.getText();
	}
	
	public void Accept(Alert al,int seconds) {
		WebDriverWait wait=new WebDriverWait(acdriver,Duration.ofSeconds(seconds));
	    wait.until(ExpectedConditions.alertIsPresent());
		al.accept();
	}
	
	public void Dismiss(Alert al,int seconds) {
		WebDriverWait wait=new WebDriverWait(acdriver,Duration.ofSeconds(seconds));
	    wait.until(ExpectedConditions.alertIsPresent());
		al.dismiss();
		
	}
	
	
	public boolean IsDisplayed(WebElement we) {
		return we.isDisplayed();
	}
	public boolean IsEnabled(WebElement we) {
		return we.isEnabled();
	}
	public boolean IsSelected(WebElement we) {
		return we.isSelected();
	}

}
