package genericUtilities;
/**
 * this class contains reusable methods to read data from properties file
 * @author revati
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	Properties property;
	/**
	 * this method initializes properties file
	 * @param filepath
	 */
	
	public void propertiesInit(String filepath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * this method fetches data from properties file
	 * 
	 * @param key
	 * @return string
	 */
	
	public String getDataFromproperties(String key){
		return property.getProperty(key);
	}
	
		
	
	

}
