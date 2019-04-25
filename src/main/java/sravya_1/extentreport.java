package sravya_1;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.corba.se.impl.util.Utility;

public class extentreport {
	static ExtentHtmlReporter html;
	static ExtentTest logger;
	public static WebDriver driver;
	public static launch_ie errflpath;
	private launch_ie launch_ie;

	public void report() throws IOException, InterruptedException {

		html = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/testReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);
		ExtentTest logger = extent.createTest("MyFirstTest", "Test Description");
		html.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		html.config().setTheme(Theme.DARK);

		ArrayList<String> path = launch_ie.k;
		ArrayList<String> l = launch_ie.h;
		String s = null, m = null;
		try {
			//System.out.println("aaaaaaaaaaaaaaaaaa"+ l.size());
			for (int i = 0; i <l.size(); i++) {
				s = l.get(i);
				m = path.get(i);
				logger.log(Status.PASS,
						"<img id=data-v-0ab09c0c=" + m + " width=200px height=100 data-src=" + m + "></a>" + "Click here : <a href="+ s +">url</a>");
				
				extent.flush();
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
	         System.out.println("Array is out of Bounds"+e);
	  }
					
	}
		}


