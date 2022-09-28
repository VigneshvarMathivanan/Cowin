package com.stepdefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cowin.cowin.BaseClass;
import com.cowin.cowin.Xlsx_reader;
import com.pom.CovidVaccineHospitals;
import com.property.ConfigurationHelper;
import com.runner.Runner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass{

	public static WebDriver driver = Runner.driver;
	CovidVaccineHospitals cv = new CovidVaccineHospitals(driver);
	public static JavascriptExecutor js= BaseClass.js;
	public static WebDriverWait wait = BaseClass.wait;
	public static String age;
	public static String payment;
	public static String sheetName;
	
	
	@Given("user Launch The Url")
	public void user_launch_the_url() throws IOException {
		String url= ConfigurationHelper.getInstance().getUrl();
		launchUrl(url);	
	}
	
	@When("user Click The Required State")
	public void user_click_the_required_state() throws InterruptedException, IOException {
		   WebElement state= cv.getStateDB();
		   javaScriptExecutor();
		   scrollAndClick(state, "view");
		   Thread.sleep(3000);
		   scrollAndClick(state, "click");
		   List<WebElement>list1= cv.getAllStates();
		   sheetName = ConfigurationHelper.getInstance().getSheetName();
	       String excpectedState= Xlsx_reader.particularData(sheetName, 8, 0);
	       for (WebElement states : list1) {
	    	   if(states.getText().trim().equals(excpectedState)) {
	    		   scrollAndClick(states, "click");
	    	   }
	       }
	}
	
	@When("user Click The Required District")
	public void user_click_the_required_district() throws IOException, InterruptedException {
	   Thread.sleep(3000);
 	   WebElement selectDistrict = cv.getDistrictDB();
 	   explicitWait(selectDistrict, "1");
 	   scrollAndClick(selectDistrict, "click");
 	   List<WebElement> allDistricts = cv.getAllDistricts();
 	   ArrayList<String> dt = new ArrayList<String>();
 	   String city = Xlsx_reader.particularData(sheetName, 8, 1);
 	   for (WebElement district : allDistricts) {
 		  dt.add(district.getText());
			if(dt.contains(city)) {
				scrollAndClick(district, "click");
				break;
		}
 	   }
 	  WebElement search= cv.getSearchBtn();
 	  scrollAndClick(search, "click");
	}
	
	@When("user Click The Required Age Dose Payment Vaccine")
	public void user_click_the_required_age_dose_payment_vaccine() throws IOException {
		 age=Xlsx_reader.particularData(sheetName, 9, 0);
 	   String dose=Xlsx_reader.particularData(sheetName, 9, 1);
 	    payment=Xlsx_reader.particularData(sheetName, 9, 2);
 	   String vaccineName=Xlsx_reader.particularData(sheetName, 9, 3);
 	   
 	   List<WebElement> alldata= cv.getAllData();
 	   waitAllElements(alldata);
 	   
 	   for (WebElement data : alldata) {
			if(data.getText().equals(age)) {
				scrollAndClick(data, "click");
			}
			if(data.getText().equals(dose)) {
				scrollAndClick(data, "click");
			}
			if(data.getText().equals(payment)) {
				scrollAndClick(data, "click");
			}
			if(data.getText().equals(vaccineName)) {
				scrollAndClick(data, "click");
			}
		}
	}
	
	@When("user Verify The Age Dose Payment Vaccine")
	public void user_verify_the_age_dose_payment_vaccine() throws IOException {
		String doseVerification=Xlsx_reader.particularData(sheetName, 10, 1);
 	   String vaccineVerification=Xlsx_reader.particularData(sheetName, 10, 3);
 	   
 	   List<WebElement> validation = cv.getValidation();
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
	}
	
	@Then("user Get The Hospital Names For Required Condiiton")
	public void user_get_the_hospital_names_for_required_condiiton() {
		 List<WebElement> allHospitals = cv.getAllHospitals();
  	   System.out.println("THE CENTERS ACCORDING TO REQUIRED CONDITIONS: ");
  	   for (WebElement hospital : allHospitals) {
			if(hospital.isDisplayed()) {
				getAlphabets(hospital);
			}
		}
  	   
	}



}
