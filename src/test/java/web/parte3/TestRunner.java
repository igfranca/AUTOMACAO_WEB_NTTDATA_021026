package web.parte3;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/web/parte3/resources",
    glue = {"web.parte3.steps", "web.parte3.hooks"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    tags = "@CenarioCompra"

)
public class TestRunner {
}
