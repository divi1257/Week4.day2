package Week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		
		
		
		WebElement click1 = driver.findElement(By.xpath("(//button[text()='Click Me'])[1]"));
		driver.findElement(By.xpath("(//button[text()='Click Me'])[1]")).click();
		File ScreenshotAs = click1.getScreenshotAs(OutputType.FILE);
		File image = new File("./snaps/img.jpg");
		FileUtils.copyFile(ScreenshotAs, image);
		driver.switchTo().defaultContent();
		List<WebElement>findElements = driver.findElements(By.tagName("iframe"));
		int size = findElements.size();
		System.out.println("The Count of the Frames Visible to the main Page" +size);
		
				
		
	}

}
