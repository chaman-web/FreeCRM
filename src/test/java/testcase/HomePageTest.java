package testcase;

import base.driver.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ContactPage contactPage;
    DealPage dealPage;
    TaskPage taskPage;

    public HomePageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        contactPage=new ContactPage();
        dealPage= new DealPage();
        taskPage= new TaskPage();

    }
    @Test(priority = 1)
    public void verifyHomePageTitleTest(){
    String homepagetitle=homePage.validateHomePageTitle();
    Assert.assertEquals(homepagetitle,"Cogmento CRM","title not matched");
    }
    @Test(priority = 2)
    public void veifyCorrectUserNameTest(){
        Assert.assertTrue(homePage.verifyCorrectUserName());
    }
    @Test(priority = 3)
    public void validateContactPageTest() throws Exception {
        contactPage=homePage.validateContactPage();
    }
    @Test(priority = 4)
    public void validateDealPageTest() {
        dealPage=homePage.validateDealPage();
    }
    @Test(priority = 5)
    public void validateTaskPageTest(){
        taskPage=homePage.validateTaskPage();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
