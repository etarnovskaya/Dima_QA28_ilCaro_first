import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;


public class HomeTest {
    WebDriver wd;


    @BeforeMethod
    public void precondition() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");

    }

    @Test
    public void findElement() {

        try {
            wd.findElement(By.xpath("//a[normalize-space()='LOGIN']")).click();
            wd.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("TestIdea@gmail.com");
            wd.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Qwerty123$" + Keys.TAB + Keys.ENTER);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        {
        try {
            wd.findElement(By.xpath("//a[normalize-space()='ADD']")).click();
            wd.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("P3b" + Keys.TAB);
            wd.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("live" + Keys.TAB);
            wd.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys("0533987452" + Keys.TAB);
            wd.findElement(By.xpath("//input[@placeholder='email']")).sendKeys("Test001@gmail.com" + Keys.TAB);
            wd.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("0vo2z" + Keys.TAB);
            wd.findElement(By.xpath("//input[@placeholder='description']")).sendKeys("wmCPH134" + Keys.TAB);
            wd.findElement(By.xpath("//b[normalize-space()='Save']")).click();
                Thread.sleep(1000);
        } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        wd.findElement(By.xpath("//div[@class='contact-item_card__2SOIM']")).click();
        wd.findElement(By.xpath("//button[normalize-space()='Remove']")).click();
        wd.findElement(By.xpath("//button[normalize-space()='Sign Out']")).click();


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
