
## Desafio de Automação de Testes em Java
Este desafio trata-se de um teste de automação em java usando o Selenium WebDriver para testar o site , em padrão de projeto PageObjects em uma metodologia DDT (Data Driven Testing), e foram usadas as seguintes dependências Maven: <br>
	<p><p>- JUnit Jupiter (JUnit 5); <br>
	<p><p>- Selenium Java;<br>
	<p><p>- Extent Report;<br>
	<p><p>- Java Faker;<br>
	<p><p>- Selenium Shutterbug (screenshot das evidências);<br>
	<p><p>- WebDriverManager;
	<br>
	
Aqui são usadas convenções de pacotes, classes, atributos e métodos em português. 
O site que será testado será o Automation Practice (http://automationpractice.com), cujos testes se resumem apenas em validações e manipulações de alguns elementos. 
<br><br>

## Plano de Teste 
Em formato BDD (Behavior Driven Development).

**Funcionalidade** :  Realizar uma compra com sucesso

  - **Cenário 1** :  Acessar o site <br>
  	<p>Dado que acessa o site 'http://automationpractice.com' <br>
        <p>Quando der scroll na página até metade da página <br>
        <p>Então será localizado produto com desconto 
	

  - **Cenário 2** :  Escolher produto na loja <br>
        <p>Dado que produto com desconto for localizado <br>
	<p>E solicitar produto <br>
	<p>Quando clicar para adicionar ao carrinho <br> 	
	<p>Então preço no card será comparado ao preço apresentado no pop-up 


  - **Cenário 3** :  Adicionar produto escolhido ao carrinho <br>
	<p>Dado que produto com desconto selecionado <br>
	<p>E solicitar apenas 1 produto <br>
	<p>Quando clicar para adicionar ao carrinho <br> 	
	<p>E preço no card lateral será comparado com preço apresentado no pop-up <br>
	<p>E preço no card lateral será comparado com preço apresentado no carrinho do menu superior <br>
 	<p>Então botão para prosseguir ao checkout será clicado 


  - **Cenário 4** :  Prosseguir para o checkout e validar se produto foi corretamente adicionado ao carrinho <br>
	<p>Dado que soma de compras é igual ao total de produtos <br>
	<p>Quando preço de envio somado ao preço total de produtos for igual ao total a ser pago <br>
	<p>E dados apresentados são iguais aos apresentados no carrinho do menu superior <br>
	<p>Então total a ser pago está correto 


  - **Cenário 5** :  Realizar cadastro do cliente <br>
	<p>Dado usuário preenche campo de endereço de e-mail <br>
	<p>E clica para registrar e-mail <br>
	<p>Quando campos obrigatórios forem preenchidos: <br>
	<p><p>	título, nome, sobrenome, senha, data de nascimento, endereço, 
		cidade, estado, código postal, país e número de celular <br>
	<p>Então clicar para registrar 


  - **Cenário 6** :  Validar se endereço está correto <br>
	<p>Dado endereço de entrega e de cobrança são apresentados na página de endereço <br>
	<p>Quando o Endereço de Entrega e o Endereço de Cobrança são o mesmo endereço <br>
	<p>Então clicar em botão para prosseguir 


  - **Cenário 7** :  Aceitar os termos de serviço <br>
	<p>Dado que tela de envio apresenta valor adicional por envio <br>
	<p>Quando clicar em termos de serviço abrirá pop-up <br>
	<p>E selecionar para concordar com termos de serviço <br>
	<p>Então clicar em botão para prosseguir


  - **Cenário 8** :  Validar valor total da compra <br>
	<p>Dado que tela de pagamento apresenta total a ser pago <br>
	<p>Quando localizar: <br>
	<p><p>	foto de produto, descrição, disponibilidade, preço unitário, quantidade e total de cada produto <br>
	<p>E soma dos produtos selecionados for igual ao total de produtos <br>
	<p>Então localizar total de produtos e total de envio 


  - **Cenário 9** :  Selecionar método de pagamento por transferência bancária <br>
	<p>Dado mesma tela de pagamento apresenta total a ser pago <br>
	<p>Quando verificar se preço total é a soma do total de produtos com o total de envio <br>
	<p>Então selecionar forma de pagamento por transferência bancária


  - **Cenário 10** :  Confirmar a compra e finalizar <br>
	<p>Dado forma de pagamento está correta <br>
	<p>Quando verificar resumo da compra <br>
	<p>E confirmar compra <br>
 	<p>Quando validar página de confirmação <br>
	<p>Então compra realizada com sucesso

<br><br>

## Fontes Extras 
https://www.selenium.dev/documentation/en/ <br>
https://www.browserstack.com/guide/selenium-with-java-for-automated-test
