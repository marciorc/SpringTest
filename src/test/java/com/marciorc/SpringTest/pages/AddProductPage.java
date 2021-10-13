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
public class AddProductPage {

    @Autowired
    private WebDriver webDriver;

    @PostConstruct
    public void InitAddProductPage(){
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.ID, using = "produtonome")
    private WebElement inpProdutoNome;

    @FindBy(how = How.CSS, using = "[name=produtovalor]")
    private WebElement inpValorProduto;

    @FindBy(how = How.ID, using = "produtocores")
    private WebElement inpCoresProduto;

    @FindBy(how = How.CSS, using = ".btn[type=submit]")
    private WebElement btnSalvarProduto;

    @FindBy(how = How.CSS, using = ".btn.grey")
    private WebElement btnListaDeProdutos;

    public void adicionarProduto(String nomeProduto, String valorProduto, String corProduto) {
        inpProdutoNome.sendKeys(nomeProduto);
        inpValorProduto.sendKeys(valorProduto);
        inpCoresProduto.sendKeys(corProduto);
        btnSalvarProduto.click();
    }
}
