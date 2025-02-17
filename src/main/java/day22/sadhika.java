package day22;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class sadhika {

	public static void main(String[] args) throws IOException {
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir") +"\\testdata\\shajhan.xlsx");
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
		workbook.write(file);//attach workbook to file
		workbook.close();
		 file.close();
		System.out.println("File is created.....");
	}

}
