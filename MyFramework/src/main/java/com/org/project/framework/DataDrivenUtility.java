package com.org.project.framework;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;

public class DataDrivenUtility extends FrameworkParameters{

	public DataDrivenUtility() {
		// TODO Auto-generated constructor stub
	}
	Configurations globalConfig=new Configurations();
	String RunManagerPath=globalConfig.getGlobalProperty("RunManagerPath");
	String RunManagerSheet=globalConfig.getGlobalProperty("RunManagerSheetName");
	String TestDataPath=globalConfig.getGlobalProperty("TestDataPath");
	String TestDataSheet=globalConfig.getGlobalProperty("TestDataSheetName");

	public List getRunmanagerTestCases() {
		ArrayList<String> TestCases = null;
		try {
			TestCases=new ArrayList();
			ConnectRunManager=RunmanagerFillo.getConnection(RunManagerPath);
			String TestCasesToBeExecuted="Select * From "+RunManagerSheet;
			RunManagerRecordSet=ConnectRunManager.executeQuery(TestCasesToBeExecuted);
			while(RunManagerRecordSet.next()) {
				TestCases.add(RunManagerRecordSet.getField("TestCaseName"));
			}
			ConnectRunManager.close();
		} catch (Exception e) {
			e.printStackTrace();
			ConnectRunManager.close();
		}
		return TestCases;
	}

	public String setTestCasetoRecordSet(String TestCaseName) {

		String Data=null;
		try {
			ConnectTestData=RunmanagerFillo.getConnection(TestDataPath);
			String TestCase="Select * From "+TestDataSheet;
			TestDataRecordSet=ConnectTestData.executeQuery(TestCase).where("TestCaseName='"+TestCaseName+"'");
			TestDataRecordSet.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Data;
	}


	public String getData(String TestCaseName, String ColumnName) {

		String Data=null;
		try {
			ConnectTestData=RunmanagerFillo.getConnection(TestDataPath);
			String TestCase="Select * From "+TestDataSheet;
			TestDataRecordSet=ConnectTestData.executeQuery(TestCase).where("TestCaseName='"+TestCaseName+"'");
			TestDataRecordSet.next();
			Data=TestDataRecordSet.getField(ColumnName);


		} catch (Exception e) {
			e.printStackTrace();
		}
		return Data;
	}
	public ArrayList<String> getKeywords(String TestCaseName) {
		ArrayList<String> Keywords = null;
		try {
			//List<String> Testcases=getRunmanagerTestCases();
			//for(int i=1;i<Testcases.size();i++) {
				setTestCasetoRecordSet(TestCaseName);
				int fields=TestDataRecordSet.getFieldNames().size();
				List<String> columnheader=TestDataRecordSet.getFieldNames();
				Keywords=new ArrayList();
				for(int j=1;j<fields;j++) {
					String key=TestDataRecordSet.getField(columnheader.get(j));
					if(!key.equals(null)||!key.isEmpty()||!key.isBlank()) {
						Keywords.add(key);
						
					}
				}
			//}
		}catch(Exception e) {
			e.printStackTrace();
		}
		String FirstRound=Keywords.toString().replaceAll(" ,", "");
		String SecondRound=FirstRound.toString().replaceAll(", ]", "");
		String FourRound=SecondRound.toString().replaceAll("\\[", "");
		String[] FinalKeywords=FourRound.split(",");
		ArrayList<String> ListKeywords= new ArrayList<String>();
		for(int a=0;a<FinalKeywords.length;a++) {
			ListKeywords.add(FinalKeywords[a]);
		}
		return ListKeywords;
	}

}
