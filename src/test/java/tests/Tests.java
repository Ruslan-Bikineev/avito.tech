package tests;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class Tests  { 
    WebDriver driver;
    
    @Before
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\biken\\Java\\demo\\src\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void firstTest() {
        driver.get("https://www.avito.ru/nikel/knigi_i_zhurnaly/domain-driven_design_distilled_vaughn_vernon_2639542363");
        WebElement addToFavorite = driver.findElement(By.xpath("//*[@class='style-header-add-favorite-M7nA2']/button"));
        addToFavorite.click();
        WebElement goToFavorite = driver.findElement(By.xpath("//*[@class='desktop-1rdftp2']"));
        goToFavorite.click();
        WebElement amountFavorites = driver.findElement(By.xpath("//*[contains(text(),'Все')]/following-sibling::span[1]"));
        WebElement nameFavorites = driver.findElement(By.xpath("//*[@class='styles-module-root-hwVld']"));
        String amount = amountFavorites.getAttribute("innerText");
        String name = nameFavorites.getText();
        Assert.assertEquals(1, Integer.parseInt(amount));
        Assert.assertEquals("Domain-Driven Design Distilled Vaughn Vernon", name);
    }    
    @After
    public void downDriver() {
       driver.close();
       driver.quit();
    }
}
