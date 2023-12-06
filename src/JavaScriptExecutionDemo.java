import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutionDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		List<WebElement> amounts = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)")); 

		int sum=0;
		for(int i=0; i<amounts.size(); i++) {
			sum+=Integer.parseInt(amounts.get(i).getText());
		}
		System.out.println("sum: " + sum);
		
		int expectedAmount = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		System.out.println("expected amount: " + expectedAmount);
		
		Assert.assertEquals(sum, expectedAmount);
	}

}
