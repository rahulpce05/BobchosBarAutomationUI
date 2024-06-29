package com.bobchosbar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PurchasePage {

	public WebDriver driver;
	static String purchasePageText;
	static double purchaseprice;
	static int quantity;
	
	@FindBy(xpath = "//div[@class='jumbotron']/h1")
	WebElement purchasePage;
	@FindBy(id = "Size")
	WebElement size;
	@FindBy(id = "Price")
	WebElement price;
	@FindBy(id = "Qty")
	WebElement qty;
	@FindBy(id = "Name")
	WebElement name;
	@FindBy(id = "Email")
	WebElement email;
	@FindBy(id = "IsAdult")
	WebElement checkbox;
	@FindBy(id = "btnOrder")
	WebElement orderBtn;

	public PurchasePage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	public void verifyPurchasePageText() {
		if (purchasePage.isDisplayed())
			purchasePageText = purchasePage.getText();
		System.out.println("User in on Purchase page");
		Assert.assertEquals(purchasePageText, "Place your order");
	}

	public void selectSizeFromDropDown() {
		Select select = new Select(size);
		select.selectByIndex(1);
		System.out.println("User selected size");
	}

	public double checkPrice() {
		if (price.isDisplayed())
			purchaseprice = Double.parseDouble(price.getAttribute("value"));
		System.out.println("purchaseprice: " +purchaseprice);
		return purchaseprice;
	}

	public int enterQuantity(int d) {
		qty.sendKeys(String.valueOf(d));
		System.out.println("User entered quantity: " +d);
		return d;
	}

	public String enterName(String enteredName) {
		name.sendKeys(enteredName);
		System.out.println("User entered name: " +enteredName);
		return enteredName;
	}

	public String enterEmail(String enteredEmail) {
		email.sendKeys("rahulpce05@gmail.com");
		System.out.println("User entered email: " +enteredEmail);
		return enteredEmail;
	}

	public void selectCheckboxForSelfDeclearation() {
		if (checkbox.isEnabled())
			checkbox.click();
		System.out.println("User selected checkbox");
	}

	public void clickOrderButton() {
		orderBtn.click();
		System.out.println("User clicked on order button");
	}
}
