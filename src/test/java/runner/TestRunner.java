package runner;



import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature"
		,glue={"com.stepDefinition"},tags= {"@tag2"},dryRun=false,
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		 monochrome = true
		)

public class TestRunner {
	
	 @AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));

}
}