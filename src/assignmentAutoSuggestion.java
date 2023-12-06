import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class assignmentAutoSuggestion {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("autocomplete")).sendKeys("kor");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String target = "Korea, Republic of";
		List<WebElement> suggestions = driver.findElements(By.cssSelector("ul[id='ui-id-1'] li div"));
		for(int i=0; i<suggestions.size(); i++) {
			if(suggestions.get(i).getText().equalsIgnoreCase(target)) {
				suggestions.get(i).click();
			}
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String autoComplete = driver.findElement(By.id("autocomplete")).getAttribute("value");
		
		Assert.assertEquals(autoComplete, target);
	}

}
