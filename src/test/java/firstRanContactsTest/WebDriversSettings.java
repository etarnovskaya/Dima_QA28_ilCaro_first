package firstRanContactsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Random;

public class WebDriversSettings {


    public WebDriver wd;
    public WebDriverWait wait;
    public Random random;

    @BeforeMethod
    public void precondition() {
        wd = new ChromeDriver();
        random = new Random();
        wait = new WebDriverWait(wd, 20);
        wd.manage().window().maximize();

    }

    @AfterMethod
    public void postCondition() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wd.quit();

    }
    public void click(By locator) {
        wd.findElement(locator).click();
    }
    public void setWait(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
