package testng;

import org.testng.annotations.Test;
//maven
public class MavenParameterizationTest {
	@Test
	public void parameterizationTest() {
	String url=	System.getProperty("url");
	String browser=System.getProperty("browser");
	System.out.println(url);
	System.out.println(browser);
	}

}
