package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
//action class
public class Actingclass {
	@Test
	public void test() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		WebElement uTf=driver.findElement(By.id("email"));
		WebElement pTf=driver.findElement(By.id("passContainer"));
		Actions action=new Actions(driver);
		Thread.sleep(3000);
		action.keyDown(Keys.SHIFT).sendKeys(uTf,"revati.gadipar").keyUp(Keys.SHIFT).build().perform();
		action.sendKeys(pTf,"dhanvi").build().perform();
		action.sendKeys(Keys.ENTER).perform();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	//	wait.until(ExpectedConditions.tex)
		
	
		
		
		
		
	}

}
