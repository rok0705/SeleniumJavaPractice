import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumIntroduction {
	
	
	public static void main(String[] args) {
		System.out.println("hello world");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();

		SeleniumIntroduction obj = new SeleniumIntroduction();
		String[] veggies = {"Brocolli", "Cucumber", "Carrot"};
		obj.addItems(driver, veggies);
		obj.checkOut(driver);
		
		
	}
	
	private void addItems(WebDriver driver, String[] veggies) {

		List<WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));
		for (int i=0; i<products.size(); i++) {

			List<String> veggiesList = Arrays.asList(veggies);
			
			String product = products.get(i).getText().split("-")[0].trim();
			
			if(veggiesList.contains(product)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			}
		}
		
	}
	
	private void checkOut(WebDriver driver) {
		driver.findElement(By.cssSelector("a[class='cart-icon']")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='promoCode']")));
		
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));
		System.out.println(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText());
	}

}
