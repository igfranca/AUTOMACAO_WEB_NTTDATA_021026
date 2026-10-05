package web.parte2.pages;

import org.openqa.selenium.WebDriver;
import web.parte2.attributes.AttributesProduct;

public class PageProduct extends AttributesProduct {

  private WebDriver driver;

  public PageProduct(WebDriver getDriver) {
    this.driver = getDriver;
  }

  public String pegarValorDoProduto() {
    return driver.findElement(valorProdutoPaginaProduto).getText();
  }

  public void adcionarProdutoEIrSacola(){
    driver.findElement(adicionarProduto).click();
    driver.findElement(irSacola).click();
  }
}
