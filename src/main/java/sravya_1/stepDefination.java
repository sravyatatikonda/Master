package sravya_1;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class stepDefination {
	private launch_ie launch_ie;
	private static WebDriver driver;
	@Given("navigate to souled stores")
	public void navigate_to_souled_stores() throws InterruptedException, IOException {
		launch_ie = new launch_ie();
		launch_ie.main();
	}
	@Then("cick on mobile covers")
	public void cick_on_mobile_covers() throws IOException, InterruptedException {
		launch_ie.clickOnMobileCovers(); 
	}

	@Then("click on one plus")
	public void click_on_one_plus() throws IOException, InterruptedException {
		launch_ie.clickOnOneplus();
	}

	@Then("get the no of pages")
	public void get_the_no_of_pages() throws IOException, InterruptedException {
		launch_ie.noofpages();
	}
	
	/*@Then("click on the urls")
	public void click_on_the_urls() throws InterruptedException, IOException {
		launch_ie.clickOnUrl();
	}
	
	@Then("copy the urls into excel sheet")
	public void copy_the_urls_into_excel_sheet() throws IOException {
	    launch_ie.Excelwriter();
	}
	*/
}
