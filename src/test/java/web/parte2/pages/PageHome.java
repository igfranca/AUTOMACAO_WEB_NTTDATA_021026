package web.parte2.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import web.parte2.attributes.AttributesHome;

public class PageHome extends AttributesHome {

  private WebDriver driver;

  public PageHome(WebDriver getDriver) {
    this.driver = getDriver;
  }

  public void acessarOSite() {
    driver.get("https://www.petz.com.br/");
  }

  public void clicarNoBotaoCookie() throws InterruptedException {
    driver.findElement(botaoCookie).click();
    Thread.sleep(2000);
  }

  public void clicarNaPesquisaEdigitarItem(String oQueBuscar) {
    driver.findElement(campoBusca).sendKeys(oQueBuscar + Keys.ENTER);
    driver.findElement(itemSelecionado).click();
  }
}
