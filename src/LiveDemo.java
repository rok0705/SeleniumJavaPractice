import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

		List<String> items = rows.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> sortedItems = items.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(items.equals(sortedItems));
				
		List<String> price;
		
		while(true) {
			rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s))
					.collect(Collectors.toList());
			if(price.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			} else {
				break;
			}
		}
		price.forEach(s->System.out.println(s));
	}

	private static String getPriceVeggie(WebElement s) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}
}
