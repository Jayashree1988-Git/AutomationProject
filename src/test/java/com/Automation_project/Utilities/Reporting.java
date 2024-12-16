package com.Automation_project.Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.Automation_project.AutomationUtilities.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting implements ITestListener {
  public ExtentSparkReporter spark;
   public ExtentReports extent;
   public static ExtentTest test;
   String repname;
   
   public void onStart(ITestContext testContext) {
	   System.out.println("inside reporing-start");
	   ReadConfig config=new ReadConfig("./Configuration/Config.properties");
	   String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	   repname="Test-report-"+timestamp+".html";
	   spark=new ExtentSparkReporter(config.getExtentReportsPath()+repname);
	   extent=new ExtentReports();
//	   spark.config().setDocumentTitle("Automation Test");
//	   spark.config().setReportName("Testing");
//	   spark.config().setTheme(Theme.DARK);
	   try {
		spark.loadJSONConfig(new File("./src/test/resources/ExtentReport.json"));
	   } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	   extent.attachReporter(spark);
	   extent.setSystemInfo("Environment", "QA");
	   String browser=testContext.getCurrentXmlTest().getParameter("browser");
	   extent.setSystemInfo("Browser", browser);
	
	   
	   
   }
   
   public void onTestSuccess(ITestResult tr) {
	   System.out.println("inside successs");
	   test=extent.createTest(tr.getClass().getName());
	   test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	   
	   
   }
   
   public void onTestFailure(ITestResult tr) {
	   System.out.println("inside failure report");
	   test=extent.createTest(tr.getClass().getName());
	   test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	   test.log(Status.INFO, tr.getThrowable().getMessage());
	   try {
		   String screenshotpath=new BaseClass().CaptureScreen(tr.getName());
		   System.out.println(screenshotpath);
		   test.addScreenCaptureFromPath(screenshotpath);
	   }
	   catch(IOException e) {
		   e.printStackTrace();
			   
	}
  }
   public void onSkipped(ITestResult tr) {
	   System.out.println("inside skipped report");
	   test=extent.createTest(tr.getClass().getName());
	   test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	   
	   
   }
   
   public void onFinish(ITestContext testContext) {
	   System.out.println("inside finish");
	   extent.flush();
//	   String pathOfExtentReport=System.getProperty("user.dir")+"\\Report\\"+repname;
//	   File ExtentReport=new File(pathOfExtentReport);
//	   try {
//		   Desktop.getDesktop().browse( ExtentReport.toURI());
//		   
//	   }catch(IOException e) {
//		   e.printStackTrace();
//	   }
   }
	   
   
}
   
   

