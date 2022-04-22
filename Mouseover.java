package Week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouseover {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
       // driver.switchTo().frame(0);
        driver.switchTo().frame(0);
		WebElement element = driver.findElement(By.id("draggable"));
		WebElement element2 = driver.findElement(By.id("droppable"));
		Actions drop=new Actions(driver);
		drop.dragAndDrop(element, element2).build().perform();
		

	}

}
