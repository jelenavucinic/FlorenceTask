package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class LoginPage {

  WebDriver driver;
  Wait<WebDriver> waiter;

  public LoginPage(WebDriver driver){
    this.driver = driver;
    this.waiter  = new FluentWait<>(driver);
  }

  String userNameId = "username";
  String passwordId = "pass";
  String loginButtonSelector = "#loginform > div:nth-child(6) > button";
  String logoutButtonSelector = "#sticky_head > ul > li:nth-child(3) > a";
  String accountInfoXpath = "//*[@id=\"sticky_head\"]/ul/li[1]/a";

  public void enterUsername(String username){
    WebElement usernameField = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id(userNameId)));
    usernameField.sendKeys(username);
  }

  public void enterPassword(String password){
    WebElement passField = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id(passwordId)));
    passField.sendKeys(password);
  }

  public void clickLoginButton(){
    WebElement loginButton = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loginButtonSelector)));
    loginButton.click();
  }

  public void clickLogoutButton(){
    WebElement logoutButton = waiter.until(ExpectedConditions.elementToBeClickable(By.cssSelector(logoutButtonSelector)));
    logoutButton.click();
  }

  public String getTextFromAccountInfo(){
    WebElement accountInfo = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(accountInfoXpath)));
    String text = accountInfo.getText();
    return text;
  }
}
