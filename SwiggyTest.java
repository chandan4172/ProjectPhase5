package com.appium.testSwi;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SwiggyTest {
	static AndroidDriver<MobileElement> driver;
	MobileElement foundElem;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Create Driver Instance");
		URL url = new URL("http://localhost:4723/wd/hub");

		//Properties prop=new Properties();
	    //prop.load(new FileReader("config.properties"));
		//String strVersion=(String)prop.get("platformVersion");
		//String strPName = (String) prop.get("platformName");
        //String strPackage = (String) prop.get("appPackageDemo");
       // String strActivity = (String) prop.get("appActivityDemo");

		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","11");
		capabilities.setCapability("appPackage","in.swiggy.android");
		capabilities.setCapability( "appActivity","in.swiggy.android.activities.HomeActivity");

		//Android Driver 
				driver = new AndroidDriver<MobileElement>(url, capabilities);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				SessionId sessionId = driver.getSessionId();
				System.out.println(sessionId);
				Thread.sleep(1000);

				Thread.sleep(4000);  
				driver.findElement(By.xpath(" //android.widget.TextView[@text='EXPLORE SWIGGY']")).click();
				driver.findElement(By.xpath(" //android.widget.TextView[@text='SET DELIVERY LOCATION']")).click();
				Thread.sleep(3000);
			//	driver.findElement(By.xpath("//android.widget.TextView[@text='CONTINUE AS GUEST']")).click();
			//	Thread.sleep(3000);
				driver.findElement(By.xpath("//android.widget.Button[@text='Deny']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//android.widget.EditText[@text='Search for area, street name…']")).sendKeys("Hyderabad");
				Thread.sleep(2000);
				driver.findElement(By.xpath(" //android.widget.TextView[@text='CONFIRM LOCATION']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(" //android.widget.TextView[@text='Hyderabad']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//android.widget.TextView[@text='SELECT & PROCEED']")).click();
				Thread.sleep(2000);
				driver.hideKeyboard();
		  
					
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testSearchPizza() throws InterruptedException {
		Thread.sleep(3000);  
		driver.findElement(By.xpath("//android.widget.EditText")).click();
		Thread.sleep(1000); 
		MobileElement search = driver.findElement(By.xpath("//android.widget.EditText"));
		search.sendKeys("Domino's Pizza ");
		//search.click();
		driver.hideKeyboard();
		Thread.sleep(1000);
		clickView("Pizza");
		Thread.sleep(1000); 
	}

	private void clickView(String string) {
		// TODO Auto-generated method stub
		
	}
		
	

}
