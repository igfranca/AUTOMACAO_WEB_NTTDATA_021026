package web.parte3.support;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.parte3.hooks.Hooks;

public class ActionEvidenceUtil {
  private ActionEvidenceUtil() {
  }

  public static void logAction(WebDriver driver, String description) {
    ExtentTest currentTest = Hooks.getCurrentTest();
    if (currentTest != null) {
      currentTest.log(Status.PASS, description, ScreenshotUtil.capture(driver));
    }
  }

  public static void click(WebDriver driver, By locator, String description) {
    WebElement element = driver.findElement(locator);
    highlightAndLog(driver, element, description);
    element.click();
  }

  public static void type(WebDriver driver, By locator, CharSequence value, String description) {
    WebElement element = driver.findElement(locator);
    highlightAndLog(driver, element, description);
    element.sendKeys(value);
  }

  public static String getText(WebDriver driver, By locator, String description) {
    WebElement element = driver.findElement(locator);
    highlightAndLog(driver, element, description);
    return element.getText();
  }

  private static void highlightAndLog(WebDriver driver, WebElement element, String description) {
    String originalStyle = element.getAttribute("style");

    if (driver instanceof JavascriptExecutor) {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript(
          "arguments[0].setAttribute('style', arguments[1] + '; border: 3px solid red; box-shadow: 0 0 0 3px rgba(255,0,0,0.35);');",
          element,
          originalStyle == null ? "" : originalStyle
      );
    }

    logAction(driver, description);

    if (driver instanceof JavascriptExecutor) {
      ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle == null ? "" : originalStyle);
    }
  }
}
