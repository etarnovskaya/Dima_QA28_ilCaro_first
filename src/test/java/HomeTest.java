import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.Random;


public class HomeTest {
    WebDriver wd;
    WebDriverWait wait;
    Random random;

    @BeforeMethod
    public void precondition() {
        wd = new ChromeDriver();
        random = new Random();
        wait = new WebDriverWait(wd, 10);
        wd.manage().window().maximize();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        Random random = new Random();


    }

    @Test
    public void findElement() {

        wd.findElement(By.xpath("//a[normalize-space()='LOGIN']")).click();
        wd.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("TestIdea@gmail.com");
        wd.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Qwerty123$" +Keys.TAB + Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='ADD']")));

        int r = random.nextInt(100) + 1;
        wd.findElement(By.xpath("//a[normalize-space()='ADD']")).click();
        wd.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("VASYA" + r);
        wd.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("PUPKIN");
        wd.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys("05339874" + r);
        wd.findElement(By.xpath("//input[@placeholder='email']")).sendKeys("Test" + r + "@gmail.com");
        wd.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("0vo2z");
        wd.findElement(By.xpath("//input[@placeholder='description']")).sendKeys("wmCPH134");
        wd.findElement(By.xpath("//b[normalize-space()='Save']")).click();


    }

    @AfterMethod
    public void postCondition() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            wd.quit();
        }

    }


}