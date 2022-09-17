package org.tyss.universalUtility;

import io.appium.java_client.android.AndroidDriver;

public class ThreadSafeClass {
	
	private static ThreadLocal<AndroidDriver> driver=new ThreadLocal<AndroidDriver>();
	private static ThreadLocal<FileUtility> fileUtility=new ThreadLocal<FileUtility>();
	private static ThreadLocal<JavaUtility> javaUtility=new ThreadLocal<JavaUtility>();
	private static ThreadLocal<MobileUtility>mobileUtility=new ThreadLocal<MobileUtility>();
	
	
	public static AndroidDriver getDriver() {
		return driver.get();
	}
	public static  void setDriver(AndroidDriver anddriver) {
		driver.set(anddriver);
	}
	public static FileUtility getFileUtility() {
		return fileUtility.get();
	}
	public static void setFileUtility(FileUtility actfileUtility) {
		fileUtility.set(actfileUtility);
	}
	public static JavaUtility getJavaUtility() {
		return javaUtility.get();
	}
	public static void setJavaUtility( JavaUtility actjavaUtility) {
		javaUtility.set(actjavaUtility);
	}
	public static MobileUtility getMobileUtility() {
		return mobileUtility.get();
	}
	public static void setMobileUtility(MobileUtility actmobileUtiltiUtility) {
		mobileUtility.set(actmobileUtiltiUtility);
	}

}
