package com.org.dataProvider;

import java.util.ArrayList;

public class TestDataUtil {
	static ConfigReader configFileReader = new ConfigReader();
	static ExcelFileReader excelFileReader;
	
	public static ArrayList<Object[]> getDataList() {
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		try{
		excelFileReader = new ExcelFileReader(configFileReader.getValue("testDataResourcePath"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		for(int rowNum = 2; rowNum <= excelFileReader.getRowCount("testdata"); rowNum++){
			
			String platform = excelFileReader.getCellData("testdata", "Platform", rowNum);
			String browser = excelFileReader.getCellData("testdata", "Browser", rowNum);
			String version = excelFileReader.getCellData("testdata", "Version", rowNum);
			Object[] object= {platform, browser, version};
			list.add(object);
		}
		return list;
	}

}
