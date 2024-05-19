package br.com.exemplo.utils.reports.screenshot.impl;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UntilScreenshot {
    public static IScreenshot<byte[]> screenshotWeb(final WebDriver webdriver) {
        return new IScreenshot<byte[]>() {
            @Override
            public byte[] apply(Object input) {
                return ScreenshotUtils.screenshot(webdriver);
            }
        };
    }

    public static IScreenshot<byte[]> screenshotWeb(final WebDriver webdriver, final WebElement... webElement) {
        return new IScreenshot<byte[]>() {
            @Override
            public byte[] apply(Object input) {
                String jsHighlight = ScreenshotUtils.getJavaScriptHighlight(webdriver, webElement);
                String jsUnHighlight = ScreenshotUtils.getJavaScriptUnHighlight(webdriver, webElement);
                ScreenshotUtils.executeJavaScript(webdriver, jsHighlight, webElement);
                byte[] screenshot = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES);
                ScreenshotUtils.executeJavaScript(webdriver, jsUnHighlight, webElement);
                return screenshot;
            }
        };
    }
}
