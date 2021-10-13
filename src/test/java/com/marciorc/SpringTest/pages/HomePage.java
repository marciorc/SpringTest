package com.marciorc.SpringTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HomePage {

    @Autowired
    private WebDriver webDriver;

    @PostConstruct
    public void InitHomePage(){
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.ID, using = "usuario")
    private WebElement inpUsuario;

    @FindBy(how = How.ID, using = "senha")
    private WebElement inpSenha;

    @FindBy(how = How.CSS, using = "button[type=\"submit\"]")
    private WebElement btnEntrar;

    public void Login(String user, String pass) {
        inpUsuario.sendKeys(user);
        inpSenha.sendKeys(pass);
        btnEntrar.click();
    }
}
