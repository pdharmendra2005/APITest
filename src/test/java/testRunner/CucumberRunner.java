package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The cucumber options that the runner will pick up when running from the cli
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:build/test-results/cucumber-html-report.html",
                "json:build/test-results/cucumber-report.json"

        },
        monochrome = true,
        features = {"src/test/resources/features/"},
        glue = {"stepDefinitions", "testRunner"},
        tags= "@T2"

)


public class CucumberRunner {




}
