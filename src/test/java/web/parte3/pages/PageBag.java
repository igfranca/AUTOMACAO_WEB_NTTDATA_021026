package web.parte3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.parte3.attibutes.AttributesBag;
import web.parte3.support.ActionEvidenceUtil;

import java.time.Duration;

public class PageBag extends AttributesBag {
  private WebDriver driver;
  private final WebDriverWait wait;

  public PageBag(WebDriver getDriver) {
    this.driver = getDriver;
    this.wait = new WebDriverWait(getDriver, Duration.ofSeconds(20));
  }
  public String pegarValorDoProdutoNaSacola() {
    return ActionEvidenceUtil.getText(driver, valorProdutoPaginaSacola, "Ação: capturar preço na página da sacola");
  }
}
