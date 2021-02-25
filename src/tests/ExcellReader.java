package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcellReader {
	//WebDriver driver;
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	public ExcellReader(String fileName) throws IOException {
		//this.driver = driver;
		this.file = new File(fileName);
		this.fis = new FileInputStream(file);
		this.wb = new XSSFWorkbook(fis);
	}
	public String taxtualValue(String sheetName, int rowNo, int cellNo) {
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNo);
		cell = row.getCell(cellNo);
		return cell.getStringCellValue();
	}
	public int numericValue(String sheetName, int rowNo, int cellNo) {
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNo);
		cell = row.getCell(cellNo);
		return (int) cell.getNumericCellValue();
	}
	
	

	
	
	
	

}
