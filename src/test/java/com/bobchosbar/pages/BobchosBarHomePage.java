package com.bobchosbar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BobchosBarHomePage {
	
	public WebDriver driver;
	String homePageText;
	
	@FindBy(xpath="//div[@class='jumbotron']/h1") 
	WebElement homePage;
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-lg']") 
	WebElement purchaseLink;
	
	public BobchosBarHomePage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	public void verifyHomePageText() {
		if(homePage.isDisplayed()) {
			homePageText = homePage.getText();
		}
		System.out.println("User is on Home page");
		Assert.assertEquals(homePageText, "Bobcho\'s Bar");
	}
	
	public void clickPurchaseLink() {
		if(purchaseLink.isDisplayed())
			purchaseLink.click();
		System.out.println("Clicked on Purchase link");
	}
}
