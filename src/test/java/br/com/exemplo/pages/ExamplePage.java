package br.com.exemplo.pages;

import br.com.exemplo.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static br.com.exemplo.base.BaseTest.getDriver;

public class ExamplePage extends BasePage {
    @FindBy(xpath = "//issoé[@um='elemento-para-exemplificar']")
    private WebElement exampleElement;

    public ExamplePage() {
        super(getDriver());
    }

    public static ExamplePage action(){
        return new ExamplePage();
    }

    public ExamplePage load(){
        load("/");
        return this;
    }

    public ExamplePage clickExample(){
        super.clickElement(exampleElement);
        return this;
    }
}
