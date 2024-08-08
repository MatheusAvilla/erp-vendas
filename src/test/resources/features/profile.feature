Feature: Gestão de perfis

  Scenario: Criar um novo perfil
    Given Eu tento criar um perfil com o nome "GERENTE"
    Then O perfil "GERENTE" deve ser criado com sucesso