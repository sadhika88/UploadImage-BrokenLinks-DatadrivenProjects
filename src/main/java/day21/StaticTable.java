package day21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver sadhika=new ChromeDriver();
sadhika.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
sadhika.get("https://testautomationpractice.blogspot.com/");
//find total number of rows in a table
  int rows=sadhika.findElements(By.xpath("//table[@name='BookTable']//tr")).size();//multiple table in a webpage it is preferred
System.out.println("number of rows:" +rows);
//2nd method
//int rows=sadhika.findElements(By.tagName("tr")).size();//display all number of rows which are present in web page(single table in a webpage)
//System.out.println(rows);
//find total number of columns in a table
//int columns=sadhika.findElements(By.xpath("//table[@name='BookTable']//th")).size();//multiple tables
//int columns2=sadhika.findElements(By.tagName("th")).size();//single table
//System.out.println(columns);
//read specific row and column-5th row 1st column

//String bookname=sadhika.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
//System.out.println(bookname);
//System.out.println("Bookname" + "\t" +  " Author" + " \t" +  " Subject" + " \t" + " Price");
//read the data all rows and 	columns
/*for(int r=2;r<=rows;r++){ 
	for(int c=1;c<=columns;c++) {
		String value=sadhika.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
		System.out.print(value  + "   ");
	}
	System.out.println();
}*/
//print book names whose author is mukesh
/*for(int r=2;r<=rows;r++) {
	String authername=sadhika.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
	//System.out.println(authername);
	if(authername.equals("Mukesh")) {
		String book=sadhika.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
		System.out.println(book + " \t" +authername);
	}
}*///find total price all the books
int total=0;
for(int r=2;r<=rows;r++) {
	String price=sadhika.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();//td column name that is price
	//System.out.println(price);
	total=total+Integer.parseInt(price);
	//System.out.println(total);
}
System.out.println(total);//7100
	}
}
	
	

	


