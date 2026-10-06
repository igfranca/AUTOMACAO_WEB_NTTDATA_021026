#encoding: utf-8
#language: pt

Funcionalidade: Comprar produto no site Petz

  @CenarioCompra
  Cenário: Validar o valor do produto no site Petz
    Dado que um usuário entra no site "https://www.petz.com.br/"
    Quando seleciona um produto com o nome "Escada Baw & Miaw Grafite para Cães e Gatos"
    E na página do produto capturo o preço do produto
    E adiciono o produto e envio para a sacola
    Então deverá verificar se estão corretos os valores do produto
