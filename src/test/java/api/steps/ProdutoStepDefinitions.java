package api.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class ProdutoStepDefinitions {

  private static final String BASE_URL = "https://dummyjson.com";

  private Response response;
  private String requestBody;

  @Given("que possuo os dados de um novo produto")
  public void quePossuoOsDadosDeUmNovoProduto() {
    requestBody = "{\n"
        + "  \"id\": 195,\n"
        + "  \"title\": \"Hyaluronic Acid Serum\",\n"
        + "  \"price\": 19,\n"
        + "  \"discountPercentage\": 13.31,\n"
        + "  \"stock\": 110,\n"
        + "  \"rating\": 4.83,\n"
        + "  \"images\": [\n"
        + "    \"https://i.dummyjson.com/data/products/16/1.png\",\n"
        + "    \"https://i.dummyjson.com/data/products/16/2.webp\",\n"
        + "    \"https://i.dummyjson.com/data/products/16/3.jpg\",\n"
        + "    \"https://i.dummyjson.com/data/products/16/4.jpg\",\n"
        + "    \"https://i.dummyjson.com/data/products/16/thumbnail.jpg\"\n"
        + "  ],\n"
        + "  \"thumbnail\": \"https://i.dummyjson.com/data/products/16/thumbnail.jpg\",\n"
        + "  \"description\": \"L'Oréal Paris introduces Hyaluron Expert Replumping Serum formulated with 1.5% Hyaluronic Acid\",\n"
        + "  \"brand\": \"L'Oreal Paris\",\n"
        + "  \"category\": \"skincare\"\n"
        + "}";
  }

  @When("envio uma requisição POST para criar o produto")
  public void envioUmaRequisicaoPostParaCriarOProduto() {
    assertNotNull("O corpo da requisição deve ser preparado antes do POST", requestBody);
    RestAssured.baseURI = BASE_URL;
    response = given()
        .contentType("application/json")
        .body(requestBody)
        .when()
        .post("/products/add")
        .then()
        .extract()
        .response();
  }

  @Then("o status da resposta deve ser {int}")
  public void validarStatus(Integer statusEsperado) {
    assertNotNull("A resposta deve existir", response);
    assertEquals("O status HTTP não corresponde ao esperado",
        statusEsperado.intValue(), response.getStatusCode());
  }

  @Then("o campo {string} deve estar preenchido")
  public void oCampoDeveEstarPreenchido(String campo) {
    assertNotNull("A resposta deve existir", response);
    response.then().body(campo, notNullValue());
  }

  @Then("o campo {string} deve ser {string}")
  public void oCampoDeveSer(String campo, String valorEsperado) {
    assertNotNull("A resposta deve existir", response);
    response.then().body(campo, equalTo(valorEsperado));
  }

  @Then("o campo {string} deve ser {int}")
  public void oCampoDeveSerInteiro(String campo, Integer valorEsperado) {
    assertNotNull("A resposta deve existir", response);
    response.then().body(campo, equalTo(valorEsperado));
  }

  @Given("que possuo um produto sem o campo {string}")
  public void quePossuoUmProdutoSemOCampo(String campo) {
    if ("id".equals(campo)) {
      requestBody = "{\n"
          + "  \"title\": \"Hyaluronic Acid Serum\",\n"
          + "  \"price\": 19,\n"
          + "  \"discountPercentage\": 13.31,\n"
          + "  \"stock\": 110,\n"
          + "  \"rating\": 4.83,\n"
          + "  \"category\": \"skincare\"\n"
          + "}";
    } else if ("title".equals(campo)) {
      requestBody = "{\n"
          + "  \"id\": 195,\n"
          + "  \"price\": 19,\n"
          + "  \"discountPercentage\": 13.31,\n"
          + "  \"stock\": 110,\n"
          + "  \"rating\": 4.83,\n"
          + "  \"category\": \"skincare\"\n"
          + "}";
    } else {
      throw new IllegalArgumentException("Campo não suportado: " + campo);
    }
  }

  @Then("o campo obrigatório {string} deve estar ausente da requisição")
  public void oCampoObrigatorioDeveEstarAusenteDaRequisicao(String campo) {
    assertNotNull("O corpo da requisição deve ter sido preparado", requestBody);
    String campoJson = "\"" + campo + "\"";
    assertFalse("O campo '" + campo + "' deveri estar ausente do JSON",
        requestBody.contains(campoJson));
  }

  @Given("que existe um produto com ID {int}")
  public void queExisteUmProdutoComID(Integer id) {
    RestAssured.baseURI = BASE_URL;
    response = given()
        .when()
        .get("/products/" + id)
        .then()
        .extract()
        .response();
  }

  @When("envio uma requisição GET para consultar o produto")
  public void envioUmaRequisicaoGETParaConsultarOProduto() {
    assertNotNull("A resposta da consult deve existir", response);
  }
}
