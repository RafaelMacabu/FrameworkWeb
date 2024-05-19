package br.com.exemplo.utils.reports.screenshot;

import br.com.exemplo.utils.DateUtils;
import br.com.exemplo.utils.enums.DateFormatUtils;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

import static br.com.exemplo.base.BaseTest.getDriver;

public class ScenarioRepository {
    private static final Map<Long, Scenario> repository = new HashMap<Long, Scenario>();

    public static void add(Scenario scenario) {
        if (get() == null)
            repository.put(getId(), scenario);
    }

    public static void remove() {
        if (get() != null)
            repository.remove(getId());
    }

    private static Scenario get() {
        return repository.get(getId());
    }

    public static Long getId() {
        return Thread.currentThread().getId();
    }

    /**
     * Screenshot com highlights.
     */
    public static void screenShot() {
        try {
            byte[] print = Screenshot.take(getDriver());
            get().attach(print, "image/png", DateUtils.getDate(DateFormatUtils.PATTERN_SCREENSHOT));
        } catch (Exception ignored) {
        }
    }

    /**
     * Screenshot com highlights.
     * @param elements elementos destacados
     */
    public static void screenShot(WebElement... elements) {
        try {
            byte[] print = Screenshot.take(getDriver(), elements);
            get().attach(print, "image/png", DateUtils.getDate(DateFormatUtils.PATTERN_SCREENSHOT));
        } catch (Exception ignored) {}
    }

    /**
     * Adicionar textos ao relatório.
     */
    public static void addText(String texto) {
        if (texto != null)
            get().log(texto);
    }
}
