package Frameaworks;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriven {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	//static HSSFWorkbook workbook1;// for xls format use HSSF -> hSSFWorkbook
	//static HSSFSheet sheet1;

	public ExcelDriven(String excelPath, String sheetName) {
		try {
			
			//InputStream file = new FileInputStream(excelPath);
			//workbook1 = new HSSFWorkbook(new POIFSFileSystem(file));
			//sheet1 = workbook1.getSheet(sheetName);
			
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);

		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

	/*public static void main(String[] args) {
		getRowCount();
		getCellData();
	}*/

	public static void getCellData(int row, int col) {

		/*
		 * String path = System.getProperty("user.dir");
		 * 
		 * String excelPath = "./SOAPRequest/DataDriven.xlsx"; workbook = new
		 * XSSFWorkbook(excelPath); // fpr xls format use HSSF -> hSSFWorkbook sheet =
		 * workbook.getSheet("Sheet1");
		 */

		DataFormatter format = new DataFormatter(); // like type cast
		Object dataFormatter = format.formatCellValue(sheet.getRow(row).getCell(col));
		System.out.println("Cell dataFormatter Value : " + dataFormatter);

		double value = sheet.getRow(1).getCell(0).getNumericCellValue();
		System.out.println("Cell Value: " + value);

	}

	public static void getRowCount() {

		/*
		 * try {
		 * 
		 * String path = System.getProperty("user.dir");
		 * 
		 * String excelPath = "./SOAPRequest/DataDriven.xlsx"; workbook = new
		 * XSSFWorkbook(excelPath); // fpr xls format use HSSF -> hSSFWorkbook sheet =
		 * workbook.getSheet("Sheet1");
		 */

		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("No of Row: " + rowCount);

	}/*
		 * catch (IOException e) { System.out.println(e.getMessage());
		 * System.out.println(e.getCause()); e.printStackTrace(); }
		 */
}
