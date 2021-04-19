package com.org.project.BussinessLogic;

import java.io.IOException;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.org.framework.WebDriverFactory;
import com.org.framework.DataDrivenUtility.FilloUtility;
import com.org.project.Actions.UserActions;
import com.org.project.Allocater.Allocater;
import com.org.project.pageObjects.Gurupage;

public class Guru extends WebDriverFactory{

	public Guru() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	static UserActions action;
	Gurupage guruPageObj= new Gurupage();
	public void commentsBox() throws FilloException, IOException {
		
		action=new UserActions();
		String testcase=rs.getField("TestCaseName");
		action.enterText(Gurupage.commentBox, testcase);
	}

}
