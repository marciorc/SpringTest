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
public class ProductsListPage {

    @Autowired
    private WebDriver webDriver;

    @PostConstruct
    public void InitProductListPage(){
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.CSS, using = "h3")
    private WebElement txtTitle;

    @FindBy(how = How.CSS, using = ".waves-effect.btn")
    private WebElement btnAdicionarProduto;

    public void adicionarProduto() {
        btnAdicionarProduto.click();
    }

}
