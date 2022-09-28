package com.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CovidVaccineHospitals {
	
	
	public static WebDriver driver;
			
	@FindBy(xpath = "//mat-select[@formcontrolname='state_id']")
	private WebElement stateDB;
	
	@FindBy(xpath = "//div[@aria-multiselectable='false']/child::mat-option[@tabindex='0']/child::span[@class='mat-option-text']")
	private List<WebElement> allStates;
	
	@FindBy(xpath = "//span[contains(text(),'Select District')]")
	private WebElement districtDB;
	
	@FindBy(xpath = "//span[@class='mat-option-text']")
	private List<WebElement> allDistricts;
	
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//label[@tabindex='0']")
	private List<WebElement> allData;
	
	@FindBy(xpath = "//ul/li/span[2][@tabindex='0']")
	private List<WebElement> validation;
	
	@FindBy(xpath = "//h5[@class='center-name-title accessibility-plugin-ac']")
	private List<WebElement> allHospitals;
	
	
	
	public CovidVaccineHospitals(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getStateDB() {
		return stateDB;
	}

	public List<WebElement> getAllStates() {
		return allStates;
	}

	public WebElement getDistrictDB() {
		return districtDB;
	}

	public List<WebElement> getAllDistricts() {
		return allDistricts;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public List<WebElement> getAllData() {
		return allData;
	}

	public List<WebElement> getValidation() {
		return validation;
	}

	public List<WebElement> getAllHospitals() {
		return allHospitals;
	}
	
	
}
