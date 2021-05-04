package FlorenceTask;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.EnterHtmlPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EnterHtmlTest {
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
  public void testCase(){

    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    EnterHtmlPage textAreaPage = new EnterHtmlPage(driver);

    homePage.goToHomePage();

    loginPage.enterUsername("admin");
    loginPage.enterPassword("12345");
    loginPage.clickLoginButton();

    homePage.goToTextAreaPage();
    textAreaPage.enterHtmlCode("<!DOCTYPE html>\n"
        + "<html>\n"
        + "<body>\n"
        + "<p>This is a paragraph.</p>\n"
        + "<p>This is another paragraph.</p>\n"
        + "</body>\n"
        + "</html>");

    Assert.assertEquals(textAreaPage.getTextFromOutputField(), "This is a paragraph.\n"
        + "This is another paragraph.");
  }
}
