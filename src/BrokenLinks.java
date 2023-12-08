import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");		

		List<WebElement> elements = driver.findElements(By.xpath("//li/a"));
		
		String href = null;
		for(int i=0; i<elements.size(); i++) {
			String text = elements.get(i).getText();
			
			if(text.equals("Broken Link")) {
				href = elements.get(i).getAttribute("href");
//				System.out.println(href);
				break;
			}			
		}
		
		try {
			HttpURLConnection conn = (HttpURLConnection)new URL(href).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
//			System.out.println(responseCode);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SoftAssert softa = new SoftAssert();
		
		List<WebElement> links = driver.findElements(By.cssSelector("div[id='gf-BIG'] li a"));
		
		for(int i=0; i<links.size(); i++) {
			String link = links.get(i).getAttribute("href");
			
			try {
				HttpURLConnection conn = (HttpURLConnection)new URL(link).openConnection();
				conn.setRequestMethod("HEAD");
				conn.connect();
				int responseCode = conn.getResponseCode();
//				if(responseCode >= 400) {
//					System.out.println("Found broken link : " + links.get(i).getText() + " with response code : " + responseCode);
//				}
				softa.assertTrue(responseCode<400, "Found broken link : " + links.get(i).getText() + " with response code : " + responseCode);
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		softa.assertAll();
	}
}
