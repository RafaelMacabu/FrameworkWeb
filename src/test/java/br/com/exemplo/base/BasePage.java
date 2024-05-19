package br.com.exemplo.base;

import br.com.exemplo.utils.ConfigLoader;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static br.com.exemplo.base.BaseTest.getDriver;
import static br.com.exemplo.base.BaseTest.getDriverWait;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);

    }

    protected void writeText(WebElement element, String text) {
            waitProcessPage();
            getDriverWait()
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOf(element))
                    .sendKeys(text);
    }

    protected void clickElement(WebElement element) {
        try {
            waitProcessPage();
            getDriverWait()
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(element))
                    .click();
        } catch (ElementNotInteractableException e) {
            new Actions(getDriver())
                    .moveToElement(element)
                    .click()
                    .perform();
        } catch (WebDriverException e) {
            System.out.println("INTERAGIU COM JAVASCRIPT");
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    protected String getText(WebElement element) {
            waitProcessPage();
            return getDriverWait()
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOf(element))
                    .getText();
    }

    protected void clickElementLoop(WebElement element) {
        int tentativas = 0;
        do {
            try {
                Thread.sleep(1000);
                waitProcessPage();
                waitElementToBeClickable(element);
                clickElement(element);
                return;
            } catch (Exception ignored) {
            }
            tentativas++;
        } while (tentativas < 10);
    }

    public void scrollToElement(WebElement element) {
            waitProcessPage();
            waitElementToBeVisible(element);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView();", element);
    }

    protected void selectElement(WebElement element, int index) {
        waitProcessPage();
        Select lista = new Select(element);
        lista.selectByIndex(index);
    }

    protected boolean verifyIfElementIsPresent(WebElement element) {
        boolean valor = false;
        try {
            waitProcessPage();
            waitElementToBeVisible(element);
            valor = element.isDisplayed();
        } catch (Exception ignore) {
        }
        return valor;
    }

    protected void interactWithJavascript(String script){
        ((JavascriptExecutor) getDriver()).executeScript(script);
    }

    protected void hoverOverElement(WebElement element){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }

    protected void reloadPage() {
        waitProcessPage();
        getDriver().get(getDriver().getCurrentUrl());
        waitProcessPage();

        new BasePage(getDriver());
    }

    private void waitElementToBeClickable(WebElement webElement) {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
    }

    private void waitElementToBeVisible(WebElement... webElement) {
        getDriverWait().until(ExpectedConditions.visibilityOfAllElements(webElement));
    }

    private void waitProcessPage() {
        getDriverWait().until(waitProcess());
    }

    private ExpectedCondition<Boolean> waitProcess() {
        return driver -> {
            String js = "var reqAjax = typeof window.Ajax !== 'undefined' ? window.Ajax.activeRequestCount : 0;\n"
                    + "var reqAngular = typeof angular !== 'undefined' ? angular.by(document.body).injector().get('$http').pendingRequests.length : 0;\n"
                    + "var reqJquery = typeof jQuery !== 'undefined' ? jQuery.active : 0;\n"
                    + "var reqDom = document.readyState;\n" + "\n"
                    + "return (reqAjax + reqAngular + reqJquery === 0 && reqDom === 'complete');";

            return ((JavascriptExecutor) getDriver()).executeScript(js).equals(true);
        };
    }
}
