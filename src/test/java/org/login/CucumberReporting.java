package org.login;

import java.io.File;
import java.util.ArrayList;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class CucumberReporting {
	
	public static void generateReport(String jsonPath) {
		File f = new File("C:\\Users\\LENOVO\\newEclipseWorkspe\\SampleAppiumMaven\\target");
		Configuration c = new Configuration(f, "MyntraAppLaunch");
		c.addClassifications("Author", "Karthick Raja");
		c.addClassifications("OS", "Android");
		c.addClassifications("Sprint", "3.0");
		c.addClassifications("App", "Dream11");
		
		ArrayList<String> al = new ArrayList();
		al.add(jsonPath);
		
		ReportBuilder r = new ReportBuilder(al, c);
		r.generateReports();
		
	}

}
