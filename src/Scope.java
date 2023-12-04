import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaclickacademy.com/practice.php");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footerDriver = driver.findElement(By.cssSelector("[id='gf-BIG']"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		WebElement firstColumnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(firstColumnDriver.findElements(By.tagName("a")).size());
		
		List<WebElement> links = firstColumnDriver.findElements(By.tagName("a"));
		for(int i=0; i<links.size(); i++) {
			String clickOnLinkTab = Keys.chord(Keys.COMMAND,Keys.ENTER);
			links.get(i).sendKeys(clickOnLinkTab);			
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> it = tabs.iterator();
		while(it.hasNext()) {
			String tabId = it.next();
			driver.switchTo().window(tabId);
			System.out.println(driver.getTitle());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
	}

}
