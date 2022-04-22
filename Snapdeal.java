package Week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.javadoc.internal.doclets.toolkit.util.DocFinder.Output;

public class Snapdeal {

	

			private static final OutputType<File> Outputfile = null;

			public static void main(String[] args) throws IOException, InterruptedException {
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://www.snapdeal.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Thread.sleep(3000);
				WebElement mens = driver.findElement(By.className("catText"));
			    Actions builder = new Actions(driver);
				builder.moveToElement(mens).perform();
				Thread.sleep(3000);
		        driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		        String totalItems = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		        System.out.println("Total number are:"+totalItems);
		        driver.findElement(By.xpath("//div[text() = 'Training Shoes']")).click();
		        driver.findElement(By.xpath("//span[text() ='Sort by:']")).click();
		        Thread.sleep(3000);
		        driver.findElement(By.xpath("//li[@class='search-li'][1]")).click();
		        WebElement from = driver.findElement(By.xpath("//div[@class='price-text-box']//input[1]"));
		        from.clear();
		        from.sendKeys("900");
		        WebElement to = driver.findElement(By.xpath("(//div[@class='price-text-box']//input)[2]"));
		        to.clear();
		        to.sendKeys("1200");
		        driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();//div[@class='sdCheckbox filters-list ']
		        Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='view-more-button btn btn-line btn-theme-secondary viewMoreFilter']")).click();
				driver.findElement(By.xpath("//input[@id='color_s-Navy']/following-sibling::label")).click();
				Thread.sleep(3000);
				
				String color = driver.findElement(By.xpath("//a[@class='clear-filter-pill'])[1]")).getText();
				String color1 = driver.findElement(By.xpath("//[contains(text(), 'Navy')])[2]")).getText();
				
		        if(color.contains("Navy")){
		        	System.out.println("Navy Color");
		        }else {
		        	System.out.println("other color");
		        }
		        if(color1.contains("Navy")){	
		        	System.out.println("Its a Correct Price");
		        }else {
		        	System.out.println("Other Than required Price");
		        }
		       
		        WebElement Quickview = driver.findElement(By.xpath("(//p{@class='product-title'])[1]"));
		        builder.moveToElement(Quickview).perform();
		        String price = driver.findElement(By.xpath("//a[@class='clear-filter-pill'])[1]")).getText();
		        System.out.println(price);
		        String discount = driver.findElement(By.xpath("//[contains(text(), '% off')])[2]")).getText();
		        File ScreenshotAs = driver.getScreenshotAs(OutputType.FILE);
				File image = new File("./snaps/img.jpg");
				FileUtils.copyFile(ScreenshotAs, image);
				System.out.println("Clicked Snapped");
				driver.close();
				driver.quit();
	}

}
