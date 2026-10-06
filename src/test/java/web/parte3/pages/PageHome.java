package web.parte3.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.parte3.attibutes.AttributesHome;
import web.parte3.support.ActionEvidenceUtil;

import java.time.Duration;

public class PageHome extends AttributesHome {

  private WebDriver driver;
  private final WebDriverWait wait;

  public PageHome(WebDriver getDriver) {
    this.driver = getDriver;
    this.wait = new WebDriverWait(getDriver, Duration.ofSeconds(20));
  }

  public void acessarOSite() {
    driver.get("https://www.petz.com.br/");
    ActionEvidenceUtil.logAction(driver, "Ação: acessar o site https://www.petz.com.br/");
  }

  public void clicarNoBotaoCookie() throws InterruptedException {
    ActionEvidenceUtil.click(driver, botaoCookie, "Clique: botão de cookies");
    Thread.sleep(2000);
  }

  public void clicarNaPesquisaEDigitarItem(String oQueBuscar) {
    ActionEvidenceUtil.type(driver, campoBusca, oQueBuscar + Keys.ENTER, "Ação: pesquisar produto - " + oQueBuscar);
    ActionEvidenceUtil.click(driver, itemSelecionado, "Clique: selecionar item pesquisado");
  }
}