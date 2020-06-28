package tests;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class AlexListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("ERROR");
    }
}
