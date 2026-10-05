package web.parte2.pages;

import org.openqa.selenium.WebDriver;
import web.parte2.attributes.AttributesBag;

public class PageBag extends AttributesBag {

  private WebDriver driver;

  public PageBag(WebDriver getDriver) {
    this.driver = getDriver;
  }

  public String pegarValorDoProdutoNaSacola(){
    return driver.findElement(valorProdutoPaginaSacola).getText();
  }
}
