import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BMICalculatorTests {
        @Test
        public void checkOverweightCategory(){
                //Установить системную переменную
                System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");

                //Открыть браузер
                WebDriver driver = new ChromeDriver();
                //Зайти на сайт https://healthunify.com/bmicalculator/
                driver.get("https://healthunify.com/bmicalculator/");
                //Ввести вес
                WebElement weightInput = driver.findElement(By.name("wg"));
                weightInput.sendKeys("73");
                //Ввести рост
                WebElement heightInput = driver.findElement(By.name("ht"));
                heightInput.sendKeys("165");

                //Нажать кнопку Calculate
                WebElement calculateButton = driver.findElement(By.name("cc"));
                calculateButton.click();
                //Проверить, что категория Overweight
                WebElement categoryInput = driver.findElement(By.name("desc"));
                String actualCategory = categoryInput.getAttribute("value");

                assertEquals(actualCategory, "Your category is Overweight","Category should be Overweight");
                driver.quit();

        }
        @Test
        public void checkStarvationCategoryBoundaryValue(){
                System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
                WebDriver driver = new ChromeDriver();
                driver.get("https://healthunify.com/bmicalculator/");
                WebElement weightInput = driver.findElement(By.name("wg"));
                weightInput.sendKeys("44.9");
                WebElement heightInput = driver.findElement(By.name("ht"));
                heightInput.sendKeys("173");
                WebElement calculateButton = driver.findElement(By.name("cc"));
                calculateButton.click();
                WebElement categoryInput = driver.findElement(By.name("desc"));
                String actualCategory = categoryInput.getAttribute("value");

                assertEquals(actualCategory,"Your category is Starvation","Category should be Starvation");
                driver.quit();

        }

}