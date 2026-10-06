package web.parte3.steps;

import com.aventstack.extentreports.Status;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import web.parte3.hooks.Hooks;
import web.parte3.pages.PageBag;
import web.parte3.pages.PageHome;
import web.parte3.pages.PageProduct;
import web.parte3.support.ActionEvidenceUtil;
import web.parte3.support.DriverManager;

import static org.junit.Assert.assertEquals;

public class RunSteps {

  private String precoProdutoPagina;
  private String precoProdutoSacola;

  @Dado("que um usuário entra no site {string}")
  public void queUmUsuarioEntraNoSite(String url) throws InterruptedException {
    PageHome home = new PageHome(DriverManager.getDriver());
    home.acessarOSite();
    home.clicarNoBotaoCookie();
  }

  @Quando("seleciona um produto com o nome {string}")
  public void queSelecionaUmProdutoComONome(String produto) {
    PageHome home = new PageHome(DriverManager.getDriver());
    home.clicarNaPesquisaEDigitarItem(produto);
  }

  @E("na página do produto capturo o preço do produto")
  public void naPaginaDoProdutoCapturoOPrecoDoProduto() {
    precoProdutoPagina = new PageProduct(DriverManager.driver).pegarValorDoProduto();
  }

  @E("adiciono o produto e envio para a sacola")
  public void adicionoOProdutoEEnvioParaASacola() {
    new PageProduct(DriverManager.driver).adicionarProdutoEIrParaASacola();
  }

  @Então("deverá verificar se estão corretos os valores do produto")
  public void deveraVerificarSeEstaoCorretosOsValoresDoProduto() {
    precoProdutoSacola = new PageBag(DriverManager.driver).pegarValorDoProdutoNaSacola();

    System.out.println("Preço do produto na página do produto: " + precoProdutoPagina);
    System.out.println("Preço do produto na página da sacola: " +  precoProdutoSacola);

    assertEquals("O preço na página do produto deve ser igual ao preço na sacola",
        precoProdutoPagina, precoProdutoSacola);
    System.out.println("Os valores da página do produto e página da sacola estão corretos");
    Hooks.getCurrentTest().log(Status.PASS,
        "Validação: os valores da página do produto e da sacola estão corretos");
    ActionEvidenceUtil.logAction(DriverManager.getDriver(), "Evidência final da validação de preço");
  }
}
