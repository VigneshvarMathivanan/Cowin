package com.cowin.cowin;

import java.io.IOException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Covid {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91769\\eclipse-workspace\\cowin\\Driver\\chromedriver.exe");
	       WebDriver driver = new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.get("https://www.cowin.gov.in/");
	       WebElement state=driver.findElement(By.xpath("//mat-select[@formcontrolname='state_id']"));
	       JavascriptExecutor js = (JavascriptExecutor)driver;
	       js.executeScript("arguments[0].scrollIntoView();", state);
	       Thread.sleep(3000);
	       js.executeScript("arguments[0].click();", state);
	       List<WebElement>list1=driver.findElements(By.xpath("//div[@aria-multiselectable='false']/child::mat-option[@tabindex='0']/child::span[@class='mat-option-text']"));
	       String excpectedState= Xlsx_reader.particularData("Sheet1", 8, 0);
	       for (WebElement states : list1) {
	    	   if(states.getText().trim().equals(excpectedState)) {
	    	       js.executeScript("arguments[0].click();", states);
	    	   }
	       }
    	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	    	   WebElement selectDistrict = driver.findElement(By.xpath("//span[contains(text(),'Select District')]"));
	  		   wait.until(ExpectedConditions.elementToBeClickable(selectDistrict)); 
	    	   js.executeScript("arguments[0].click();", selectDistrict);
	    	   List<WebElement> allDistricts = driver.findElements(By.xpath("//span[@class='mat-option-text']"));
	    	   ArrayList<String> dt = new ArrayList<String>();
	    	   String city = Xlsx_reader.particularData("Sheet1", 8, 1);
	    	   for (WebElement district : allDistricts) {
	    		  dt.add(district.getText());
      			if(dt.contains(city)) {
					js.executeScript("arguments[0].click();", district);
					break;
			}
	    	   }
	    	   String age=Xlsx_reader.particularData("Sheet1", 9, 0);
	    	   String dose=Xlsx_reader.particularData("Sheet1", 9, 1);
	    	   String payment=Xlsx_reader.particularData("Sheet1", 9, 2);
	    	   String vaccineName=Xlsx_reader.particularData("Sheet1", 9, 3);
	    	   
	    	   WebElement search=driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
	    	   js.executeScript("arguments[0].click();",search);
	    	   List<WebElement> alldata= driver.findElements(By.xpath("//label[@tabindex='0']"));
	    	   wait.until(ExpectedConditions.visibilityOfAllElements(alldata));
	    	  
	    	   for (WebElement data : alldata) {
				if(data.getText().equals(age)) {
					js.executeScript("arguments[0].click();", data);
				}
				if(data.getText().equals(dose)) {
					js.executeScript("arguments[0].click();", data);
				}
				if(data.getText().equals(payment)) {
					js.executeScript("arguments[0].click();", data);
				}
				if(data.getText().equals(vaccineName)) {
					js.executeScript("arguments[0].click();", data);
				}
			}
	    	   
	    	   String doseVerification=Xlsx_reader.particularData("Sheet1", 10, 1);
	    	   String vaccineVerification=Xlsx_reader.particularData("Sheet1", 10, 3);
	    	   
	    	   List<WebElement> validation = driver.findElements(By.xpath("//ul/li/span[2][@tabindex='0']"));
	    	   System.out.println("VERIFICATION OF DATAS ENTERED: ");
	    	   for (WebElement checkData : validation) {
	    		   if(checkData.getText().equals(age)) {
	    			   System.out.println("verified that the age is 18+");
	    		   }
	    		   if(checkData.getText().equals(doseVerification)) {
	    			   System.out.println("verified that the dose in Dose 2");
	    		   }
	    		   if(checkData.getText().equals(payment)) {
	    			   System.out.println("verified that the filtered hospitals are Paid not free");
	    		   }
	    		   if(checkData.getText().equals(vaccineVerification)) {
	    			   System.out.println("verified that the vaccine is Covishield");
	    		   }
	    		   
				
			}
	    	   List<WebElement> allHospitals = driver.findElements(By.xpath("//h5[@class='center-name-title accessibility-plugin-ac']"));
	    	   System.out.println("THE CENTERS ACCORDING TO REQUIRED CONDITIONS: ");
	    	   for (WebElement hospital : allHospitals) {
				if(hospital.isDisplayed()) {
					System.out.println(hospital.getText());
				}
			}
	    	   
		
	       
	       
	   

	}
}
