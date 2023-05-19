package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
        (
        		//mandatory things.
        		features=".\\Features\\Customers.feature",   //add the feature file here
        		glue="stepDefinitions",   //link the stepdefinition file inside the glue which contain feature file steps.
        		dryRun=false,              //to match all the feature gherkin annotations linked with steps in the stepdefinitionfile.
        		monochrome=true,          //to remove the unwanted stuff in the console output.
        		plugin= {"pretty","html:target/htmlreports",  //to generate the html reports in pretty format target-->htmlreports-->index.html
        				"junit:target/JUnitReports/report.xml",  //to generate xml report under target-->JunitReports-->
        				"json:target/JSONReports/report.json"  //to generate json reports inside target-->JSONReportsfolder
        				},
        		tags="@regression"
		)

public class TestfirstRun {

}
