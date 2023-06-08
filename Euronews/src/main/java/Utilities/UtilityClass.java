package Utilities;

import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.WebElement;
import java.time.Duration;

public class UtilityClass {
    public static void switchToFrame(WebElement element){
        AqualityServices.getBrowser().getDriver().switchTo().frame(element);
    }
    public static void switchToCurrentWindow() {
        for (String winHandle : AqualityServices.getBrowser().getDriver().getWindowHandles()) {
            AqualityServices.getBrowser().getDriver().switchTo().window(winHandle);
        }
    }
}
