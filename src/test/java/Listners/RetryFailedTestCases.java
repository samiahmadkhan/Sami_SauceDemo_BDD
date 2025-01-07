package Listners;

import com.utility.ConfigReader;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryFailedTestCases implements IRetryAnalyzer, IAnnotationTransformer {
    int count=0;
    @Override
    public boolean retry(ITestResult result) {
        int retryLimit=0;
        if(!(ConfigReader.initializeProp().getProperty("RetryLimit")==null)){
            retryLimit=Integer.parseInt(ConfigReader.initializeProp().getProperty("RetryLimit"));
        }
       if(count<retryLimit){
           count++;
           System.out.println("Retryyyyyyyyyyyyyyyyyyyyyyy");
           return true;
       }
        return false;
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod);
        annotation.setRetryAnalyzer(RetryFailedTestCases.class);
    }
}
