import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TesteCadastro {
	
	@Test
	public void testeCadastro() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		//pegando parametros do form
		WebElement nome = driver.findElement(By.id("elementosForm:nome"));
		WebElement sobrenome = driver.findElement(By.id("elementosForm:sobrenome"));
		WebElement sexo = driver.findElement(By.id("elementosForm:sexo:0"));
		WebElement comidaFav = driver.findElement(By.id("elementosForm:comidaFavorita:2"));
		Select escolaridade = new Select(driver.findElement(By.id("elementosForm:escolaridade")));
		Select esportes = new Select(driver.findElement(By.id("elementosForm:esportes")));
		WebElement cadastrar = driver.findElement(By.id("elementosForm:cadastrar"));
		WebElement resultado = driver.findElement(By.id("resultado"));
		
		//setando os valores
		nome.sendKeys("Victor");
		sobrenome.sendKeys("Lima");
		sexo.click();
		comidaFav.click();
		escolaridade.selectByVisibleText("Mestrado");
		esportes.selectByVisibleText("Natacao");
		cadastrar.click();
	
		Assert.assertTrue(resultado.getText().startsWith("Cadastrado!"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Victor"));
		//faltando os outros testes...
	}
}
