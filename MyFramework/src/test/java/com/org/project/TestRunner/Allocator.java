package com.org.project.TestRunner;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;



import com.org.project.Commands.UserActions;
import com.org.project.framework.DataDrivenUtility;
import com.org.project.framework.WebDriverFactory;

public class Allocator extends WebDriverFactory{

	static UserActions actions=new UserActions();
	static DataDrivenUtility dataTables= new DataDrivenUtility();
	public static void main(String[] args) throws Exception {
	
		launchWebDriver(); 
		actions.launchApplication(); 
		actions.quitBrowser();
		 


		/*List<String> Testcases=dataTables.getRunmanagerTestCases();
		ArrayList<String> Keywords=dataTables.getKeywords(Testcases.get(0));
		System.out.println(Keywords);
		File file=new File("C:\\SeleniumFrame\\MyFramework\\target\\test-classes\\com\\org\\project\\BusinessLogic");
		File[] classes=file.listFiles();
		
		for(File classs:classes) {
			String classname=classs.getName().replace(".class", "").trim();
			Class<?> classess=Class.forName("com.org.project.BusinessLogic."+classname);
			//Class classess=classs.getClass();
			Method[] method_s=classess.getDeclaredMethods();
			
			
			for(Method methods:method_s) {
				 
				 Method methodToExecut=classess.getMethod(Keywords.get(0), null);
				System.out.println(methodToExecut);

				//if(Keywords.contains(methods)) {
					methodToExecut.invoke(null, null);
				//}

			}
		}
		//Class classess=Class.forName("SamplPage").getClass();
		//System.out.println(classess.getName());*/
	}

}
