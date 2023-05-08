import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TesteCampoTreinamento {
	@Test
	public void testeTextInput() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		driver.quit();
	}
	
	@Test
	public void testeTextArea() {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement textArea = driver.findElement(By.id("elementosForm:sugestoes"));
		textArea.sendKeys("Teste");
		Assert.assertEquals("Teste", textArea.getAttribute("value"));
		driver.quit();
	}
	
	@Test
	public void testeRadioButton() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement radioButton = driver.findElement(By.id("elementosForm:sexo:0"));
		radioButton.click();
		Assert.assertTrue(radioButton.isSelected());
		driver.quit();
	}
	
	@Test
	public void testeCheckBox() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement checkBox = driver.findElement(By.id("elementosForm:comidaFavorita:2"));
		checkBox.click();
		Assert.assertTrue(checkBox.isSelected());
		driver.quit();
	}
	
	@Test
	public void testeDropdown() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement dropDown = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(dropDown);
		combo.selectByVisibleText("Superior");
		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
		driver.quit();
	}


	@Test
	public void testeValueDrop() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement dropDown = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(dropDown);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean find = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado")) {
				find = true;
				break;
			}
		}
		Assert.assertTrue(find);
		driver.quit();		
	}
	
	@Test
	public void testeComboMulti() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement dropDown = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(dropDown);
		
		
		List <WebElement> allOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allOptions.size());
		driver.quit();
	}
	
	@Test
	public void testeButton() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement button = driver.findElement(By.id("buttonSimple"));
		button.click();
		
		Assert.assertEquals("Obrigado!", button.getAttribute("value"));
		driver.quit();
	}
	
	@Test
	public void testeLink() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.linkText("Voltar")).click();
		Assert.fail();		
	}
	
	@Test
	public void testeTexto() {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement texto = driver.findElement(By.tagName("h3"));
		
		//método mais lento para obter o texto de uma pagina
		//Assert.assertTrue(texto.getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", texto.getText());
		
		driver.quit();
	}
	
}