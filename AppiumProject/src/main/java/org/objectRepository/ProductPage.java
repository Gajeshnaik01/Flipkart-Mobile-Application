package org.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.universalUtility.ThreadSafeClass;

import io.appium.java_client.android.AndroidDriver;

public class ProductPage {
	public ProductPage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.TextView[contains(@text,'pampa BLUEDART')]")
	private WebElement clickOnProduct1 ;

	@FindBy(xpath="//android.widget.TextView[@text='Add to cart']")
	private WebElement addToCart ;
	
	
	@FindBy(id="com.flipkart.android:id/cart_count")
	private WebElement addToCartbtn ;

	
	private String clickOnProduct="//android.widget.TextView[@text='%s']";
	
	private WebElement convertDynamicXathToElement(String partialXpath, String replaceData ) {
		String xpath = String.format(partialXpath, replaceData);
		return ThreadSafeClass.getDriver().findElement(By.xpath(xpath));
	}
	
	public void clickOnProduct(String replaceData) {
		 convertDynamicXathToElement(clickOnProduct,replaceData).click();
	}
	
	public WebElement ClickOnProduct() {
		return clickOnProduct1;
	}
	
	public void clickAddToCart() {
		 addToCart.click();
	}
	public void clickAddToCartbtn() {
		 addToCartbtn.click();
	}
	
	
	
	
	
}
