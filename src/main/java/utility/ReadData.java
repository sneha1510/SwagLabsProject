package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData 
{
       //deal with config.properties	
      public static String readPropertyFile(String value) throws IOException
      {
    	  Properties prop=new Properties();
		  FileInputStream file=new FileInputStream("C:\\Selenium_Framework\\1_SeleniumFramework\\src\\main\\java\\config\\config.properties");
    	  prop.load(file);
		  return prop.getProperty(value);
      }
      //used for param. purpose
      public static String readExcel(int row_no,int col_no) throws EncryptedDocumentException, IOException
      {
    	  FileInputStream file=new FileInputStream("C:\\Selenium_Framework\\1_SeleniumFramework\\TestData\\Excel1.xlsx");
    	  Sheet sheet1 = WorkbookFactory.create(file).getSheet("Sheet1");
    	  String value = sheet1.getRow(row_no).getCell(col_no).getStringCellValue();  
          return value;
      }

	
}
