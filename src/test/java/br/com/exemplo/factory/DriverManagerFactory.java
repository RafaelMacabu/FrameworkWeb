package br.com.exemplo.factory;

import br.com.exemplo.constants.BrowserType;

public class DriverManagerFactory {
    public static DriverManager getManager(BrowserType browserType){
        switch (browserType){
            case CHROME: return new ChromeDriverManager();
            case FIREFOX: return new FirefoxDriverManager();
            default : throw new IllegalStateException("Invalid Browser Type");
        }

    }
}
