package FlorenceTask;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
  WebDriver driver;

  @BeforeTest
  public void setUp(){
    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/driver/chromedriver.exe");
    driver = new ChromeDriver();
  }

  @AfterTest
  public void tearDown(){
    driver.quit();
  }

  @Test
  public void login(){

    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    homePage.goToHomePage();

    loginPage.enterUsername("admin");
    loginPage.enterPassword("12345");
    loginPage.clickLoginButton();

    Assert.assertEquals(loginPage.getTextFromAccountInfo(), "Username:   admin");

  }
}