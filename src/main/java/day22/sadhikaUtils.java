package day22;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class sadhikaUtils {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	public static int getRowCount(String xlfile,String Xlsheet) throws IOException {//xlfile path,xlsheetname
		fi=new FileInputStream( xlfile);//opening the file input mode
		wb=new XSSFWorkbook(fi);//getting the sheet
		ws=wb.getSheet(Xlsheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}
	public static int getCellCount(String xlfile,String Xlsheet,int rownum) throws IOException {//xlfile path,xlsheetname
		fi=new FileInputStream( xlfile);//opening the file input mode
		wb=new XSSFWorkbook(fi);//getting the sheet       rownum--which row particular find number of cell
		ws=wb.getSheet(Xlsheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
		}
	public static String getcellData(String xlfile,String Xlsheet,int rownum,int column) throws IOException {
		fi=new FileInputStream( xlfile);//opening the file input mode
		wb=new XSSFWorkbook(fi);//getting the sheet
		ws=wb.getSheet(Xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(column);
		String data;
		try {
			//data=cell.toString();//read the data from the cell
			DataFormatter formatter=new DataFormatter();//it provides APOCHI POI to read the data
			data=formatter.formatCellValue(cell);//returns the formatted valueof a cell as a string regardless of the cell type
			//A cell contains different type values like date,currency,time,percentage,fraction cells are there returns  strings format
		}catch (Exception e) {
			data="";//in a excel sheet no data but you read to fourcefully
		}
		wb.close();
		fi.close();
		return data;
	}public static void setCellData(String xlfile,String Xlsheet,int rownum,int column,String data) throws IOException {
		fi=new FileInputStream(xlfile);//opening the file input mode
		wb=new XSSFWorkbook(fi);//getting the sheet
		ws=wb.getSheet(Xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(column);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	public static void GreenColor(String xlfile,String Xlsheet,int rownum,int column) throws IOException {
		fi=new FileInputStream( xlfile);//opening the file input mode
		wb=new XSSFWorkbook(fi);//getting the sheet
		ws=wb.getSheet(Xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(column);
		 
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	public static void RedColor(String xlfile,String Xlsheet,int rownum,int column) throws IOException {
		fi=new FileInputStream( xlfile);//opening the file input mode
		wb=new XSSFWorkbook(fi);//getting the sheet
		ws=wb.getSheet(Xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(column);
		 
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
		//these are all utility files
	
	
	
	
		
		
		
	}


