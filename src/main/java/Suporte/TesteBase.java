package Suporte;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TesteBase {

    private static WebDriver driver;    //objeto driver protegido e unico, e pode ser chamado sem que WebDriver seja istanciado em um objeto
    private static String URL = "http://automationpractice.com";

    //Pegar driver para retornar o valor
    public static WebDriver getDriver() {

        if(driver == null){
            WebDriverManager.chromedriver().setup();
            ChromeOptions navegadorChrome = new ChromeOptions();
            navegadorChrome.addArguments("--start-maximized");
            driver = new ChromeDriver(navegadorChrome);
        }
        return driver;

    }

    @BeforeEach
    public static void setUp() {
        driver.get(URL);
    }

    @AfterEach
    public static void endDriver(){
        driver.close();
        driver.quit();
    }

}