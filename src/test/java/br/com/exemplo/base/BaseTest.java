package br.com.exemplo.base;

import br.com.exemplo.constants.BrowserType;
import br.com.exemplo.factory.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static WebDriverWait wait;

    protected static void setDriver(WebDriver driver){
        BaseTest.driver.set(driver);
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static WebDriverWait getDriverWait() {
        return wait;
    }

    @Parameters("browser")
    @BeforeTest
    public static void startDriver(@Optional String browser){
        setup(browser);
    }

    @AfterTest
    public static void quitDriver() throws IOException {
        teardown();
    }

    public static void setup(String browser){
        browser = browser == null ? "FIREFOX" : System.getProperty("browser",browser);
        setDriver(DriverManagerFactory.getManager(BrowserType.valueOf(browser)).createDriver());
        System.out.println("CURRENT THREAD:" + Thread.currentThread().getId());
        getDriver().manage().window().maximize();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
    }

    public static void teardown(){
        System.out.println("CURRENT THREAD:" + Thread.currentThread().getId());
        getDriver().quit();
    }
}
