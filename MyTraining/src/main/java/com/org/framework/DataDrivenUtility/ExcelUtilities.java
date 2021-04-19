package com.org.framework.DataDrivenUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputFilter.Config;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.org.framework.ConfigurationUtilities;
import com.org.framework.dataDrivenAbstract;

public class ExcelUtilities{
	FileInputStream File;
	XSSFWorkbook WorkBook;
	XSSFSheet Sheet;
	XSSFRow Row;
	String ActiveSheet;

	ConfigurationUtilities GlobalProperties=new ConfigurationUtilities();
	public ExcelUtilities() throws IOException {
		// TODO Auto-generated constructor stub
		File=new FileInputStream("C:\\SeleniumFrame\\MyTraining\\src\\main\\resources\\DataTables\\InputData.xlsx");
		WorkBook=new XSSFWorkbook(File);
		ActiveSheet=GlobalProperties.getGlobalProperty("RunManager");
	}

	public int getLastRow() {
		return WorkBook.getSheet(ActiveSheet).getLastRowNum();
	}
	
	public int getLastColumn() {
		return WorkBook.getSheet(ActiveSheet).getRow(0).getLastCellNum();
	}

	public void getRowByHeader(String RowValue) throws FilloException {

	}
	
	public void getColumnByHeader(String ColumnValue) {
		
	}

}
