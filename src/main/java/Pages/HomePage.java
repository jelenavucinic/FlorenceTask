package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage{

  WebDriver driver;
  String baseURL = "http://examples.testsigma.com/login";
  String textAreaURL = "http://examples.testsigma.com/textarea";
  String loginButtonSelector = "#loginform > div:nth-child(6) > button";
  String fullNameXpath = "//input[@placeholder='Fullname']";


  public HomePage(WebDriver driver) {
    this.driver=driver;
    driver.manage().window().maximize();
  }

  public void goToHomePage() {
    driver.get(baseURL);
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(loginButtonSelector)));
  }

  public void goToRegistrationPage(){
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Signup")));

    driver.findElement(By.linkText("Signup")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fullNameXpath)));
  }

  public void goToTextAreaPage(){
    driver.get(textAreaURL);
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("breadcrumb")));
  }

}
