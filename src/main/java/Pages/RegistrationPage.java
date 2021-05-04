package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class RegistrationPage{

  WebDriver driver;
  Wait<WebDriver> waiter;

  String fullNameXpath = "//input[@placeholder='Fullname']";
  String emailXpath = "//input[@placeholder='E-mail address']";
  String addressXpath = "//input[@placeholder='Residential address']";
  String phoneNumberXpath = "//input[@placeholder='10-digit mobile number']";
  String buttonContinueXpath = "//button[contains(text(), 'CONTINUE')]";
  String buttonContinueSecondXpath = "/html/body/div/div/div/div/form/ul/li[2]/div[2]/div[2]/button[1]";
  String scrollAreaSelector = "/html/body/div/div/div/div/form/ul/li[2]/div[2]";
  String passwordId = "icon_Pass";
  String passwordReEnterId = "icon_repass";
  String submitButtonXpath = "li.step.active > div.step-content.collection > div.step-actions > input";
  String stepOneSelector = "form > ul > li:nth-child(1)";
  String stepTwoSelector = "form > ul > li:nth-child(2)";
  String stepThreeSelector = "form > ul > li:nth-child(3)";

  public RegistrationPage(WebDriver driver){
    this.driver = driver;
    this.waiter  = new FluentWait<>(driver);
  }

  public void enterFullName(String firstName){
    WebElement fullNameField = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fullNameXpath)));
    fullNameField.sendKeys(firstName);
  }

  public void enterEmail(String email){
    WebElement fullNameField = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(emailXpath)));
    fullNameField.sendKeys(email);
  }

  public void enterAddress(String address){
    WebElement fullNameField = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addressXpath)));
    fullNameField.sendKeys(address);
  }

  public void enterPhoneNumber(String phoneNumber){
    WebElement fullNameField = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(phoneNumberXpath)));
    fullNameField.sendKeys(phoneNumber);
  }

  public void clickContinueButton(){
    WebElement buttonContinue = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonContinueXpath)));
    buttonContinue.click();
  }

  public void clickSecondContinueButton() throws AWTException {

    WebElement scrollArea = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
        scrollAreaSelector)));
    scrollArea.click();

    Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
    robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

    WebElement buttonContinueSecond = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonContinueSecondXpath)));
    buttonContinueSecond.click();
  }

  public void enterPassword(String password){
    WebElement passwordField = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id(
        passwordId)));
    WebElement reEnterPasswordField = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id(passwordReEnterId)));
    passwordField.sendKeys(password);
    reEnterPasswordField.sendKeys(password);
  }

  public void clickSubmitButton(){
    WebElement submitButton = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(submitButtonXpath)));
    submitButton.click();
  }

  public String getStepOneClasses(){
    WebElement stepOneCheckmark = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(stepOneSelector)));
    return stepOneCheckmark.getAttribute("class");
  }

  public String getStepTwoClasses(){
    WebElement stepTwoCheckmark = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(stepTwoSelector)));
    return stepTwoCheckmark.getAttribute("class");
  }

  public String getStepThreeClasses(){
    WebElement stepThreeCheckmark = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(stepThreeSelector)));
    return stepThreeCheckmark.getAttribute("class");
  }
}
