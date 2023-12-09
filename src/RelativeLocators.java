import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement emailBox = driver.findElement(By.cssSelector("[name='email']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(emailBox)).getText());
		
		WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));		
		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
		
		WebElement sentence = driver.findElement(By.cssSelector("[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(sentence)).click();
		
		WebElement radio1 = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.cssSelector("label")).toRightOf(radio1)).getText());
	}

}
