package testng;

import org.testng.annotations.Test;
//sysyem properties
public class GetSystemAndbrowserproperties {
	@Test
	public void demo() {
		System.getProperties().list(System.out);
	}


}
