package br.com.exemplo.utils.reports.screenshot;

import br.com.exemplo.utils.reports.screenshot.impl.RunScreenshot;
import br.com.exemplo.utils.reports.screenshot.impl.UntilScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Screenshot {
    public static byte[] take(WebDriver webDriver) {
        return new RunScreenshot().take(UntilScreenshot.screenshotWeb(webDriver));
    }

    public static byte[] take(WebDriver webDriver, WebElement... elements) {
        return new RunScreenshot().take(UntilScreenshot.screenshotWeb(webDriver, elements));
    }
}
