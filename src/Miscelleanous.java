import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Miscelleanous {

	public static void main(String[] args) {

				
		ChromeOptions options = new ChromeOptions();
				
				
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("asdf");
		
		driver.get("https://www.google.com/");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("/Users/stevelee/selenium/tmp/screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
