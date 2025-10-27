package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

public class Excelutility {
	static FileInputStream f;
	static XSSFWorkbook wb;
	static XSSFSheet sh;//to read details from sheet

	public static String getStringData(int a,int b,String sheet) throws IOException 
	{
		f=new FileInputStream(Constant.testData);//in build class to get details from file
		wb= new XSSFWorkbook(f);//in build Apache class to get details from workbook
		sh=wb.getSheet(sheet);//is a method to get details from sheet
		XSSFRow r =sh.getRow(a);//a,b indicate row and cell values, xssfro is used to represent row
		XSSFCell c = r.getCell(b);//getrow is method to get value from row,xssfcell is used to get values from cell
		return c.getStringCellValue();//used to get string value
	}
	
	public static String getIntdata(int a,int b,String sheet)throws IOException
	{
		
		f=new FileInputStream(Constant.testData);//in build class to get details from file
		wb= new XSSFWorkbook(f);//in build Apache class to get details from workbook
		sh=wb.getSheet(sheet);//is a method to get details from sheet
		XSSFRow r =sh.getRow(a);//a,b indicate row and cell values, xssfro is used to represent row
		XSSFCell c = r.getCell(b);
		int var=(int)c.getNumericCellValue();
		return String.valueOf(var);
		
	}

}

