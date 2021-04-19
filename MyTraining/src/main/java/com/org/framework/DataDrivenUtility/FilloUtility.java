package com.org.framework.DataDrivenUtility;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.org.framework.DataDrivenInterface;
import com.org.framework.dataDrivenAbstract;

public class FilloUtility extends dataDrivenAbstract {

	public FilloUtility() {
		// TODO Auto-generated constructor stub
	}
	Fillo fillo=new Fillo();
	//public static Recordset AllRecords;
	public Recordset getRecordSet() {
		
		try {
			Connection connection=fillo.getConnection("C:\\SeleniumFrame\\MyTraining\\src\\main\\resources\\DataTables\\InputData.xlsx");
			String FullData="Select* From RunConfiguration";
			AllRecords=connection.executeQuery(FullData);
			//System.out.println(AllRecords);
			
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return AllRecords;
	}

}
