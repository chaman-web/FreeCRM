package testcase;
import base.driver.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;

public class ContactPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ContactPage contactPage;
    public ContactPageTest(){
        super();
    }
    @BeforeMethod
    public void setUp()throws Exception{
        initialization();
        contactPage=new ContactPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        Thread.sleep(3000);
        contactPage=homePage.validateContactPage();
    }
    @Test(priority = 1)
    public void verifyContactLabel() throws Exception{
        Assert.assertTrue(contactPage.verifyContactLabelstatus());
        System.out.println("contact page testcase pass");
    }
    @Test(priority = 2)
    public void validateAddToContactForm()throws Exception{
        contactPage.addContactForm(prop.getProperty("firstname"), prop.getProperty("lastname"));
        System.out.println("Test case add contact Form Pass");
    }
    @Test
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
