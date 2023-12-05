import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class assignment2 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement checkBox = driver.findElement(By.id("checkBoxOption3"));
		checkBox.click();
		String checkBoxName = driver.findElement(By.xpath("//input[@id='checkBoxOption3']/parent::label")).getText();
		
		WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(dropDown);
		select.selectByVisibleText(checkBoxName);
		
		driver.findElement(By.id("name")).sendKeys(checkBoxName);
		
		driver.findElement(By.id("alertbtn")).click();
		
		String alertSentence = driver.switchTo().alert().getText();
		
		if(alertSentence.contains(checkBoxName)) {
			System.out.println("alert: pass.");
		} else {
			System.out.println("alert: fail.");
		}
		
		driver.switchTo().alert().accept();
	}

}
