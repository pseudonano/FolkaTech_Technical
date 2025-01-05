package com.tegpam.TghFolkaTechTechnicalAuto;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC001Login {
	
	public static final By EMAIL_FIELD = By.cssSelector("input[placeholder='Email']");
	public static final By PASSWORD_FIELD = By.cssSelector("input[id='password']");
	public static final By SIGNIN_BUTTON = By .cssSelector("button[type='submit']");
	public static final By DASHBOARD_HEADER = By.cssSelector("h3[class='mb-3']");
	public static final By PROFILE_MENU = By.cssSelector("div[class='d-flex align-items-center']");
	public static final By LOGOUT_BUTTON = By.cssSelector("a[href='https://lapor.folkatech.com/logout']");
	public static final By ERROR_MESSAGE = By.cssSelector("label[role='alert']");

	
	public static WebElement Login(WebDriver driver, String email, String password) {
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(EMAIL_FIELD)).sendKeys(email);
            wait.until(ExpectedConditions.elementToBeClickable(PASSWORD_FIELD)).sendKeys(password);
            wait.until(ExpectedConditions.elementToBeClickable(SIGNIN_BUTTON)).click();

            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_HEADER));
            } catch (Exception e) {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
            }

        } catch (NoSuchElementException e) {
            System.err.println("Element not found: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("An unexpected error occurred during login: " + e.getMessage());
            return null;
        }
    }

	
	public static void Logout(WebDriver driver) {
		driver.findElement(PROFILE_MENU).click();
		driver.findElement(LOGOUT_BUTTON).click();
		try {
			Thread.sleep(Duration.ofSeconds(2));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
