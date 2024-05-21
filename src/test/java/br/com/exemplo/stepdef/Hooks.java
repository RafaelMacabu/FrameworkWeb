package br.com.exemplo.stepdef;

import br.com.exemplo.utils.reports.screenshot.ScenarioRepository;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static br.com.exemplo.base.BaseTest.setup;
import static br.com.exemplo.base.BaseTest.teardown;

public class Hooks {
    @Before
    public static void before(Scenario scenario){
        setup("CHROME");
        ScenarioRepository.add(scenario);
    }

    @After
    public static void after(Scenario scenario){
        if (scenario.isFailed()){
            ScenarioRepository.screenShot();
        }
        teardown();
        ScenarioRepository.remove();
    }
}
