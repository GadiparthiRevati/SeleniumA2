package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class contains reusable methods to perform read and write operations on excel
 * @author revat 
 */



public class Excelutility {
	Workbook wb;
	Sheet sheet;
	/**
	 * this method initializes excel
	 * @param excelpath
	 * @param sheetname
	 */
	public void excelInit(String excelpath, String sheetname)
	{
		FileInputStream fis=null;
		try {
 fis=new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			wb=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			
			e.printStackTrace();
		}
		sheet=wb.getSheet(sheetname);
		
		
	}
	/**
	 * this method is used to read data from excel
	 * @param expectedTestName
	 * @return Map<String,String>
	 */
	public Map<String, String> readFromExcel(String expectedTestName) {
		Map<String,String> map=new HashMap<String,String>();
		DataFormatter df=new DataFormatter();
		int requiredRow=0;
		for(int i=0;i<=sheet.getLastRowNum();i++) {
			requiredRow=i;
			if(df.formatCellValue(sheet.getRow(i).getCell(1)).equals(expectedTestName))
					break;
		}
		for(int j=requiredRow; j<=sheet.getLastRowNum();j++) {
			String key=df.formatCellValue(sheet.getRow(j).getCell(2));
					String value=df.formatCellValue(sheet.getRow(j).getCell(3));
					if(key.equals("####"))
						break;
					map.put(key, value);
		}
		return map;
	}
	/**
	 * this method is used to update test status to excel
	 * @param expectedTestName
	 * @param status
	 */
		
		public void updateStatus(String expectedTestName, String status) {
			
			DataFormatter df=new DataFormatter();
		
			for(int i=0;i<=sheet.getLastRowNum();i++) {
			
				if(df.formatCellValue(sheet.getRow(i).getCell(1)).equals(expectedTestName)) {
					sheet.getRow(i).createCell(4).setCellValue(status);
					break;
				}
	}
		}
		/**
		 * this methos is used to save excel
		 * @param excelpath
		 */
			public void saveExcel(String excelpath) {
				FileOutputStream fos=null;
			
				try {
					 fos = new FileOutputStream(excelpath);
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
				try {
					wb.write(fos);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
			
			 /**
			  * 
			  * this method is used to close excel workbook
			  */
			 
			 
			 
			public void closeExcel() {
				try {
					wb.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
				
			

}