package genericLibrary;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class MyListener extends BaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("---test---"+result.getName()+" started",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("---test---"+result.getName()+" succeeded",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {//address of failed method receives in result variable
		 String failedMethod = result.getName();//gives the name of failedMethod
		 String ldt = LocalDateTime.now().toString();
		 String timeStamp = ldt.replaceAll(":", "-");
		 TakesScreenshot ts =(TakesScreenshot)driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 File dest = new File("./errorshots/"+failedMethod+timeStamp+".png");
		 try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("---test---"+result.getName()+" skipped",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log("---test---"+result.getName()+" failed within success percentage",true);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		Reporter.log("---test---"+result.getName()+" failed with timeout",true);
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("---test---"+context.getName()+" is started",true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("---test---"+context.getName()+" finished",true);
	}

}
