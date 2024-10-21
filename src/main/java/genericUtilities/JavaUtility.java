package genericUtilities;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import genericUtilities.DataType;
/*
 * this class contains reusable methods to perform java related operations
 * @author revati
 */

public class JavaUtility {
	/*
	 * this methodreturns randpm number within the specified limit
	 * @param limit
	 * @return limit
	 */
	
public int generateRandomNum(int limit) {
	Random random=new Random();
	return random.nextInt(limit);
}

	public Object convertStringToAnyDataType(DataType datatype,String value) {
		Object obj=null;
		if(datatype.toString().equalsIgnoreCase("int"))
			obj=Integer.parseInt(value);
		else if(datatype.toString().equalsIgnoreCase("long"))
		obj=Long.parseLong(value);
		else if(datatype.toString().equalsIgnoreCase("double"))
		obj=Double.parseDouble(value);
		else if(datatype.toString().equalsIgnoreCase("boolean"))
		obj=Boolean.parseBoolean(value);
		else
			System.out.println("invalid data type");
		return obj;
	}
	
	
	/*
	 * this method fetches system date and time
	 * @return String
	 */
		
		public String getCurrentTime() {
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yy_hh_mm_ss");
			return sdf.format(date);
		}
		/*
		 * this method waits for the given time
		 * @param time
		 */
		
		public void await(long time) {
			
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		/*
		 * this method converts month name to the number
		 * @param monthName
		 * @return int
		 */
		public int convertMonthToNum(String monthName) {
			
			return DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(monthName).get(ChronoField.MONTH_OF_YEAR);
		}
			
	}

	
	


