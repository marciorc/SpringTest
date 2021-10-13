package com.marciorc.SpringTest;

import com.marciorc.SpringTest.webdriver.Hooks;
import com.marciorc.SpringTest.pages.AddProductPage;
import com.marciorc.SpringTest.pages.EditProductPage;
import com.marciorc.SpringTest.pages.HomePage;

import com.marciorc.SpringTest.pages.ProductsListPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringTestApplicationTests {

	@Value("${app.user}")
	private String appUser;

	@Value("${app.pass}")
	private String appPass;

	@Autowired
	private Hooks hooks;

	@Autowired
	private HomePage homePage;

	@Autowired
	private ProductsListPage productsListPage;

	@Autowired
	private EditProductPage editProductPage;

	@Autowired
	private AddProductPage addProductPage;

	@Test
	public void cadastrarProduto() {
		hooks.beforeStart();
		homePage.Login(appUser,appPass);
		productsListPage.adicionarProduto();
		addProductPage.adicionarProduto("Play Station", "499999", "Preto");
		Assertions.assertEquals("Produto adicionado com sucesso", editProductPage.msgProdutoAdicionadoComSucesso());
	}
}
