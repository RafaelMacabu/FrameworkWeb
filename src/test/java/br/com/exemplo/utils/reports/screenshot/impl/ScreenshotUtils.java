package br.com.exemplo.utils.reports.screenshot.impl;

import org.openqa.selenium.*;

public class ScreenshotUtils {
    private final static String JS_HIGHLITH = "arguments[%d].setAttribute('style', 'border: 4px solid green!important');arguments[%d].focus();arguments[%d].scrollIntoView(true);";
    private final static String JS_UNDO = "arguments[%d].setAttribute('style', '%2$s');";

    public static byte[] screenshot(WebDriver webdriver) {
        return ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES);
    }

    public static Object executeJavaScript(WebDriver webdriver, String javaScript, WebElement... webElement)  {
        JavascriptExecutor jse = ((JavascriptExecutor) webdriver);
        return jse.executeScript(javaScript, (Object[]) webElement);
    }

    public static String getJavaScriptHighlight(WebDriver webdriver, WebElement... webElement) {
        StringBuilder js = new StringBuilder();
        for (int i = 0; i < webElement.length; i++) {
            if (webElement[i].getText() != null)
                js.append(String.format(JS_HIGHLITH, i, i, i));
        }
        return js.toString();
    }

    public static String getJavaScriptUnHighlight(WebDriver webdriver, WebElement... webElement) {
        StringBuilder js = new StringBuilder();

        for (int i = 0; i < webElement.length; i++) {
            if (webElement.toString() != null)
                js.append(String.format(JS_UNDO, i, webElement[i].getAttribute("style")));
        }
        return js.toString();
    }
}
