Feature: API de Produtos

  Como usuário da API
  Quero criar e consultar produtos
  Para garantir que a API esteja funcionando corretamente


  Scenario: Criar produto com sucesso

    Given que possuo os dados de um novo produto
    When envio uma requisição POST para criar o produto
    Then o status da resposta deve ser 201
    And o campo "id" deve estar preenchido
    And o campo "title" deve ser "Hyaluronic Acid Serum"
    And o campo "price" deve ser 19
    And o campo "stock" deve ser 110


  Scenario: Criar produto sem ID

    Given que possuo um produto sem o campo "id"
    When envio uma requisição POST para criar o produto
    Then o campo obrigatório "id" deve estar ausente da requisição


  Scenario: Criar produto sem título

    Given que possuo um produto sem o campo "title"
    When envio uma requisição POST para criar o produto
    Then o campo obrigatório "title" deve estar ausente da requisição


  Scenario: Consultar produto por ID

    Given que existe um produto com ID 1
    When envio uma requisição GET para consultar o produto
    Then o status da resposta deve ser 200
    And o campo "id" deve ser 1
    And o campo "title" deve ser "Essence Mascara Lash Princess"
