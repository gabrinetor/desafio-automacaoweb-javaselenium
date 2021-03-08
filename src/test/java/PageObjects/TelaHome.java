package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TelaHome {

    private static WebDriver driver;
    private static By descontoProduto = By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[5]/div/div[2]/div[1]/span[3]");
    private static By descontoProduto1 = By.className("price-percent-reduction");
    static WebElement campoPesquisa = driver.findElement(By.id("search_query_top"));
    static WebElement campoPesquisa1 = driver.findElement(By.name("search_query"));
//    campoPesquisa1.sendKey("Printed Chiffon Dress");
    static WebElement botaoPesquisar = driver.findElement(By.name("submit_search"));
}
