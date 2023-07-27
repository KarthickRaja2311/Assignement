package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.login.CucumberReporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\LENOVO\\newEclipseWorkspe\\SampleAppiumMaven\\src\\test\\resources\\Features\\MyntraApp.feature",
					glue="org.steps",
					dryRun=true,
					monochrome=false,
					plugin="json:C:\\Users\\LENOVO\\newEclipseWorkspe\\SampleAppiumMaven\\target\\Sample.json",
					snippets=SnippetType.CAMELCASE)
public class TestRunnerClass {
	
	@AfterClass
	public static void tc0() {
		CucumberReporting.generateReport("C:\\Users\\LENOVO\\newEclipseWorkspe\\SampleAppiumMaven\\target\\Sample.json");
	}
	
	

}
