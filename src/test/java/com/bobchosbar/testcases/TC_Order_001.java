package com.bobchosbar.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import com.bobchosbar.base.BobchosBarBase;
import com.bobchosbar.pages.BobchosBarHomePage;
import com.bobchosbar.pages.ConfirmationPage;
import com.bobchosbar.pages.PurchasePage;
import com.bobchosbar.utility.Helper;

public class TC_Order_001 extends BobchosBarBase {
	
	String homePageText, purchasePageText, enteredEmail, enteredName;
	int enteredQuantity;
	double priceDisplayed;

	/*
	 * BobchosBarHomePage bobchosBarHomePage = new BobchosBarHomePage(driver);
	 * PurchasePage purchasePage = new PurchasePage(driver); ConfirmationPage
	 * confirmationPage = new ConfirmationPage(driver);
	 */
	@Test
	public void tc_order_001() throws InterruptedException {
		
		test = report.createTest("Place the order");
		BobchosBarHomePage bobchosBarHomePage = PageFactory.initElements(driver, BobchosBarHomePage.class);
		test.info("Launch the application");
		Helper.captureScreenshot(driver);
		bobchosBarHomePage.verifyHomePageText();
		Thread.sleep(2000);
		bobchosBarHomePage.clickPurchaseLink();
		Thread.sleep(2000);
		
		PurchasePage purchasePage = PageFactory.initElements(driver, PurchasePage.class);
		test.info("User is placing an order");
		purchasePage.verifyPurchasePageText();
		Thread.sleep(2000);
		purchasePage.selectSizeFromDropDown();
		Thread.sleep(2000);
		priceDisplayed = purchasePage.checkPrice();
		Thread.sleep(2000);
		enteredQuantity = purchasePage.enterQuantity((int) excel.getNumericData("ordersheet", 1, 0));
		Thread.sleep(2000);
		enteredName = purchasePage.enterName(excel.getStringData("ordersheet", 1, 1));
		Thread.sleep(2000);
		enteredEmail = purchasePage.enterEmail(excel.getStringData("ordersheet", 1, 2));
		Thread.sleep(2000);
		purchasePage.selectCheckboxForSelfDeclearation();
		Thread.sleep(2000);
		Helper.captureScreenshot(driver);
		purchasePage.clickOrderButton();
		Thread.sleep(2000);
		
		
		ConfirmationPage confirmationPage = PageFactory.initElements(driver, ConfirmationPage.class);
		test.info("User is verifying their order confirmation");
		confirmationPage.verifyOrderConfirmationPageText();
		Thread.sleep(2000);
		confirmationPage.verifySize();
		Thread.sleep(2000);
		confirmationPage.verifyQuantity(enteredQuantity);
		Thread.sleep(2000);
		confirmationPage.verifyPrice(priceDisplayed, enteredQuantity);
		Thread.sleep(2000);
		confirmationPage.verifyName(enteredName);
		Thread.sleep(2000);
		confirmationPage.verifyEmail(enteredEmail);
		Helper.captureScreenshot(driver);
		test.pass("Place order test successful");
	}
}
