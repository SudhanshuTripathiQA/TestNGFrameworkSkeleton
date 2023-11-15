package com.hrm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public Properties prop;
	public WebDriver driver = null;

	public TestBase() {
		prop = new Properties();
		File file = new File("./src/main/java/com/hrm/qa/config/config.properties");
		try {
			FileInputStream ip = new FileInputStream(file);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Properties file loaded");
	}

	// It will open the browser and launching the application
	public void intialization() {
		String browserName = prop.getProperty("browser");
		System.out.println("Browser name: " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("browserDriverPathForWindows"));
			driver = new ChromeDriver();
			System.out.println("Chrome browser opened sucessfully.");
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver", prop.getProperty("browserDriverPathForLinux"));
			driver = new FirefoxDriver();
			System.out.println("Firefox browser opened sucessfully.");
		} else {
			System.out.println("Please enter valid browser name");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("applicationUrl"));
		System.out.println("Application launched.");
	}

	public void closingBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
