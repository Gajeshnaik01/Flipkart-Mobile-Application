package org.tyss.universalUtility;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileUtility {
	AndroidDriver<WebElement>driver;
	DesiredCapabilities cap;
	URL url;
	WebDriverWait wait;
	/**
	 * This method is used to initialize the Android Driver
	 * @param url
	 * @param cap
	 * @return 
	 */
	public AndroidDriver<WebElement> initializeAndroidDriver(URL url, DesiredCapabilities cap) {
		driver=new AndroidDriver<WebElement>(url, cap);
		return driver;
	}
	/**
	 * This method is to set the desired capabilities
	 * @param platFormName
	 * @param platFormVersion
	 * @param deviceId
	 * @return 
	 */
	
	public DesiredCapabilities initializeDesiredCapabilities(String platFormName, String platFormVersion,String deviceId,String appPackageName,String appActivityName) {
		cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platFormName);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,platFormVersion);
		cap.setCapability(MobileCapabilityType.UDID, deviceId);
		cap.setCapability("appPackage", appPackageName);
		cap.setCapability("appActivity", appActivityName);
		cap.setCapability("noReset", true);
		return cap;
	}
//	/**
//	 * This method is to set the appPackage 
//	 * @param appPackageName
//	 */
//	public void setAppPackage(String appPackageName) {
//		cap.setCapability("appPackage", appPackageName);
//	}
//	/**
//	 * This method is used to set the appActivity
//	 * @param appActivityName
//	 */
//	public void setAppactivity(String appActivityName) {
//		cap.setCapability("appActivity", appActivityName);
//	}
	/**
	 * This method is to initialize the url
	 * @param urlAddress
	 * @return 
	 * @throws MalformedURLException
	 */
	public URL initializeUrl(String urlAddress) throws MalformedURLException {
		 url=new URL(urlAddress);
		 return url;
	}
	/**
	 * This method is used to perform tap action on the particular element
	 * @param fingers
	 * @param element
	 * @param duration
	 */
	public void tapAction(int fingers,WebElement element,int duration) {
		driver.tap(fingers, element, duration);
	}
	/**
	 * This method is used to perform tap action at a particular axis
	 * @param fingers
	 * @param x
	 */
	public void tapAction(int fingers,int x,int y,int duration )
	{
		driver.tap(fingers, x, y, duration);
	}
	/**
	 * This method is used to perform the swipe action
	 * @param startx
	 * @param starty
	 * @param endx
	 * @param endy
	 * @param duration
	 */
	public void swipeAction(int startx, int starty,int endx,int endy,int duration) {
		driver.swipe(startx, starty,endx,endy,duration);
	}
	/**
	 * This method is used to run the app in the background
	 * @param appPackage
	 * @param appActivity
	 */
	public void switchApp(String appPackage, String appActivity) {
		driver.startActivity(appPackage, appActivity);
	}
	/**
	 * This method is used to switch from native app to webApp
	 * @param appPackage
	 */
	public void switchAppFromNativeToWebApp(String appPackage) {
		driver.context("WEBVIEW_"+appPackage);
	}
	/**
	 * This method is used to switch from  webApp to native app
	 * @param appPackage
	 */
	public void switchAppFromWebToNAtive(String appPackage) {
		driver.context("NATIVEVIEW_"+appPackage);
	}
	/**
	 * This method is used to get the windows for switching
	 * @return 
	 */
	public Set<String> getWindows() {
		Set<String> windows = driver.getContextHandles();
		return windows;
	}
	/**
	 * This method is used to get the screen orientation
	 * @return 
	 */
	public ScreenOrientation getOreinatation() {
		ScreenOrientation orientation = driver.getOrientation();
		return orientation;
	}
	/**
	 * This method is used to set the screen orientation to landscape mode
	 */
	public void setOreinatationToLandscape() {
		driver.rotate(ScreenOrientation.LANDSCAPE);
	}
	/**
	 * This method is used to set the screen orientation to Potrait mode
	 */
	public void setOreinatationToPotrait() {
		driver.rotate(ScreenOrientation.PORTRAIT);
	}
	/**
	 * This method is used to get the connection status
	 * @return 
	 */
	public Connection getConnection() {
		Connection connection = driver.getConnection();
		return connection;
	}
	/**
	 * This method is used to turn on the wifi connection
	 */
	public void setWifiConnection() {
		driver.setConnection(Connection.WIFI);
	}
	/**
	 * This method is used to turn on the data connection
	 */
	public void setDataConnection() {
		driver.setConnection(Connection.DATA);
	}
	/**
	 * This method is used to turn on the device to Airoplane mode
	 */
	public void setAiroplanemodeConnection() {
		driver.setConnection(Connection.AIRPLANE);
	}
	/**
	 * This method is used to perform the drag and drop action
	 * @param elementSrc
	 * @param elementdest
	 */
	public void DragAndDropAction(WebElement elementSrc,WebElement elementdest) {
		TouchAction action=new TouchAction(driver);
		action.longPress(elementSrc).waitAction().moveTo(elementdest).release().perform();
	}
	/**
	 * This method is used to install the app
	 * @param appPath
	 */
	public void installApp(String appPath) {
		driver.installApp(appPath);
	}
	/**
	 * This method is used to unsinstall the app
	 * @param appPackage
	 */
	public void uninstallApp(String appPackage) {
		driver.removeApp(appPackage);
	}
	/**
	 * This method is used to launch the App
	 */
	public void launchApp()
	{
		driver.launchApp();
	}
	/**
	 * This method is used to perform the scroll action on the device
	 * @param an
	 * @param av
	 */
	public void scrollAction(String an,String av) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
	}
	/**
	 * This method is used to launch the webApplication on the mobile device
	 * @param url
	 */
	public void launchWebApp(String url) {
		driver.get(url);
	}
	/**
	 * This method is used to check the app is present in the device or not
	 * @param appPackage
	 * @return 
	 */
	public boolean toCheckTheAppIsInstalled(String appPackage) {
		boolean status = driver.isAppInstalled(appPackage);
		return status;
	}
	/**
	 * This method is used to check the device is locked or not
	 * @return 
	 */
	public boolean checkDeviceLocked() {
		boolean status = driver.isLocked();
		return status;
	}
	/**
	 * This method is used to close the app
	 */
	public void closeApp() {
		driver.closeApp();
		
	}
	/**
	 * This method is used to hide the keyboard
	 */
	public void hideKeyboard() {
		driver.hideKeyboard();
		
	}
	/**
	 * This method is used to give the implicit wait condition
	 * @param time
	 */
	public void implicitWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	/**
	 * This method is used to initialize the explicit wait
	 * @param timeout
	 */
	public void initializeExplicitWait(long timeout) {
		 wait=new WebDriverWait(driver, timeout);
	}
	/**
	 * This method is used to wait the page until presence of the Element is located
	 * @param element
	 */
	public void explicitWaitBypresenceOfElementLocated(By element)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(element));

	}
	/**
	 * This method is used to wait the page until the text is visible
	 * @param element
	 */
	public void explicitWaitByvisibilityOf(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
		

	}
	/**
	 * This method is used to wait the page until the the webelement is present
	 * @param element
	 */
	public void explicitWaitByInvisibilityOf(By locator)
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	/**
	 * This method is used to wait the page till the Element is clickable(Custom Wait)
	 */
	public void waitTillElementClickable(int totalDuration,WebElement element,int pollingTime)
	{
		int currentTime=0;
		while(currentTime<=totalDuration)
		{
			try 
			{
				element.click();
				break;
			}catch(Exception e)
			{
				try
				{
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1)
				{
					e1.printStackTrace();
				}
				currentTime++;
			}
		}
	}
	
	/**
	 * This method is to take the screenshot of the Entire webPage
	 * @param currentClass
	 * @param javaUtility
	 */
	public void takeScreenShot(Object currentClass,JavaUtility javaUtility) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./errorshots"+currentClass.getClass().getSimpleName()+"_"+javaUtility.getCurrentDate("dd_MM_yyyy_HH_mm_sss")+".png");
		try 
		{
			FileUtils.copyFile(src, dest);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to take the screenshot of entirewebPage by Base64
	 * @param currentClass
	 * @param javaUtility
	 * @param element
	 * @return 
	 */
	public String TakesScreenShotInBase64()
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		String path=ts.getScreenshotAs(OutputType.BASE64);
		return path;
	}
	public void waittillElement(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
