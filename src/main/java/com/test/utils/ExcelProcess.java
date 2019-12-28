package com.test.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelProcess {
	public static Object[][] proessExcel(String filePath,int sheetId) throws Exception {

	//数据流读入Excel
	File file = new File(System.getProperty("user.dir")+filePath);
	FileInputStream fis = new FileInputStream(file);
	HSSFWorkbook wb = new HSSFWorkbook(fis);
	//Workbook wb = WorkbookFactory.create(fis);
	System.out.println("read excel");
	
	//读取特定表单并计算行列数
	HSSFSheet sheet = wb.getSheetAt(sheetId);
	System.out.println("1");
	int numberOfRow = sheet.getPhysicalNumberOfRows();
	System.out.println("2");
	int numberOfCell = sheet.getRow(0).getLastCellNum();
	System.out.println("sum row");
	
	//将表单数据处理存入dtt对象
	System.out.println("restore data to dtt");
	Object[][] dttData = new Object[numberOfRow][numberOfCell];
	for(int i=0;i<numberOfRow;i++) {
		if(null==sheet.getRow(i)||"".equals(sheet.getRow(i))) {
			continue;
		}
		
		for(int j=0;j<numberOfCell;j++) {
			if(null==sheet.getRow(i).getCell(j)||"".equals(sheet.getRow(i).getCell(j))) {
				continue;
			}
			HSSFCell cell = sheet.getRow(i).getCell(j);
			cell.setCellType(CellType.STRING);
			dttData[i][j]=cell.getRichStringCellValue();
		}
	}
	
	return dttData;
	}
}
