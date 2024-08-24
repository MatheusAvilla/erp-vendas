Feature: Gestão de perfis

  Scenario: Criar um novo perfil
    Given Eu tento criar um perfil com o nome "MANAGER"
    Then O perfil "MANAGER" deve ser criado com sucesso