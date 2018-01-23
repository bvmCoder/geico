package com.geico.test.utility;

import java.util.ArrayList;

import com.geico.qa.utility.Xls_Reader;

public class testUtility {
	static Xls_Reader reader;
	
   public static ArrayList<Object[]> getDataFromExcel(){
	   
	   ArrayList<Object[]>myData = new ArrayList<Object[]>();
	    try{
	    	reader = new Xls_Reader("/Users/bp/Documents/workspace/Geico/src/com/geico/qa/testdata/GEICO_DataSet1.xlsx");
	    	
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	for(int rowNum = 2; rowNum <= reader.getRowCount("RegistrationData"); rowNum++){
		
		String firstName = reader.getCellData("RegistrationData", "firstname", rowNum);
		String lastName = reader.getCellData("RegistrationData", "lastname", rowNum);
		String Address = reader.getCellData("RegistrationData", "address", rowNum);
		String Apt = reader.getCellData("RegistrationData", "apt", rowNum);
		String Zipcode = reader.getCellData("RegistrationData", "zipcode", rowNum);
		String MonthDOB= reader.getCellData("RegistrationData", "MonthDOB", rowNum);
		String DayDOB= reader.getCellData("RegistrationData", "DayDOB", rowNum);
		String YearDOB= reader.getCellData("RegistrationData", "YearDOB", rowNum);
		
		Object obj[] = {firstName,lastName,Address,Apt,Zipcode,MonthDOB,DayDOB,YearDOB};
		myData.add(obj);
		
	   }
	
	  return myData;
    }
   
   

 
}
