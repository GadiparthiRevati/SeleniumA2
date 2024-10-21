package testng;

import org.testng.annotations.Test;

public class GetSystemAndbrowserproperties {
	@Test
	public void demo() {
		System.getProperties().list(System.out);
	}


}
