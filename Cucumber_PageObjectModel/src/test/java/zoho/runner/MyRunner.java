package zoho.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		 features="src/test/resources/",
		 glue="teststeps"
		//plugin= {"html:target/Pramesh-reports.html","rerun:rerun/failed_scenarios.txt"},
		//tags="@Leads"
		)

   public class MyRunner extends AbstractTestNGCucumberTests {
	 
     
     }