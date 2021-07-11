package firstRanContactsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.Random;


public class LoginTestContact {
    WebDriver wd;
    WebDriverWait wait;
    Random random;

    @BeforeMethod
    public void precondition() {
        wd = new ChromeDriver();
        random = new Random();
        wait = new WebDriverWait(wd, 20);
        wd.manage().window().maximize();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
    }

    @Test //(enabled = false)
    public void loginTest() {

        //Login
        click(By.xpath("//a[normalize-space()='LOGIN']"));

        fl(By.xpath("//input[@placeholder='Email']"),"TestIdea@gmail.com");
        fl(By.xpath("//input[@placeholder='Password']"),"Qwerty123$");
        click(By.xpath("//button[.=' Login']"));
        setWait(By.xpath("//h1[.=' No Contacts here!']"));
        setWait(By.xpath("//a[normalize-space()='ADD']"));

        //createContact
        int r = random.nextInt(100) + 1;
        click(By.xpath("//a[normalize-space()='ADD']"));
        fl(By.xpath("//input[@placeholder='Name']"),"VASYA" + r);
        fl(By.xpath("//input[@placeholder='Last Name']"), "PUPKIN");
        fl(By.xpath("//input[@placeholder='Phone']"),"05339874" + r);
        fl(By.xpath("//input[@placeholder='email']"),"Test" + r + "@gmail.com");
        fl(By.xpath("//input[@placeholder='Address']"),"Dom Kolotushkina ");
        fl(By.xpath("//input[@placeholder='description']"),"wmCPH134");
        click(By.xpath("//b[normalize-space()='Save']"));

        //Delete contact
        setWait(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[2]"));

        //Sign Out
        //click(By.xpath("//button[.='Sign Out']"));
    }
    @Test //(enabled = false)
    public void negativeLogin() {

        try {
           click(By.cssSelector("[href='/login']"));
           click(By.cssSelector("button:nth-child(4)"));
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wd.switchTo().alert().accept();
        setWait(By.xpath("//div[text()='Login Failed with code 400']"));
        String error = wd.findElement(By.xpath("//div[text()='Login Failed with code 400']")).getText();
        Assert.assertEquals(error,("Login Failed with code 400"));



    }
    public void click(By locator){
        wd.findElement(locator).click();
    }
    public void fl(By locator, String text){
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }
    public void setWait(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @AfterMethod
    public void postCondition() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            wd.quit();
        }

    }


}