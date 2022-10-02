package com.base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener implements ITestListener{

	ExtentTest test;
	ExtentReports extent=ExtentReporter.getReportObject();
	
	@Override
	public void onTestStart(ITestResult result) {
		
		 test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String details = getMethodNameWithParams(result);
		test.log(Status.PASS, details );
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		String details = getMethodNameWithParams(result);
		test.info(details);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
	
	public String getMethodNameWithParams(ITestResult result) {
		String details = result.getName() + "( ";
		Object[] params = result.getParameters();
		int len = params.length;
		for(int i = 0; i < len; i++) {
			details += params[i].toString();
			if(i == len -1) {
				details += " )";
			}
			else {
				details += ", ";
			}
		}
		return details;
	}

}
