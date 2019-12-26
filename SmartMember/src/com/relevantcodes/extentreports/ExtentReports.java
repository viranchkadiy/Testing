package com.relevantcodes.extentreports;

public interface ExtentReports {

	ExtentTest startTest(String string);

	void flush();

	void endTest(ExtentTest test);

}
