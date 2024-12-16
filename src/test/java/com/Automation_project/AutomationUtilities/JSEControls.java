package com.Automation_project.AutomationUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class JSEControls {
	private JavascriptExecutor js;
	
	public JSEControls(WebDriver driver) {
		js=((JavascriptExecutor)driver);
		
	}
	
	public void flash(WebElement we,int iterations) {
		String bgcolor=we.getCssValue("backgroundcolor");
		for(int i=0;i<iterations;i++) {
			js.executeScript("arguments[0].style.backgroundcolor='"+ bgcolor +"'", we);
			try {
				Thread.sleep(20);
				
			}catch(InterruptedException e) {
				
			}
		}
		
	}
	

	
	public void drawBorder(WebElement we) {
		    js.executeScript("arguments[0].style.border='3px solid red'", we);
		
		}
		
	public String getTitlebyJS() {
		String title=js.executeScript("return document.title;").toString();
		return title;
		
	}
	
	public void clickElementByJS(WebElement we) {
		js.executeScript("arguments[0].click();",we);
	
		
	}
	
	public void generateAlert(String message) {
		js.executeScript("alert('"+message+"')");
	
		
	}
	
	public void refreshBrowserbyJS() {
		js.executeScript("history.go(0)");
	}
	public void scrollIntoView(WebElement we) {
		js.executeScript("arguments[0].scrollIntoView(true);", we);
	}
	
	public void scrollPageDown() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public void scrollByPixel() {
		js.executeScript("window.scrollBy(0,1000)","");
	}
	}


