package Frameaworks;

public class ExcelDriven_Test {
	public static void main(String[] args) {
		String excelPath = "./SOAPRequest/DataDriven.xlsx";
		String  sheetName = "Sheet1";
		ExcelDriven excel = new ExcelDriven(excelPath,sheetName );
		excel.getRowCount();
		excel.getCellData(1,2);
	}
}
