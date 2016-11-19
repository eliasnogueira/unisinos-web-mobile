package mobile.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class TrianguloMobile {

	@Test
	public 
	void testeTringulo() throws MalformedURLException {
		
		// localizacao da app para teste
		File aplicacao = new File("app/TrianguloApp.apk");
		
		/*
		 * Informamos as capacidades necessarias para a execucao do teste
		 */
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability(MobileCapabilityType.APP, aplicacao.getAbsolutePath());

		/* abre a comunicacao entre o codigo e o emulador Android
		 * lembre-se que antes da execucao o appium deve estar em execucao ou pelo
		 * Appium.app ou pelo comando 'appium --session-override'
		 */
		AndroidDriver<WebElement> android = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

		// preencher o lado 1 com 3
		android.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtLado1")).sendKeys("3");

		// preencher o lado 2 com 3
		android.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtLado2")).sendKeys("3");

		// preencher o lado 3 com 3
		android.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtLado3")).sendKeys("3");

		// clicar no botao calcular
		android.findElement(By.id("com.eliasnogueira.trianguloapp:id/btnCalcular")).click();

		// validar o resultado (triangulo equilatero)
		assertEquals("O triângulo é Equilátero",
				android.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtResultado")).getText());

		// fecha a app
		android.quit();
	}
}
