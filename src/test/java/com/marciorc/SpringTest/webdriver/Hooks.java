package com.marciorc.SpringTest.webdriver;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Hooks {

    @Value("${app.url}")
    private String appUrl;

    @Value("${app.implicit_wait}")
    private Integer appImplicitWait;

    @Autowired
    private WebDriver webDriver;

    public void beforeStart() {
        webDriver.navigate().to(appUrl);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(appImplicitWait, TimeUnit.SECONDS);
    }
}
