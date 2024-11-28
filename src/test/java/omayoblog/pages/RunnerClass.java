package omayoblog.pages;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/omayoblog/pages/login.feature" }, glue = { "omayoblog/pages" })
public class RunnerClass {

}
