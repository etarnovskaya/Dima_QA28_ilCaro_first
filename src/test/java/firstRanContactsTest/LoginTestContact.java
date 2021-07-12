package firstRanContactsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTestContact extends WebDriversSettings {

    @Test //(enabled = false)
    public void loginTest() {


        //Open site
        SignUpPage signUpPage = PageFactory.initElements(wd, SignUpPage.class);
        signUpPage.open();

        //Login
        SignUpPage signUpLogin = PageFactory.initElements(wd, SignUpPage.class);
        signUpLogin.getLogin();
        signUpLogin.fillEmail("TestIdea@gmail.com");
        signUpLogin.fillPassword("Qwerty123$");
        signUpLogin.buttonLogin();
        signUpLogin.waitElement();


        //createContact
        int r = random.nextInt(100) + 1;
        CreateContact createContact = PageFactory.initElements(wd, CreateContact.class);
        createContact.addContact();
        createContact.setName("Vasya" + r);
        createContact.setLastName("Pupkin");
        createContact.setPhoneNumber("05339874" + r);
        createContact.setEmail("Test" + r + "@gmail.com");
        createContact.setAddress("Dom Kolotushkina");
        createContact.setDescription("TEST");
        createContact.setSave();

        //Delete contact
        setWait(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[2]"));

        //Sign Out
        click(By.xpath("//button[.='Sign Out']"));
    }

    @Test(enabled = true)
    public void negativeLogin() {

        SignUpPage signUpPage = PageFactory.initElements(wd, SignUpPage.class);
        signUpPage.open();

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
        Assert.assertEquals(error, ("Login Failed with code 400"));
    }

}