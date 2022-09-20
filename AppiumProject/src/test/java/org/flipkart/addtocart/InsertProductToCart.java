package org.flipkart.addtocart;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.tyss.universalUtility.BaseClass;
import org.tyss.universalUtility.IConstants;
import org.tyss.universalUtility.ListenerImpClass;
import org.tyss.universalUtility.ThreadSafeClass;
@Listeners(org.tyss.universalUtility.ListenerImpClass.class)
public class InsertProductToCart extends BaseClass {

	@Test(retryAnalyzer = org.tyss.universalUtility.RetryImpClass.class)
	public void insertProductToCart() {
		
		homePage.clickSearchBtn();
		String catgory=excelUtility.getDataFromExcelSheet(IConstants.sheetName, 2, 1);
		homePage.sendSearchTxtBox(catgory);
		ThreadSafeClass.getMobileUtility().waittillElement(2000);
		ThreadSafeClass.getMobileUtility().tapAction(1, 500, 300, 500);
		String product=homePage.getProduct();
		excelUtility.setDataToExcel("FLIPKART", 2, 2, product);
		excelUtility.saveWrittenDataToExcel(IConstants.EXCELFILEPATH);
		ListenerImpClass.testLog.info("Data is added to excel");
		String expectedProduct=excelUtility.getDataFromExcelSheet(IConstants.sheetName, 2, 2);
		productPage.clickOnProduct(expectedProduct);
		productPage.clickAddToCart();
		ListenerImpClass.testLog.info(expectedProduct+" is added to cart");
		ThreadSafeClass.getMobileUtility().waittillElement(2000);
		ThreadSafeClass.getMobileUtility().swipeAction(500, 550, 500, 1000, 500);
		productPage.clickAddToCartbtn();
		ListenerImpClass.testLog.info("clicked on add to cart");
		String actualProduct =addToCartPage.getProductName(expectedProduct);
		Assert.assertTrue(actualProduct.contains(expectedProduct));
		ThreadSafeClass.getJavaUtility().printStatement("Test Case Passed");
		ListenerImpClass.testLog.info("Test Case Passed");
	
	}
	
}
