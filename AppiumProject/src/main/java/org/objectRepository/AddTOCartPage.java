package org.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.tyss.universalUtility.ThreadSafeClass;

import io.appium.java_client.android.AndroidDriver;

public class AddTOCartPage {
	public AddTOCartPage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

	private String productTxt="//android.widget.TextView[contains(@text,'%s')]";

	//This method convert string to webelement
	private WebElement convertDynamicXathToElement(String partialXpath, String replaceData ) {
		String xpath = String.format(partialXpath, replaceData);
		return ThreadSafeClass.getDriver().findElement(By.xpath(xpath));
	}
	
	
	public String getProductName(String replaceData) {
		return convertDynamicXathToElement(productTxt,replaceData).getText();
	}

}
