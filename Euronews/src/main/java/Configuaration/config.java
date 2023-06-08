package Configuaration;

import JSON.JSONFileReaderClass;
import aquality.selenium.browser.AqualityServices;
import org.json.simple.JSONObject;

import java.time.Duration;

public class config {
    public static void pageLoad() {
        AqualityServices.getBrowser().waitForPageToLoad();
    }
    public static void waitForElement() {
        String time= JSONFileReaderClass.getJSONKeyValueFromResources("timeouts","timeoutCondition","settings.json");
        AqualityServices.getBrowser().setImplicitWaitTimeout(Duration.ofSeconds(Integer.valueOf(time)));
    }
    public static void waitForPageLoad() {
        String time= JSONFileReaderClass.getJSONKeyValueFromResources("timeouts","timeoutCondition","settings.json");
        AqualityServices.getBrowser().setPageLoadTimeout(Duration.ofSeconds(Integer.valueOf(time)));
    }

}
