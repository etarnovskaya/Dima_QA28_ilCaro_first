package firstRanContactsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignUpPage {

    private WebDriver wd;
    private WebDriverWait wait;

    public SignUpPage(WebDriver wd){
        this.wd = wd;
        wait = new WebDriverWait(wd, 15);
    }
    @FindBy(xpath = "//a[.='LOGIN']")
    private WebElement login;
    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement Email;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement Password;
    @FindBy(xpath = "//button[.=' Login']")
    private WebElement button;


    By locator = By.xpath("//a[normalize-space()='ADD']");

    public void open(){
        wd.get("https://contacts-app.tobbymarshall815.vercel.app/home");
    }
    public void getLogin(){
        login.click();
    }
    public void fillEmail(String email){
        Email.sendKeys(email);
    }
    public void fillPassword(String password){
        Password.sendKeys(password);
    }
    public void buttonLogin(){
        button.click();
    }
    public void waitElement(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }



}
