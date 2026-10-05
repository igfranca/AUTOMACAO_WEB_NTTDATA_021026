package web.parte2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import web.parte2.pages.PageBag;
import web.parte2.pages.PageHome;
import web.parte2.pages.PageProduct;

import java.time.Duration;

public class TestBase2 {

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
  public void BuscarEValidarOProduto() throws InterruptedException {

    // Instâncias
    PageHome pageHome = new PageHome(driver);
    PageProduct pageProduct = new PageProduct(driver);
    PageBag pageBag = new PageBag(driver);

    //Acessar o site, aceitar os cookies e pesquisar o produto desejado
    pageHome.acessarOSite();
    pageHome.clicarNoBotaoCookie();
    pageHome.clicarNaPesquisaEdigitarItem("Escada Baw & Miaw Grafite para Cães e Gatos");

    //Buscar o preço do produto na página do produto e adicionar na sacola
    String precoProduto = pageProduct.pegarValorDoProduto();
    pageProduct.adcionarProdutoEIrSacola();

    //Buscar o preço do produto na página sacola
    String precoSacola = pageBag.pegarValorDoProdutoNaSacola();

    System.out.println("Preço do produto na página do produto: " + precoProduto);
    System.out.println("Preço do produto na página da sacola: " +  precoSacola);

    if (precoProduto.equals(precoSacola)) {
      System.out.println("Os valores da página do produto e página da sacola estão corretos");
    } else System.out.println("Os valores da página do produto e página da sacola não estão corretos");
  }

  @AfterClass
  public static void tearDownClass() {
    driver.quit();
  }
}
