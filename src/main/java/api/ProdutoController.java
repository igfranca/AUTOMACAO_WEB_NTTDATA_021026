package api;

public class ProdutoController {

  private final ProdutoService produtoService;

  public ProdutoController() {
    this.produtoService = new ProdutoService();
  }

  public String getBaseUrl() {
    return produtoService.getBaseUrl();
  }
}
