package web.parte3.hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import web.parte3.support.DriverManager;
import web.parte3.support.ExtentReportManager;
import web.parte3.support.ScreenshotUtil;

public class Hooks {
  private static final ExtentReports extent = ExtentReportManager.getInstance();
  public static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

  @Before()
  public void beforeScenario(Scenario scenario) {
    DriverManager.initDriver();
    ExtentTest extentTest = extent.createTest(scenario.getName());
    extentTest.assignCategory(scenario.getSourceTagNames().toString());
    test.set(extentTest);
  }

  @After()
  public void afterScenario(Scenario scenario) {
    try {
      ExtentTest currentTest = test.get();
      if (currentTest != null) {
        if (scenario.isFailed()) {
          currentTest.log(Status.FAIL,
              "Cenário falhou: " + scenario.getName(),
              ScreenshotUtil.capture(DriverManager.getDriver()));
        } else {
          currentTest.log(Status.PASS, "Cenário passou com sucesso!");
        }
      }
    } finally {
      DriverManager.quitDriver();
      test.remove();
      extent.flush();
    }
  }

  public static ExtentTest getCurrentTest() {
    return test.get();
  }
}
