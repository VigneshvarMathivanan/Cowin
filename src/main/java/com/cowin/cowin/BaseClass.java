package com.cowin.cowin;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;
	
	
	public static WebDriver launchBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else  if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize(); 
		}
		return driver;
		}
	public static void launchUrl(String url) {
		driver.get(url);
	}
	public static void closeBrowser() {
		driver.close();
	}
	public static void quitBrowser() {
		driver.quit();
	}
	public static void passInput(WebElement element,String input) {
		element.sendKeys(input);
	}
	public static void clickOnElement(WebElement element) {
		element.click();
		}
	public static void selectByValue(WebElement element,String value) {
		Select s = new Select(element);
		s.selectByValue(value);
		}
	public static void selectByIndex(  WebElement element,int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
		}
	public static void selectByVisibleText(WebElement element,String visibleText) {
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
	}
	public static void screenShot(String picName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\91769\\eclipse-workspace\\AirAsia\\Screenshots"+picName);
		FileUtils.copyFile(sourceFile, destFile);
		}
	public static void navigate(String url) {
		driver.navigate().to(url);
	}
	public static void navigateForward() {
		driver.navigate().forward();
	}
	public static void navigateBack() {
        driver.navigate().back();
	}
	public static void simpleAlert() {
		Alert a = driver.switchTo().alert();
		String b = a.getText();
		System.out.println("TEXT IN SIMPLE ALERT: "+b);
		a.accept();
	}
	public static void confirmAlert(String yesno) {
		if(yesno=="yes") {
			Alert a = driver.switchTo().alert();
			String b = a.getText();
			System.out.println("TEXT IN CONFIRM ALERT: "+b);
			a.accept();
			}else {
				Alert a = driver.switchTo().alert();
				String b = a.getText();
				System.out.println("TEXT IN CONFIRM ALERT: "+b);
				a.dismiss();
				}
	}
	public static void promptAlert(String yesno,String text) {
		if(yesno=="yes") {
			Alert a = driver.switchTo().alert();
			String b = a.getText();
			System.out.println("TEXT IN PROMPT ALERT: "+b);
			a.sendKeys(text);
			a.accept();
		}else {
			Alert a = driver.switchTo().alert();
			String b = a.getText();
			System.out.println("TEXT IN PROMPT ALERT: "+b);
			a.sendKeys(text);
			a.dismiss();
			}
	}
	public static void click(WebElement element) {
		Actions ac = (Actions)driver;
		ac.click(element).build().perform();
	}
	public static void rightClick(WebElement element) {
		Actions ac = (Actions)driver;
		ac.contextClick(element).build().perform();
	}
	public static void doubleClick(WebElement element) {
		Actions ac = (Actions)driver;
		ac.doubleClick(element).build().perform();
	}
	public static void moveToElement(WebElement element) {
		Actions ac = (Actions)driver;
		ac.moveToElement(element).build().perform();
	}
	public static void dragAndDrop(WebElement source,WebElement target) {
		Actions ac = (Actions)driver;
		ac.dragAndDrop(source, target).build().perform();
	}
	public static void displayed(WebElement element) {
        boolean a = element.isDisplayed();
        System.out.println(a);
	}
	public static void enabled(WebElement element) {
        boolean a = element.isEnabled();
        System.out.println(a);
	}
	public static void selected(WebElement element) {
        boolean a = element.isSelected();
        System.out.println(a);
	}
	public static void getAlphabets(WebElement element) {
        String text = element.getText();
        System.out.println(text);
	}
	public static void getAttr(WebElement element,String name) {
        String attribute = element.getAttribute(name);
        System.out.println(attribute);
	}
	public static void windowHandle(int tabno) {
        
		if(tabno==1 ) {
		System.out.println(driver.getWindowHandle());
	}else {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String a : windowHandles) {
			String b = a;
			System.out.println(b);
		}
		}
	}
	public static void frameByNameOrId(String nameid) {
         driver.switchTo().frame(nameid);
	}
	public static void frameByIndex(int index) {
        driver.switchTo().frame(index);
	}
	public static void frameByElement(WebElement element) {
        driver.switchTo().frame(element);
	}
	public static void backToMain() {
        driver.switchTo().defaultContent();
	}
	public static void currentUrl() {
       System.out.println(driver.getCurrentUrl());
	}
	public static void title() {
       System.out.println(driver.getTitle());
	}
	public static void multiple(WebElement element) {
       Select s = new Select(element);
       System.out.println(s.isMultiple());
	}
	public static void deselectByValue(WebElement element,String value) {
		Select s = new Select(element);
		s.deselectByValue(value);
		}
	public static void deselectByIndex(  WebElement element,int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
		}
	public static void deselectByVisibleText(WebElement element,String visibleText) {
		Select s = new Select(element);
		s.deselectByVisibleText(visibleText);
	}
	public static void allOptions(WebElement element) {
         Select s = new Select(element);
         List<WebElement> options = s.getOptions();
         for (WebElement a : options) {
        	 System.out.println(a.getText());
			}
	}
	public static void firstSelectedOption(WebElement element) {
         Select s = new Select(element);
         System.out.println(s.getFirstSelectedOption().getText());
	}
	public static void allSelectedOptions(WebElement element) {
        Select s = new Select(element);
        List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
        for (WebElement a : allSelectedOptions) {
       	 System.out.println(a.getText());
		}
	}
	public static void deselectAll(WebElement element) {
        Select s = new Select(element);
        s.deselectAll();
	}
	
	public static JavascriptExecutor javaScriptExecutor() {
		 js =(JavascriptExecutor)driver;
		return js;
	}
	
	public static void scrollAndClick(WebElement element,String fn) {
        
        if(fn.equalsIgnoreCase("view")) {
        js.executeScript("arguments[0].scrollIntoView();", element);
        }else if(fn.equalsIgnoreCase("click"))
        js.executeScript("arguments[0].click();",element);
}
	
	public static WebDriverWait explicitWait(WebElement element,String elementno) {
		if(elementno.equals("1")) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
		else {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		return wait;
	}
	
	public static void waitAllElements(List<WebElement> elements) {
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
