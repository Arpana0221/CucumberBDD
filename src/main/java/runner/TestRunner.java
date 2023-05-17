package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "D:\\Selenium_Training\\Sel@9PM(EST)\\workspace\\CucumberBDD\\src\\main\\java\\features",
		glue={"stepDefinations"},
		dryRun=false,
		plugin= {"pretty","json:target/myReports/report.json","junit:target/myReports/report.xml"}
	//  plugin={"font-style","report-type:<path>,"report-type:<path>}
		)
public class TestRunner {

}
