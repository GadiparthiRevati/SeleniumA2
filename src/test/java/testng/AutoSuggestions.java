package testng;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
//auto
public class AutoSuggestions {
	@Test
	public void moblileTest() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile");
	List<WebElement> list =driver.findElements(By.xpath("//div[contains(text(),'obile')]"));
	
	for(WebElement ele : list) {
		System.out.println(ele.getText());
	}
	
	driver.quit();
		
	}

}
