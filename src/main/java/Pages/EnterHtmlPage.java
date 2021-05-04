package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class EnterHtmlPage {

  WebDriver driver;
  Wait<WebDriver> waiter;

  String textAreaId = "exampleFormControlTextarea1";
  String outputFieldSelector = "div.bg-white.rounded.text-dark.ng-binding";

  public EnterHtmlPage(WebDriver driver){
    this.driver = driver;
    this.waiter  = new FluentWait<>(driver);
  }

  public void enterHtmlCode(String code){
    WebElement textAreaField = waiter.until(ExpectedConditions.elementToBeClickable(By.id(textAreaId)));
    textAreaField.sendKeys(code);
  }

  public String getTextFromOutputField(){
    WebElement outputField = waiter.until(ExpectedConditions.elementToBeClickable(By.cssSelector(outputFieldSelector)));
    String text = outputField.getText();
    return text;
  }
}
