package FlorenceTask;

import Pages.HomePage;
import Pages.RegistrationPage;
import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationTest {
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
  public void registrationTest() throws AWTException {
    HomePage homePage = new HomePage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);


    homePage.goToHomePage();
    homePage.goToRegistrationPage();

    registrationPage.enterFullName("Jelena Vucinic");
    registrationPage.enterEmail("jelenavucinic2@gmail.com");
    registrationPage.enterAddress("Kumanovska 8");
    registrationPage.enterPhoneNumber("+381692628800");
    registrationPage.clickContinueButton();
    registrationPage.clickSecondContinueButton();
    registrationPage.enterPassword("qwerty");
    registrationPage.clickSubmitButton();

    Assert.assertEquals(registrationPage.getStepOneClasses(), "step done");
    Assert.assertEquals(registrationPage.getStepTwoClasses(), "step done");
    Assert.assertEquals(registrationPage.getStepThreeClasses(), "step done");
  }
}
