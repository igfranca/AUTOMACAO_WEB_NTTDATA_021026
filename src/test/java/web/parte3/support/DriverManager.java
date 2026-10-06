package web.parte3.support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverManager {

  public static WebDriver driver;

  public static WebDriver getDriver() {
    return driver;
  }

  public static void initDriver() {
    WebDriverManager.chromedriver().setup(); //Instanciar o setup do Chrome Driver por bonigarcia
    ChromeOptions options = new ChromeOptions(); //Instanciar o Chrome Options
//    options.addArguments("--force-device-scale-factor=0.9"); //Diminuir a escala dá página
    driver = new ChromeDriver(options); //Instanciar Chrome Driver
    driver.manage().window().maximize(); //Maximizar a tela
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //Espera implícita 20 segundos
  }

  public static void quitDriver() {
    if (driver != null) {
      driver.quit();
    }
  }
}