package CasosDeTeste;

import Suporte.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class AcessarSite extends TesteBase{

    private static WebDriver driver;

    @Test
    public void acessarSite() {

        TesteBase.getDriver();

        TesteBase.setUp();

    }

    @Test
    public void localizarProduto() {

            JavascriptExecutor js = (JavascriptExecutor) driver;

            driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

            if (js != null) { js.executeScript("scrollBy(0,1800)", ""); }

            driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);

            WebElement desconto = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[7]/div/div[2]/h5/a"));

            driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);

            js.executeScript("arguments[0].scrollIntoView();", desconto);

            driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);

            js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid red;');", desconto);

            driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);

            TesteBase.endDriver();

    }
}