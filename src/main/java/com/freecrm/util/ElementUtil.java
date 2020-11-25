package com.freecrm.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured in locating webelement..." + locator);
		}
		return element;
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public String getText(By locator) {
		return getElement(locator).getText();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean isElementPresent(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	public void waitForElementToBeVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForElement(By locator, int timeOut) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static void clickByActions(WebDriver driver,By locator) {
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(locator)).click().perform();
		
	}
}
