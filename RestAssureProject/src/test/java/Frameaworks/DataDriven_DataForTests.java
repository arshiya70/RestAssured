package Frameaworks;

import org.testng.annotations.DataProvider;

public class DataDriven_DataForTests {

	@DataProvider(name="DataForPost")
	public Object [] [] dataForPost() { 
		Object[][] data = new Object[6][4]; //3 row 4 col
		
//		data[1][0] = 5;
//		data[1][1] = "Esrab";
//		data[1][2] = " ";
//		data[1][3] = 62;
//		
//		data[2][0] = 6;
//		data[2][1] = "Karim";
//		data[2][2] = "unisa";
//		data[2][3] = 0;
//		
//		data[3][0] = 7;
//		data[3][1] = "Moin";
//		data[3][2] = "uddin";
//		data[3][3] = 0;
		
		//return data;
		
		return new Object [][] {
			{3, "Shakila" ,"Begum", 47},
			{4, "Siraj" ,"Uddin", 58},
			{5, "Esrab" ," ", 62},
			{6, "Karim" ,"unisa", 0},
			{7, "Moin" ,"uddin", 0}
			
		};
		
	}
	

	@DataProvider (name ="DelDataProvide")
	public Object[] dataforDelete() {
		return new Object[] {
				7
		};
	}
}
