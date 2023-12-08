import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Filter {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("input[id='search-field']")).sendKeys("pple");
		
		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
		rows.forEach(s->System.out.println(s.getText()));
		
		List<WebElement> filteredResults = rows.stream().filter(s->s.getText().contains("pple")).collect(Collectors.toList());
		
		filteredResults.forEach(s->System.out.println(s.getText()));

		Assert.assertEquals(rows.size(), filteredResults.size());
	}
}
