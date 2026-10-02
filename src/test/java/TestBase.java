import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestBase {

  private static WebDriver driver;

  @BeforeClass
  public static void setUpClass() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }

  @Test
  public void testeModelo() throws InterruptedException {

    driver.get("https://www.petz.com.br/");
    driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/button[2]")).click();
    Thread.sleep(2000);

    //Abrir Search, digitar o item desejado e apertar Enter
    driver.findElement(By.id("headerSearch")).sendKeys("Escada Baw & Miaw Grafite para Cães e Gatos" + Keys.ENTER);

    driver.findElement(By.xpath("//*[@id='card-10037090002670']/div/div[3]/a/div[2]/p")).click();






  }



}
