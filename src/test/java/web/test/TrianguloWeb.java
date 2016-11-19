package web.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrianguloWeb {

	@Test
	public void testeTriangulo() {
		
		/*
		 * Necessario duas acoes manuais para esta linha antes de executar o teste
		 *    1. Criar uma pasta no seu C:\ chamada Selenium
		 *    2. Baixar a ultima versao do GeckoDriver na URL abaixo e descompactar na pasta Selenium
		 *       https://github.com/mozilla/geckodriver/releases
		 */
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		
		// abrir o browser
		WebDriver browser = new FirefoxDriver();
		
		// criacao do tempo de espera total
		WebDriverWait espera = new WebDriverWait(browser, 10);
		
		// acessar a pagina
		browser.navigate().to("http://triangulos-1.herokuapp.com");
		
		// preencher o lado 1 com 3
		browser.findElement(By.id("triangulo_lado1")).sendKeys("3");
		
		// preencher o lado 2 com 3
		browser.findElement(By.id("triangulo_lado2")).sendKeys("3");
		
		// preencher o lado 3 com 3
		browser.findElement(By.id("triangulo_lado3")).sendKeys("3");
		
		// clicar no botao calcular
		browser.findElement(By.name("commit")).click();
		
		// espera pelo elemento que contem o texto
		espera.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".mensagem")));
		
		// validar o resultado (triangulo equilatero)
		assertEquals("Triângulo Equilatero", browser.findElement(By.cssSelector(".mensagem")).getText());
	
		// fechar o browser
		browser.quit();
	}

}
