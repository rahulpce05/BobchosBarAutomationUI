package com.bobchosbar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ConfirmationPage {

	public WebDriver driver;
	static String orderConfirmationPageText, nameInConfirmationPage, emailInConfirmationPage;
	static double sizeInConfirmationPage, priceInConfirmationPage, priceCalculated;
	static int quantityInConfirmationPage;


	@FindBy(xpath = "//h1[text()='Order confirmation']")
	WebElement orderConfirmationPage;
	@FindBy(xpath = "//span[@id='Size']")
	WebElement size;
	@FindBy(xpath = "//span[@id='Price']")
	WebElement price;
	@FindBy(xpath = "//span[@id='Qty']")
	WebElement quantity;
	@FindBy(xpath = "//span[@id='Name']")
	WebElement name;
	@FindBy(xpath = "//span[@id='Email']")
	WebElement email;

	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}

	public void verifyOrderConfirmationPageText() {
		if (orderConfirmationPage.isDisplayed())
			orderConfirmationPageText = orderConfirmationPage.getText();
		System.out.println("User is on Order Confirmation Page");
		Assert.assertEquals(orderConfirmationPageText, "Order confirmation");
	}

	public void verifySize() {
		if (size.isDisplayed())
			sizeInConfirmationPage = Double.parseDouble(size.getText().substring(0,4));
		System.out.println("sizeInConfirmationPage: " +sizeInConfirmationPage);
	}

	public void verifyQuantity(int enteredQuantity) {
		if (quantity.isDisplayed())
			quantityInConfirmationPage = Integer.parseInt(quantity.getText());
		Assert.assertEquals(quantityInConfirmationPage, enteredQuantity);
		System.out.println("quantityInConfirmationPage: " +quantityInConfirmationPage);
	}

	public void verifyPrice(double priceDisplayed, int quantity) {
		if (price.isDisplayed())
			priceInConfirmationPage = Double.parseDouble(price.getText());
			priceCalculated = priceDisplayed * quantity;
		System.out.println("priceInConfirmationPage: " +priceInConfirmationPage);
		Assert.assertEquals(priceInConfirmationPage, priceCalculated);
	}

	public void verifyName(String enteredName) {
		if (name.isDisplayed())
			nameInConfirmationPage = name.getText();
		System.out.println("nameInConfirmationPage: " +nameInConfirmationPage);
		Assert.assertEquals(nameInConfirmationPage, enteredName);
	}

	public void verifyEmail(String enteredEmail) {
		if (email.isDisplayed())
			emailInConfirmationPage = email.getText();
		System.out.println("emailInConfirmationPage: " + emailInConfirmationPage);
		Assert.assertEquals(emailInConfirmationPage, enteredEmail);
	}

}
