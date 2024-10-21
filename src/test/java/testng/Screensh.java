package testng;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Screensh {
	@Test
	public void test() throws IOException {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		TakesScreenshot ts=(TakesScreenshot)driver;
	File temp=	ts.getScreenshotAs(OutputType.FILE);
	File src=new File("./Screenshots.google.png");
	FileUtils.copyFile(temp, src);
		
	}

}
  