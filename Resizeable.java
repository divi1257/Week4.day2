package Week4.day2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.mongodb.client.model.geojson.Point;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizeable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //    Actions builder = new Actions(driver);
//        WebElement reSize = driver.findElement(By.xpath("//div[@id ='resizable']"));
//        org.openqa.selenium.Point location = reSize.getLocation();
//        builder.dragAndDropBy(reSize, location.getX(), location.getY()).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	    driver.switchTo().frame(0);
	    WebElement drag = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
	     
	    Actions build = new Actions(driver);
	    build.clickAndHold(drag).moveByOffset(400, 30).release(drag).perform();
	}
}