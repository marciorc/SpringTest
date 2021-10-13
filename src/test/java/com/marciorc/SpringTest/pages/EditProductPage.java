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
public class EditProductPage {

    @Autowired
    private WebDriver webDriver;

    @PostConstruct
    public void InitEditProductPage(){
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.CSS, using = ".toast.rounded")
    private WebElement txtProdutoAdicionadoComSucesso;

    public String msgProdutoAdicionadoComSucesso() {
        return txtProdutoAdicionadoComSucesso.getText();
    }
}
