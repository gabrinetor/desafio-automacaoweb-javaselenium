
## Desafio de Automação de Testes em Java
Este desafio trata-se de um teste de automação em java usando o Selenium WebDriver para testar o site , em padrão de projeto PageObjects em uma metodologia DDT (Data Driven Testing), e foram usadas as seguintes dependências Maven: 
	- JUnit Jupiter (JUnit 5);
	- Selenium Java;
	- Extent Report;
	- Java Faker;
	- Selenium Shutterbug (screenshot das evidências);
	- WebDriverManager;
	
	
Aqui são usadas convenções de pacotes, classes, atributos e métodos em português. 
O site que será testado será o Automation Practice (http://automationpractice.com), cujos testes se resumem apenas em validações e manipulações de alguns elementos. 


## Plano de Teste 
Em formato BDD (Behavior Driven Development).

**Funcionalidade** :  Realizar uma compra com sucesso

  - **Cenário 1** :  Acessar o site
  	Dado que acessa o site 'http://automationpractice.com'
        Quando der scroll na página até metade da página
        Então será localizado produto com desconto
	

  - **Cenário 2** :  Escolher produto na loja
        Dado que produto com desconto for localizado
	E solicitar produto 
	Quando clicar para adicionar ao carrinho 	
	Então preço no card será comparado ao preço apresentado no pop-up


  - **Cenário 3** :  Adicionar produto escolhido ao carrinho
	Dado que produto com desconto selecionado
	E solicitar apenas 1 produto 
	Quando clicar para adicionar ao carrinho 	
	E preço no card lateral será comparado com preço apresentado no pop-up
	E preço no card lateral será comparado com preço apresentado no carrinho do menu superior
 	Então botão para prosseguir ao checkout será clicado


  - **Cenário 4** :  Prosseguir para o checkout e validar se produto foi corretamente adicionado ao carrinho
	Dado que soma de compras é igual ao total de produtos
	Quando preço de envio somado ao preço total de produtos for igual ao total a ser pago
	E dados apresentados são iguais aos apresentados no carrinho do menu superior
	Então total a ser pago está correto


  - **Cenário 5** :  Realizar cadastro do cliente
	Dado usuário preenche campo de endereço de e-mail
	E clica para registrar e-mail
	Quando campos obrigatórios forem preenchidos: 
		título, nome, sobrenome, senha, data de nascimento, endereço, 
		cidade, estado, código postal, país e número de celular
	Então clicar para registrar


  - **Cenário 6** :  Validar se endereço está correto
	Dado endereço de entrega e de cobrança são apresentados na página de endereço
	Quando o Endereço de Entrega e o Endereço de Cobrança são o mesmo endereço
	Então clicar em botão para prosseguir


  - **Cenário 7** :  Aceitar os termos de serviço
	Dado que tela de envio apresenta valor adicional por envio 
	Quando clicar em termos de serviço abrirá pop-up 
	E selecionar para concordar com termos de serviço
	Então clicar em botão para prosseguir


  - **Cenário 8** :  Validar valor total da compra 
	Dado que tela de pagamento apresenta total a ser pago
	Quando localizar: 
		foto de produto, descrição, disponibilidade, preço unitário, quantidade e total de cada produto
	E soma dos produtos selecionados for igual ao total de produtos
	Então localizar total de produtos e total de envio


  - **Cenário 9** :  Selecionar método de pagamento por transferência bancária
	Dado mesma tela de pagamento apresenta total a ser pago
	Quando verificar se preço total é a soma do total de produtos com o total de envio
	Então selecionar forma de pagamento por transferência bancária


  - **Cenário 10** :  Confirmar a compra e finalizar
	Dado forma de pagamento está correta
	Quando verificar resumo da compra
	E confirmar compra 
 	Quando validar página de confirmação
	Então compra realizada com sucesso



## Fontes Extras 
https://www.selenium.dev/documentation/en/
https://www.browserstack.com/guide/selenium-with-java-for-automated-test
