package cucumberRunner;


import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ={"src/test/resources/features"},
        glue={"stepDefinitions"}, stepNotifications = true,
plugin = {"pretty", "html:target/cucumber-reports/Cucumber.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
},

monochrome = true)

public class TestRunner {


}
