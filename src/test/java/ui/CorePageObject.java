package ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.regex.Pattern;

public class CorePageObject {
    protected AppiumDriver<WebElement> driver;
    public static final long
            DEFAULT_WAITING_TIMEOUT_IN_SECONDS = 5;
    public static final String
            BY_ID = "id",
            BY_ACCESSIBILITY_ID = "accessibility_id",
            BY_XPATH = "xpath";

    public CorePageObject(AppiumDriver<WebElement> driver) {
        this.driver = driver;
    }

    @SuppressWarnings("UnusedReturnValue")
    protected WebElement waitForElementAndClick(String locatorWithType) {
        return waitForElementAndClick(locatorWithType, DEFAULT_WAITING_TIMEOUT_IN_SECONDS);
    }

    @SuppressWarnings("SameParameterValue")
    protected WebElement waitForElementAndClick(String locatorWithType, long timeoutInSeconds) {
        WebElement element = waitForElementClickable(locatorWithType, timeoutInSeconds);
        element.click();

        return element;
    }

    private WebElement waitForElementClickable(String locatorWithType, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage("Не найден кликабельный элемент! " + locatorWithType);

        return wait.until(ExpectedConditions.elementToBeClickable(getLocatorByString(locatorWithType)));
    }

    @SuppressWarnings("UnusedReturnValue")
    protected WebElement waitForElementAndSendKeys(String locatorWithType, String charSequences) {
        return waitForElementAndSendKeys(locatorWithType, charSequences, DEFAULT_WAITING_TIMEOUT_IN_SECONDS);
    }

    @SuppressWarnings("SameParameterValue")
    protected WebElement waitForElementAndSendKeys(String locatorWithType, String charSequences, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locatorWithType, timeoutInSeconds);
        element.clear();
        element.sendKeys(charSequences);

        return element;
    }

    @SuppressWarnings("UnusedReturnValue")
    protected WebElement waitForElementPresent(String locatorWithType, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage("Не найден элемент! " + locatorWithType);

        return wait.until(ExpectedConditions.presenceOfElementLocated(getLocatorByString(locatorWithType)));
    }

    protected void waitForElementNotPresent(String locatorWithType) {
        waitForElementNotPresent(locatorWithType, DEFAULT_WAITING_TIMEOUT_IN_SECONDS);
    }

    @SuppressWarnings("SameParameterValue")
    protected void waitForElementNotPresent(String locatorWithType, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage("Элемент, который должен отсутствовать, найден! " + locatorWithType);
        wait.until(ExpectedConditions.numberOfElementsToBe(getLocatorByString(locatorWithType), 0));
    }

    protected List<WebElement> getElements(String locatorWithType) {
        return getElements(locatorWithType, DEFAULT_WAITING_TIMEOUT_IN_SECONDS);
    }

    @SuppressWarnings("SameParameterValue")
    protected List<WebElement> getElements(String locatorWithType, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage("Не найдены элементы! " + locatorWithType);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getLocatorByString(locatorWithType)));
    }

    private By getLocatorByString(String locatorWithType) {
        String[] typeAndLocator = locatorWithType.split(Pattern.quote(":"), 2);
        String byType = typeAndLocator[0];
        String locator = typeAndLocator[1];
        By result;

        switch (byType) {
            case BY_ID:
                result = By.id(locator);
                break;
            case BY_ACCESSIBILITY_ID:
                result = MobileBy.AccessibilityId(locator);
                break;
            case BY_XPATH:
                result = By.xpath(locator);
                break;
            default:
                throw new IllegalArgumentException("Не удалось определить тип локатора по строке: '" + locatorWithType + "'");
        }

        return result;
    }
}
