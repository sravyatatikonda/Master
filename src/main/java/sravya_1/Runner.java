package sravya_1;

	import org.junit.runner.RunWith;
	import cucumber.api.CucumberOptions;
	import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = {"src/main/java/sravya_1/a.feature"},
			glue = {"sravya_1"},tags={}
			)

	public class Runner {

	}



