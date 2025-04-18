package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testBase.TestBase;

public class CaseList extends TestBase {

	@FindBy(xpath = "//input[@id='mat-input-2']")
	public WebElement clickOnEmailText;

	@FindBy(xpath = "//input[@id='mat-input-2']")
	public WebElement email;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement continueButton;

	@FindBy(xpath = "//input[@id='mat-input-3']")
	public WebElement clickOnPasswordText;

	@FindBy(xpath = "//input[@id='mat-input-3']")
	public WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginButton;
	
	@FindBy(id = "mat-select-0")
	public WebElement selectItermPerpage;

	@FindBy(xpath = "//mat-option[@id='mat-option-3']")
	public WebElement select100;

	@FindBy(xpath = "//*[@aria-label='Next page'][@disabled='true']")
	public WebElement nextButtonDisabled;

	@FindBy(css = "//button[@aria-label='Next page']")
	public WebElement nextButton;

	@FindBy(xpath = "//*[@class='mat-mdc-cell mdc-data-table__cell cdk-cell case-name column-width-400 cdk-column-name mat-column-name ng-star-inserted']")
	public List<WebElement> caseFile;

	public CaseList() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void doClickOnEmailTextBox() {
		
		clickOnEmailText.click();

	}
	
	public void enterEmail(String uname) {
		
		email.sendKeys(uname);
	}
	
	public void doClickContinueButton() {
		
		continueButton.click();
	}
	
	public void doClickOnPasswordTextBox() {
		
		clickOnPasswordText.click();
	}
	
	public void enterPassword(String pword) {
		
		password.sendKeys(pword);
		
	}
	
	public void doClickLoginButton() {
		
		loginButton.click();
		
	}


}