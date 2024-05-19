package br.com.exemplo.stepdef;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import static br.com.exemplo.utils.reports.screenshot.ScenarioRepository.screenShot;

public class ExampleStepDef {
    @Dado("que quero dar um exemplo")
    public void queQueroDarUmExemplo() {
        System.out.println("Métodos vão aqui");
    }

    @E("estou empolgado pra dar um exemplo")
    public void estouEmpolgadoPraDarUmExemplo() {
        System.out.println("Métodos vão aqui");
    }

    @Quando("dar um exemplo")
    public void darUmExemplo() {
        System.out.println("Métodos vão aqui");
    }

    @Entao("darei um exemplo")
    public void dareiUmExemplo() {
        System.out.println("Métodos vão aqui");
    }
}
