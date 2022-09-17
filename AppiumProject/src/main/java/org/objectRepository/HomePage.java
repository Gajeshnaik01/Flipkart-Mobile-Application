package org.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class HomePage {

	public HomePage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//android.widget.TextView[@text='Brand Mall']/parent::android.view.ViewGroup/android.view.ViewGroup[@index='2']")
	private WebElement searchBtn1 ;
	
	@FindBy(xpath="//android.widget.TextView[@text='Search for products']")
	private WebElement searchBtn ;
	
	
	@FindBy(xpath="//android.widget.ImageView/following-sibling::android.widget.TextView")
	private WebElement product ;
	
	@FindBy(xpath="//android.widget.EditText")
	private WebElement searchTxtBox ;
	

	public void clickSearchBtn() {
		searchBtn1.click();
	}

	public void sendSearchTxtBox(String text) {
		 searchTxtBox.sendKeys(text);
	}

	public String getProduct() {
		return product.getAttribute("text");
	}
	
	
}





