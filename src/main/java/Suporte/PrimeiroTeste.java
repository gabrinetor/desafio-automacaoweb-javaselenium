package Suporte;

import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
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

        driver.get("https://www.google.com");   //acessar site

        driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);

        WebElement elemento = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img"));  //elemento mapeado

        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;    //javaexecutor para criar highligh

        driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);

        js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid red;');", elemento); //Highlight para localizar elemento

        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);

        System.out.println(driver.getTitle());  //mostrar título do site

        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

        driver.quit();   //encerrar o navegador, a sessão

    }

}