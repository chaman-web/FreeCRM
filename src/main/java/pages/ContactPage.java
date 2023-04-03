package pages;
import base.driver.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ContactPage extends TestBase {
    @FindBy(xpath = "//th[text()='Email']")
    @CacheLookup
    WebElement contactlabelEmail;

    @FindBy(xpath = "//*[text()='Create']")
    WebElement clickoncreate;

    @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstname;

    @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastname;

    @FindBy(xpath = "//div[@name='source' and @role='listbox']")
    WebElement selectsource;

    @FindBy(xpath = "//div[@name='category' and @role='listbox']")
    WebElement selectcat;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement savebtn;

    public ContactPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyContactLabelstatus() {
        return contactlabelEmail.isDisplayed();
    }

    public void addContactForm(String fr, String lstn) {
        clickoncreate.click();
        firstname.sendKeys(fr);
        lastname.sendKeys(lstn);

      /*  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@name='category' and @role='listbox']/div/div/span[@class='text']")));*/
       selectcat.click();
        List<WebElement> list = driver.findElements(By.xpath("//div[@name='category' and @role='listbox']/div/div/span[@class='text']"));
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().contains("Customer")) {
                list.get(i).click();
                break;
            }
        }
        selectsource.click();
        List<WebElement> sourcelist = driver.findElements(By.xpath("//div[@name='source' and @role='listbox']/div/div/span[@class='text']"));
        System.out.println(sourcelist.size());
        for (int i = 0; i < sourcelist.size(); i++) {
            System.out.println(sourcelist.get(i).getText());
            if (sourcelist.get(i).getText().contains("Referral")) {
                sourcelist.get(i).click();
                break;
            }
        }
        savebtn.click();
    }
}

