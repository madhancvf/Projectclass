package org.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.RefreshPage;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClasss {
	public static WebDriver driver;
public static WebDriver ChromeBrowser() {
	WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	return driver;
}

public static WebDriver launchBrowser(String browserName) {
if (browserName.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();			
}
else if (browserName.equalsIgnoreCase("edge")) {
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();			
}
else if (browserName.equalsIgnoreCase("firefox")) {
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
}
return driver;
}


public static WebDriver launchBrowser2(String browserName) {
switch (browserName) {
case "chrome":
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	break;
case "edge":
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
	break;
case "firefox":
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
default:
	System.out.println("invalid browser name");
}
return driver;
}
public static void urlLaunch(String url) {
driver.get(url);	
driver.manage().window().maximize();
}

public static void implicitWait(int a) {
	driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
}
public static void sendKeys(WebElement e,String value) {
	e.sendKeys(value);
}
public static void click(WebElement e) {
	e.click();
}
public static String getCurrentUrl() {
//	String currentUrl = driver.getCurrentUrl();
	//return currentUrl
			return driver.getCurrentUrl();
}
public static String getTitle() {
	return driver.getTitle();

}
public static String getText(WebElement e) {
	return e.getText();

}
public static String getAttribute(WebElement e) {
	//String attribute = e.getAttribute("value");
	//return attribute;
	return e.getAttribute("value");
	
}

public static void moveToElement(WebElement target) {
	Actions a=new Actions(driver);
	a.moveToElement(target).perform();
}
public static void dragAndDropt(WebElement source,WebElement Target) {
	Actions a=new Actions(driver);
	a.dragAndDrop(source, Target).perform();
}

public static void selectByIndex(WebElement a,int index) {
Select s=new Select(a);
s.selectByIndex(index);
}
public static void refresh() {
	driver.navigate().refresh();
}

}
