package br.com.exemplo.tests;

import br.com.exemplo.base.BaseTest;
import br.com.exemplo.pages.ExamplePage;
import org.testng.annotations.Test;

public class TempTest extends BaseTest {
    @Test
    public void nonFeatureTestExample(){
        ExamplePage.action()
                .load()
                .clickExample();
    }
}
