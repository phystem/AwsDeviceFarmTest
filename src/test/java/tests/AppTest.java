package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AppTest extends BaseTest {

	@Test(dataProvider = "getData")
	public void enterData(String name, String age) {
		setText(By.id("nameField"), name);
		setText(By.id("ageField"), age);
		driver.findElement(By.id("loginButton")).click();
		
		String expected = "Hi " + name + "_" + age;
		String actual = driver.findElement(By.id("userLabel")).getText();
		takeScreenshot(expected);
		Assert.assertEquals(actual, expected, "The Label value shoud match");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];

		data[0][0] = "Rob";
		data[0][1] = "23";

		data[1][0] = "Jill";
		data[1][1] = "19";

		data[2][0] = "Jack";
		data[2][1] = "47";

		return data;
	}

}
