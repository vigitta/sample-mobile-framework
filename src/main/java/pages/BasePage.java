package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverUtils;

import java.time.Duration;

public class BasePage {

    protected AppiumDriver driver;

    public BasePage() {
        this.driver = DriverUtils.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public void click(By element){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        WebElement wElement = this.driver.findElement(element);
        click(wElement);
    }
    public void click(WebElement element){
        element.click();
    }
    public boolean isClickable(By element){
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofMillis(3000));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception exception){
            return false;
        }
        return true;
    }
    public boolean isEnabled(By element){
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofMillis(3000));
            wait.until(ExpectedConditions.attributeToBe(element,"enabled","true"));
        }catch (Exception exception){
            return false;
        }
        return true;
    }
    public boolean isVisible(By element){
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofMillis(3000));
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        }catch (Exception exception){
            return false;
        }
        return true;
    }
    public boolean isVisible(WebElement element) {
        return element.isDisplayed();
    }

}
