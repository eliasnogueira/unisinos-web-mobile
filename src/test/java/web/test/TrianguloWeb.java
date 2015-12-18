package web.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TrianguloWeb {

	@Test
	public void testeTriangulo() {
		
		// abrir o browser
		WebDriver browser = new FirefoxDriver();
		
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
		
		// validar o resultado (triangulo equilatero)
		assertEquals("Triângulo Equilatero", browser.findElement(By.cssSelector(".mensagem")).getText());
	
		// fechar o browser
		browser.quit();
	}

}
