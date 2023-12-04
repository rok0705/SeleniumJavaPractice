import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment {

	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
				
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("learning");
		
		driver.findElement(By.xpath("//input[@value='user']/following-sibling::span")).click();
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select")));
		WebElement dropdown = driver.findElement(By.cssSelector("select"));
		Select s = new Select(dropdown);
		s.selectByVisibleText("Consultant");
		
		driver.findElement(By.cssSelector("input[id='terms']")).click();
		
		driver.findElement(By.cssSelector("input[id='signInBtn']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'ProtoCommerce Home')]")));
		
		List<WebElement> buttons = driver.findElements(By.cssSelector("button[class='btn btn-info']"));
		
		for(int i=0; i<buttons.size(); i++) {
			buttons.get(i).click();
		}
		
		driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();
	}
}
