package day21;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utilites.ExtentReport;

public class workbook {
	public static WebDriver driver;
	@Test

	public void ReadData() throws IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		FileInputStream fie=new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\Batch55_OrangeHRM\\testdata\\Book1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fie);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
	//XSSFSheet sheet=workbook.getSheetAt(0);
		int totalrows=sheet.getLastRowNum();
		
		int   totalnoofcells=sheet.getRow(1).getLastCellNum();
		System.out.println("no of rows : " +totalrows);//6 in excecl count 0 in java 
		//both rows and cells are count from 0
		System.out.println("no of cells  :" +totalnoofcells);//5 count 1 in java 
		//both rows and cells are count from 0
		for(int i=0;i<=totalrows;i++) {
			XSSFRow currentrow=sheet.getRow(i);//extract the particular row
			for(int j=0;j<totalnoofcells;j++) {// reading the cell from particular row
				XSSFCell cell=currentrow.getCell(j);//extract cell into store cell variable
			System.out.print(cell.toString()+"\t");//get the data from cell
			}
			System.out.println();
		}
		workbook.close();
		fie.close();
		ExtentReport.driver=driver;
	}

}
