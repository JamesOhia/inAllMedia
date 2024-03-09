package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static void getRowCount() {
		
      XSSFWorkbook workbook = new XSSFWorkbook();
      XSSFSheet sheet = workbook.getSheet("Sheet1");
	}

}
