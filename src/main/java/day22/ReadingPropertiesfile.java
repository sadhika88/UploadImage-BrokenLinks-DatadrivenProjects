package day22;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//create object properties of a class
Properties obj=new Properties();
//location of properties file
FileInputStream file=new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\Batch55_OrangeHRM\\src\\main\\java\\day22\\config.properties");
//loading properties file
obj.load(file);
//reading data from properties data
String url=obj.getProperty("appurl");
String em=obj.getProperty("email");
String pwd=obj.getProperty("password");
String oid=obj.getProperty("orderid");
String cid=obj.getProperty("customerid");
System.out.println(url+ " "+em+" "+pwd+" "+oid+" " +cid);
//reading all keys from properties file 1st approach
//Set<String> keys=obj.stringPropertyNames();//is a set of string
//System.out.println(keys);
//2nd approach
Set<Object> keys= obj.keySet();
System.out.println(keys);
//reading all values from properties fvalue
Collection<Object>  values=obj.values();
System.out.println(values);
file.close();

	}

}
