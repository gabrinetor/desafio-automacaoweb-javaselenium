package Suporte;

import org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;

public class PrimeiroTeste {

    private static WebDriver driver;    //objeto driver protegido e unico, e pode ser chamado sem que WebDriver seja istanciado em um objeto

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();    //montar driver para abrir navegador

        ChromeOptions navegador = new ChromeOptions();  //objeto para estanciar opção navegador chrome

        navegador.addArguments("--start-maximized");    //maximizar janela do browser

        driver = new ChromeDriver(navegador);   //objeto istanciado com navegador escolhido

        driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com");   //acessar site

        driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);

        //System.out.println(driver.getTitle());  //mostrar título do site

        driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);

        WebElement elemento = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[7]/div/div[2]/div[1]/span[3]"));  //elemento mapeado

        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;    //javaexecutor para criar highligh

        driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);

        js.executeScript("window.scrollBy(0,1000)");

        driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);

        js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid red;');", elemento); //Highlight para localizar elemento

        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);

        elemento.click();

        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

        WebElement desconto = driver.findElement(By.id("reduction_percent_display"));  //elemento mapeado
        WebElement botaoSolicitar = driver.findElement(By.name("Submit"));

        if (desconto.isEnabled()) {
            System.out.println("Produto com desconto localizado");
            js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid blue;');", desconto);
            driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
            botaoSolicitar.click();
        } else {
            System.out.println("Desconto não disponível");
            driver.quit();
        }

        WebElement precoCardLateral = driver.findElement(By.id("our_price_display"));
//        WebElement cardLateral = driver.findElement(By.linkText());

        WebElement precoUnitProd1 = driver.findElement(By.id("layer_cart_product_price"));
        WebElement precoUnitProd2 = driver.findElement(By.className("ajax_block_products_total"));

       // js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid red;');", precoUnitProd1); //Highlight para localizar elemento
  //      js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid red;');", precoUnitProd2); //Highlight para localizar elemento

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