package Suporte;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SegundaParteDoTeste {

    private static WebDriver driver;

    @Test
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();    //montar driver para abrir navegador

        ChromeOptions navegador = new ChromeOptions();  //objeto para estanciar opção navegador chrome

        navegador.addArguments("--start-maximized");    //maximizar janela do browser

        driver = new ChromeDriver(navegador);   //objeto istanciado com navegador escolhido

        driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0");

        driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);

        System.out.println(driver.getTitle());  //mostrar título do site

        JavascriptExecutor js = (JavascriptExecutor) driver;    //javaexecutor para criar highligh

        js.executeScript("window.scrollBy(0,300)");

        WebElement campoEmail = driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
        WebElement botaoCriarConta = driver.findElement(By.id("SubmitCreate"));
        WebElement titular = driver.findElement(By.id("id_gender2"));
        WebElement nome = driver.findElement(By.id("customer_firstname"));
        WebElement sobreNome = driver.findElement(By.id("customer_lastname"));
        WebElement senha = driver.findElement(By.id("passwd"));
        WebElement endereco = driver.findElement(By.id("address1"));
        WebElement cidade = driver.findElement(By.id("city"));
        WebElement cep = driver.findElement(By.id("postcode"));
        WebElement celular = driver.findElement(By.id("phone_mobile"));
        WebElement botaoRegistrar = driver.findElement(By.id("submitAccount"));

        Select diaNasc = new Select(driver.findElement(By.id("days")));
        Select mesNasc = new Select(driver.findElement(By.id("months")));
        Select anoNasc = new Select(driver.findElement(By.id("years")));
        Select estado = new Select(driver.findElement(By.id("id_state")));

        //Actions action = new Actions(driver);
        //action.doubleClick(btnElement).build().perform();

        try{
            campoEmail.click();
            driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
            campoEmail.sendKeys("lala2@gmail.com");
            botaoCriarConta.click();
            driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);

        }catch(Exception e){}

        titular.click();
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);

        nome.sendKeys("karolkomka");
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);

        sobreNome.sendKeys("mikka");
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);
        senha.sendKeys("975319");
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);

//        diaNasc.selectByVisibleText();
        diaNasc.selectByIndex(4);
        mesNasc.selectByIndex(11);
        anoNasc.selectByIndex(1999);
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);

        endereco.sendKeys("loiortuyt");
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);
        cidade.sendKeys("oiwa");
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);

        estado.selectByIndex(5);

        cep.sendKeys("12345");
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);
        celular.sendKeys("12345678");
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);

        botaoRegistrar.click();

        //comparar só os endereços que é importante
        String enderecoEntrega = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[4]")).getText();
        String enderecoCobranca = driver.findElement(By.xpath("//*[@id=\"address_invoice\"]/li[4]")).getText();

        driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);

        assertEquals(enderecoEntrega, enderecoCobranca);
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);

        js.executeScript("window.scrollBy(0,880)");
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);

        WebElement botaoEndProcess = driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button"));

        botaoEndProcess.click();

        driver.findElement(By.className("iframe")).click();
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"order\"]/div[2]/div/div/a")).click();
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);
        driver.findElement(By.name("cgv")).click(); //clicar em aceitar termos
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);

        WebElement botaoTransportProcess = driver.findElement(By.name("processCarrier"));

        WebElement precoTotalUnitario = driver.findElement(By.id("total_product_price_7_34_460305"));
        WebElement precoUnitarioTotal = driver.findElement(By.id("total_product"));
        WebElement precoFrete = driver.findElement(By.id("total_shipping"));
        WebElement precoSomaTotal = driver.findElement(By.id("total_price"));
        WebElement transferBancaria = driver.findElement(By.className("bankwire"));

        transferBancaria.click();
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);

        WebElement tabConfirm = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/div"));
        js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid blue;');", tabConfirm);
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);

        WebElement botaoConfirmar = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button"));
        botaoConfirmar.click();
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);

        WebElement compraConfirmada = driver.findElement(By.className("box"));
        js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", compraConfirmada);

    }
}
