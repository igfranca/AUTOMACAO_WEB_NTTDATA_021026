import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
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

    // Ir para o site:
    driver.get("https://www.petz.com.br/");
    driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/button[2]")).click();
    Thread.sleep(2000);

    // Selecionar o produto:
    driver.findElement(By.id("headerSearch")).sendKeys("Escada Baw & Miaw Grafite para Cães e Gatos" + Keys.ENTER);

    // Salvar a tela do produto e adicionar o produto na sacola:
    driver.findElement(By.xpath("//*[@id='card-10037090002670']/div/div[3]/a/div[2]/p")).click();
    String valorDoProdutoScacola = driver.findElement(By.xpath("//*[@id='ecom-produto-price-default']/p[1]")).getText();
    System.out.println("Valor do produto na sacola: " + valorDoProdutoScacola);

    driver.findElement(By.xpath("/html/body/main/div[1]/section[1]/div[2]/aside/div[4]/div/button/span/strong")).click();
    driver.findElement(By.xpath("/html/body/div[15]/div/div[2]/div[3]/div[2]/button/span/strong")).click();

    String valorDoProdutoCarrinho = driver.findElement(By.xpath("//*[@id='resumeValues']/div[2]/div[2]/div[2]/div")).getText();
    System.out.println("Valor do produto no carrinho: " + valorDoProdutoCarrinho);
  }

  @AfterClass
  public static void tearDownClass() {
    driver.quit();
  }
}
