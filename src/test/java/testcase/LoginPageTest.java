package testcase;

import base.driver.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage=new LoginPage();
    }
    @Test(priority =1)
    public void loginPageTitleTest(){
        String title=loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"#1 Free CRM Software for every business");
        System.out.println("Test Case 1 Pass");
    }
    @Test(priority = 2)
    public void crmLogoTest(){
        boolean flag= loginPage.crmLogo();
        Assert.assertTrue(flag);
        System.out.println("Test Case 2 Pass");
    }
    @Test(priority = 3)
    public void loginTest(){
        homePage =loginPage.login(prop.getProperty("email"),prop.getProperty("password"));
        System.out.println("Test Case 3 Pass");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
