package com.Automation_project.AutomationUtilities;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.poifs.property.DirectoryProperty.PropertyComparator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.Automation_project.Utilities.ReadConfig;
import java.util.Collections;
import java.io.File;
import java.io.IOException;
import java.util.*;


//import io.opentelemetry.api.logs.Logger;

public class BaseClass {
       ReadConfig config=new ReadConfig("./Configuration/Config.properties");
       private String baseurl=config.getBaseURL();
  	
       public static WebDriver driver;
      
       //DriverControls dc=new DriverControls(driver);
       public  Logger log;
       @Parameters({"browser"})
       @BeforeClass
       public void setup(String br) {
    	   System.out.println("inside before class annotation");
    	   
    	   log=LogManager.getLogger(this.getClass());
    	  
    	   
    	   switch(br) {
    	   
    	   case "chrome":
    		   System.setProperty("webdriver.chrome.driver", config.getChromePath());
    		  
    		   driver=new ChromeDriver();
    		   System.out.println(driver.toString());
    		   log.info("chrome driver started");
    		   break;
    	   case "firefox":
    		   System.setProperty("webdriver.firefox.driver", config.getFirefoxPath());
    		   driver=new FirefoxDriver();
    		   log.info("firefox driver started");
    		   break;
    		   
    	   
    	   }
    	   //DriverControls dc=new DriverControls(driver);
    	   //dc.getURL(baseurl);
    	   
    	   driver.get(baseurl);
    	   driver.manage().window().maximize();
    	   //dc.windowMaximize();
    	   
    	   
       }
       @AfterClass
       public void tearDown() {
    	   //dc.quit();
    	   System.out.println("inside after class annotation");
    	   driver.quit();
       }
       
       
   	public String CaptureScreen(String tname) throws IOException {
   		System.out.println(tname);
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+config.getScreenShotPath()+tname+".png";
		
		File target=new File(targetFilePath);
		FileUtils.copyFile(source, target);
		System.out.println("Screenshots taken");
		return targetFilePath;
		
		
	}

       
       
       
       
       
       
       
       
       
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               