package DriverFactory;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int retryCount=0;
    private static int FinalRetryCount=3;

    public boolean retry(ITestResult result){
        if(retryCount<FinalRetryCount){
            retryCount++;
            return true;
        }
        return false;
    }
}