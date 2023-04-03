package pages;

import base.driver.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    @FindBy(xpath = "//*[text()='Log In']")
            @CacheLookup
    WebElement loginbtn;

    @FindBy(name = "email")
            @CacheLookup
    WebElement Email;

    @FindBy(name = "password")
    @CacheLookup
    WebElement Password;

    @FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[3]")
    @CacheLookup
    WebElement clicklogin;

    @FindBy(xpath = "(//a[@href='https://freecrm.com']//span)[2]")
    @CacheLookup
    WebElement crmlogo;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }
    public boolean crmLogo(){
        return crmlogo.isDisplayed();
    }
    public HomePage login(String em, String pw){
        loginbtn.click();
        Email.sendKeys(em);
        Password.sendKeys(pw);
        clicklogin.click();

        return new HomePage();
    }

}
