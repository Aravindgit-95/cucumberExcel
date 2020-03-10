package org.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utility.BaseClass;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksClass extends BaseClass {

	
	public WebDriver driver =null;
	@Before

	public void beforeExecution() {

		driver = launch();
		driver.get("https://www.ikoala.com.au/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@After

	public void afterExecution() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("I:\\Aravinsami\\sami codes\\CucumberExcel\\target\\Scrnshot.png");

		FileUtils.copyFile(file, f);

	}

}
