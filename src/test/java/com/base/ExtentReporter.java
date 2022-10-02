package com.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	public static ExtentReports getReportObject() {
		//location of report
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		System.out.println(System.getProperty("user.dir"));
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("web Automation Report");
		reporter.config().setDocumentTitle("Test Result");
		
		ExtentReports extent= new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Tester", "Swapnil");
		
		return extent;
		
		
	}
}
