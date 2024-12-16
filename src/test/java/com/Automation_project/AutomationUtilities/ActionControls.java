package com.Automation_project.AutomationUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionControls {
	private Actions act;

	public ActionControls(WebDriver dr) {
		act=new Actions(dr);
		
	}
	public void ContextClick(WebElement we) {
		act.contextClick(we).build().perform();
	}
	
	//movetoelement,release,
	//slider,resizable
	public void MoveToElement(WebElement we) {
		act.moveToElement(we).build().perform();
	}
	public void MouseOverandClick(WebElement we) {
		act.moveToElement(we).click().build().perform();
	}
	public void DragAndDrop(WebElement source,WebElement target) {
		act.dragAndDrop(source, target).build().perform();
	
	}
	public void DoubleClick(WebElement we) {
		act.doubleClick(we).build().perform();
	}
	
	public void Slider(WebElement we,int SourceValue,int TargetValue) {
		act.moveToElement(we).dragAndDropBy(we, SourceValue, TargetValue).build().perform();
	}
	public void Resizable(WebElement we,int SourceValue,int TargetValue) throws InterruptedException {
		act.moveToElement(we).dragAndDropBy(we, SourceValue, TargetValue).build().perform();
		Thread.sleep(3000);
	}
}
