package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerAE  implements ITestListener {

	public void onStart(ITestContext context) {
		System.out.println("Starting "+context.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test got Finished "+context.getName());
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test is on Start "+result.getTestName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is Success "+result.getTestName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Got Failed"+result.getTestName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test got Skipped"+result.getTestName());
	}

}
