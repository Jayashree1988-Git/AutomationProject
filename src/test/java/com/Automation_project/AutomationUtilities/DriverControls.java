package com.Automation_project.AutomationUtilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverControls {

	
	private WebDriver driver;
	public DriverControls(WebDriver driver){
		this.driver=driver;
	}
	public void getURL(String URL) {
		driver.get(URL);
	}
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public void NavigateTo(String url) {
		driver.navigate().to(url);
	}
	
	public void NavigateBack() {
		driver.navigate().back();
	}
	public void NavigateForward() {
		driver.navigate().forward();
	}
	public void close() {
		driver.close();
	}
	public void quit() {
		driver.quit();
	}
	public void windowMaximize() {
		driver.manage().window().maximize();
	}
	
	public void PageRefresh() {
		driver.navigate().refresh();
	}
	
	public WebDriver SwitchFrame(WebElement we) {
		return driver.switchTo().frame(we);
	}
	public Alert SwitchAlert() {
		return driver.switchTo().alert();
		
	}
	public WebDriver SwitchWIndow(int idnum) {
		
	
		@SuppressWarnings("unchecked")
		List<String> ids=new ArrayList(driver.getWindowHandles());
		return driver.switchTo().window(ids.get(idnum));
		

		
	}
	
	public WebDriver SwitchNewWindow() {
		return driver.switchTo().newWindow(WindowType.WINDOW);
	}
	
	public WebDriver SwitchNewTab() {
		return driver.switchTo().newWindow(WindowType.TAB);
	}
	public WebElement FindElement(By Locator,int seconds) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(seconds));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	    WebElement we=driver.findElement(Locator);
		return we;
		
	}

	public List <WebElement> FindElements(By Locator,int seconds) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(seconds));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	    List <WebElement> we=driver.findElements(Locator);
		return we;
		
	}
}

	
