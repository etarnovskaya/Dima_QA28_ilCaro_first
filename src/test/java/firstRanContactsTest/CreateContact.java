package firstRanContactsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateContact {
    private WebDriver wd;
    private WebDriverWait wait;

    public CreateContact(WebDriver wd){
        this.wd = wd;
        wait = new WebDriverWait(wd, 15);
    }
    @FindBy(xpath = "//a[normalize-space()='ADD']")
    private WebElement add;
    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement Name;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement LastName;
    @FindBy(xpath = "//input[@placeholder='Phone']")
    private WebElement PhoneNumber;
    @FindBy(xpath = "//input[@placeholder='email']")
    private WebElement Email;
    @FindBy(xpath = "//input[@placeholder='Address']")
    private WebElement Address;
    @FindBy(xpath = "//input[@placeholder='description']")
    private WebElement Description;
    @FindBy(xpath = "//b[normalize-space()='Save']")
    private WebElement Save;



    public void addContact(){
        add.click();
    }
    public void setName(String name){
        Name.sendKeys(name);
    }
    public void setLastName(String lastName){
        LastName.sendKeys(lastName);
    }
    public void setPhoneNumber(String phoneNumber){
        PhoneNumber.sendKeys(phoneNumber);
    }
    public void setEmail(String email){
        Email.sendKeys(email);
    }
    public void setAddress(String address){
        Address.sendKeys(address);
    }
    public void setDescription(String description){
        Description.sendKeys(description);
    }
    public void setSave(){
        Save.click();
    }
}
