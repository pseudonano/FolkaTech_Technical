package com.tegpam.TghFolkaTechTechnicalAuto;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class TestRunner {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		WebElement result;
		try {
			driver = DriverSelector.getDriver("chrome");
			
			// Navigate to URL
			driver.get("https://lapor.folkatech.com/");
			
			/* Positive Test Case */
//			TC001Login.Login(driver,"admin@example.com","password");
//			Assert.assertEquals(driver.findElement(TC001Login.DASHBOARD_HEADER).getText(), "Dashboard");
//			TC001Login.Logout(driver);
//			
//			Thread.sleep(Duration.ofSeconds(3));
			
			/* Negative Test Case */
			result = TC001Login.Login(driver, "admin999@example.com", "password");
			if (result != null) {
			    String errorMessageText = result.getText();
			    Assert.assertEquals("Login Gagal! Akun tidak ada.", errorMessageText);
			}
			
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}

	}
		

	}

