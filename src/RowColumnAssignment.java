import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RowColumnAssignment {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		int numOfRows = driver.findElements(By.cssSelector(".left-align tr")).size();
		int numOfColumns = driver.findElements(By.cssSelector(".left-align tr:nth-child(2) td")).size();
		
		System.out.println("numOfRows: " + numOfRows);
		System.out.println("numOfColumns: " + numOfColumns);
		
		List<WebElement> secondRowElements = driver.findElements(By.cssSelector(".left-align tr:nth-child(3) td"));
		for(int i=0; i<secondRowElements.size(); i++) {
			System.out.println(secondRowElements.get(i).getText());
		}
	}

}
