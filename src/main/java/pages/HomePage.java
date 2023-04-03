package pages;

import base.driver.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//span[text()='muhammad akmal']")
    WebElement username;

    @FindBy(xpath = "//span[text()='Contacts']")
    WebElement contactslink;

    @FindBy(xpath = "//span[text()='Deals']")
    WebElement deallink;

    @FindBy(xpath = "//span[text()='Tasks']")
    WebElement tasklink;

    @FindBy(xpath = "//button[@class='ui icon button']/i[1]")
    WebElement iebtn;

    @FindBy(xpath = "//button[@class='ui button']")
    WebElement cancelbtn;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    public boolean verifyCorrectUserName(){
        return username.isDisplayed();
    }

    public String validateHomePageTitle() {
        return driver.getTitle();
    }

    public ContactPage validateContactPage() throws Exception{
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(contactslink).perform();
     //   action.doubleClick(contactslink).perform();
        contactslink.click();
        Thread.sleep(5000);
        return new ContactPage();
    }
    public DealPage validateDealPage(){
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(deallink).perform();
        deallink.click();
        return new DealPage();
    }
    public TaskPage validateTaskPage(){
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(tasklink).perform();
        tasklink.click();
        return new TaskPage();
    }

}