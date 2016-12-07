package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

	AppiumDriver<MobileElement> driver;

	@BeforeSuite
	public void setUpAppium() throws MalformedURLException {

		final String URL_STRING = "http://127.0.0.1:4723/wd/hub";

		URL url = new URL(URL_STRING);

		DesiredCapabilities capabilities = new DesiredCapabilities();
		driver = new AndroidDriver<MobileElement>(url, capabilities);

		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void tearDownAppium() {
		driver.quit();
	}

	public void setText(By by, String text) {
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys(text);
		driver.hideKeyboard();
	}

	public boolean takeScreenshot(final String name) {
		String screenshotDirectory = System.getProperty("appium.screenshots.dir",
				System.getProperty("java.io.tmpdir", ""));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
	}
}
