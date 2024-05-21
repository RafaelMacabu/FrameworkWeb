![Logo Selenium](https://github.com/RafaelMacabu/ProjetoTheInternet/assets/127212296/2e68499e-8eb7-426f-912f-28ee2f9f91cc)

# Framework Front-end para testes web
Desenvolvida para servir como base para todos os meus tests web

## Tecnologias Usadas
* **Java** Versão 11 (Linguagem de código principal)
* **Selenium** (Automatização de páginas web)
* **Cucumber** (Criação de testes BDD)
* **TestNG** (Execução de classes de teste)
* **Allure** (Criação dos relatórios de teste)

## Como criar seus testes usando o framework

Obviamente,um conhecimento prévio da linguagem de programação *Java* e das ferramentas de automação citadas acima é recomendável para um uso flúido do framework de testes.

**Primeiros passos**

* Selecionar seu navegador para os testes
  
  O arquivo *testng.xml*,encontrado na pasta, base será o qual usaremos para rodar todos os nossos testes,então para decidirmos qual o navegador a ser utilizado iremos para a classe *Hooks* na pasta *stepdef*, nessa classe,no método *before* está sendo chamado outro método chamado *setup*, esse método aceita duas variáveis "FIREFOX" ou "CHROME",troque a variável conforme o navegador desejado,por padrão esse projeto usa o google chrome.

* Configurar a URL do site a ser testado

  Dentro de *test/resources* o arquivo *config.properties* tem apenas uma varíavel, a qual usaremos para configurar a URL base de nosso site,que será lida por outra classe dedicada para ser usada posteriormente em nossa *BasePage*.

* Criar as Pages respectivas de cada página do site a ser testado

  Crie uma page para cada página diferente a ser navegada no site, por exemplo, um site com uma página principal e uma página que você é direcionado após fazer uma busca poderia ser criado como 2 pages,HomePage e SearchPage,ambas extendendo nossa *BasePage*,a qual usamos para abstrair todos os métodos do Selenium,nessas pages,mapeie todos os elementos a serem interagidos,e crie todos os métodos para que seja feita a interação desejada com esses elementos,dentro do projeto tem um exemplo de uma page genérica para facilitar o entendimento.

* Crie as Features e as Step Definitions dessas features

  Para utilizarmos do *Cucumber* para a criação dos nossos testes BDD é necessário que seja criado as features a qual criaremos nossas user stories,após criado essas features,criaremos as step definitions que vão interagir com nosso código para realizar os testes de fato,ambas as features e as stepdefs também tem exemplos dentro do projeto.

* Rodando os testes

  Após todos esses passos necessários para a interação com o site desejado,podemos rodar os testes de duas formas: rodando o arquivo *testng.xml* pela nossa IDE de escolha,ou usando o plugin *Maven Surefire* para iniciar nossos testes pelo terminal, com o comando *mvn clean test*.

* Visualizando os relatórios

  Para que seja possível se visualizar os relatórios gerados pelo *Allure* é necessário que primeiro se faça a instalação do mesmo em sua maquina, um guia completo pode ser encontrado [**aqui**](https://allurereport.org/docs/install/).

  Após feita a instalação,verificar os relatórios gerados é um simples processo de abrir o terminal da pasta base do projeto,e enviar o comando *allure serve* caso queria só conferir os relatórios localmente,ou *allure generate* caso deseja gerar um arquivo do relatório.

  
