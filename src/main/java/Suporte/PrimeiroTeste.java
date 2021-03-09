package Suporte;

import org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimeiroTeste {

    private static WebDriver driver;    //objeto driver protegido e unico, e pode ser chamado sem que WebDriver seja istanciado em um objeto
    private static Wait wait;

    @Test
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();    //montar driver para abrir navegador

        ChromeOptions navegador = new ChromeOptions();  //objeto para estanciar opção navegador chrome

        navegador.addArguments("--start-maximized");    //maximizar janela do browser

        driver = new ChromeDriver(navegador);   //objeto istanciado com navegador escolhido

        driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com");   //acessar site

        driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);

        System.out.println(driver.getTitle());  //mostrar título do site

        driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);

        WebElement elemento = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[7]/div/div[2]/div[1]/span[3]"));  //elemento mapeado

        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;    //javaexecutor para criar highligh

        driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);

        js.executeScript("window.scrollBy(0,1200)");

        //js.executeScript("arguments[0].scrollIntoView();", elemento);

        driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);

        js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid red;');", elemento); //Highlight para localizar elemento

        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);

        elemento.click();

        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

        WebElement desconto = driver.findElement(By.id("reduction_percent_display"));  //elemento mapeado
        WebElement botaoSolicitar = driver.findElement(By.name("Submit"));
        String precoUnitCardLateral = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[1]/div[1]/p[1]/span")).getText();
        String precoUnitCardPopup = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[1]/span")).getText();

        if (desconto.isEnabled()) {
            System.out.println("Produto com desconto localizado");
            js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid blue;');", desconto);
            driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
            botaoSolicitar.click();



        } else {
            System.out.println("Desconto não disponível");
            driver.quit();
        }

        //Validar se valor no card é o mesmo do pop-up
        //Bug1: Exception in thread "main" org.opentest4j.AssertionFailedError: expected: <$16.40> but was: <>
        assertEquals(precoUnitCardLateral, precoUnitCardPopup);

        //Botão prosseguir Checkout
        //WebElement btProssegCheckout = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span/text()"));
        //driver.switchTo().window("Product successfully added to your shopping cart");

        WebElement btProssegCheckout = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a"));
        driver.switchTo().frame(btProssegCheckout);

        //new WebDriverWait(driver, 3).until(ExpectedConditions.invisibilityOf(btProssegCheckout));
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        //driver.switchTo().activeElement();

        //WebElement btProssegCheckout = wait

        js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid red;');", btProssegCheckout);
        //btProssegCheckout.click();

        //Validar tela resumo
        /*WebElement colProduto = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[1]/a/img"));
        WebElement colDescricao = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[2]"));
        WebElement colDisponibil = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[3]"));
        WebElement colPrecoUnit = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[4]"));
        WebElement colQuantd = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[5]"));
        WebElement colTotal = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[6]"));
        WebElement precoTotalResumo = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tfoot/tr[6]/td[2]"));
        WebElement tabelaTotalResumo = driver.findElement(By.id("order-detail-content"));

        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid red;');", colProduto);
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid red;');", colDescricao);
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid red;');", colDisponibil);
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid red;');", colPrecoUnit);
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid red;');", colQuantd);
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid red;');", colTotal);
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid red;');", precoTotalResumo);
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid red;');", tabelaTotalResumo);
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);*/

    /*    try{
            Assert.assertEquals(precoUnitProd1, precoUnitProd2);
            System.out.println("Os preços comparados são o mesmo :)");
        }catch(Exception e){
            System.out.println("Não é o mesmo preço unitário de produto");
        }finally {
            System.out.println("Fim :)");
        }*/

 //       if(Assert.assertEquals(precoUnitProd1, precoUnitProd2)){
 //           System.out.println("sucesso");
 //       }

        //driver.quit();   //encerrar o navegador, a sessão

    }

}