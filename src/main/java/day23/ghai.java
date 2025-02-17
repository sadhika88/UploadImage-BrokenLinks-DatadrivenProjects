package day23;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ghai {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream file=new FileOutputStream("C:\\Users\\Dell\\eclipse-workspace\\Batch55_OrangeHRM\\foldedata\\fhana.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("DynamicData");
		Scanner sc=new Scanner(System.in);
		System.out.println("enter rows dou you have?");
		int r=sc.nextInt();
		System.out.println("enter cells dou you have?");
		int c=sc.nextInt();
		for(int i=0;i<=r;i++) {
			XSSFRow row=sheet.createRow(i);//create row
			for(int j=0;j<c;j++) {
				XSSFCell cell=row.createCell(j);//create a cell
				cell.setCellValue(sc.next());//in a cell add the data it accepts data in string format so write next beacuse
				//input data int,float etc....
			}
		}
		workbook.close();//attach workbook to file
		 file.close();
		System.out.println("File is created.....");
	}

}
