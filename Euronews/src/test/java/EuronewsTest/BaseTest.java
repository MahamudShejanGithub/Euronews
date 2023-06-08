package EuronewsTest;

import Configuaration.config;
import EuronewsPageObjects.EuroNewsPageObject;
import JSON.JSONFileReaderClass;
import EuronewsPageObjects.NewsletterPageObject;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;

public class BaseTest extends Form {
    protected BaseTest() {
        super(By.xpath("//a[@aria-label='Euronews Logo']//h1//*[name()='svg']"), "euronews.");
    }

    Browser browser = AqualityServices.getBrowser();
    EuroNewsPageObject en = new EuroNewsPageObject();
    NewsletterPageObject nl = new NewsletterPageObject();

    @BeforeTest
    public void goToURL() {
        browser.maximize();
        browser.goTo(JSONFileReaderClass.getJSONKeyValue("url","configuration.json"));
    }

    @BeforeTest(dependsOnMethods="goToURL")
    public void euroNewsHomePage() throws InterruptedException {
        en.clickContinueWithoutAgreeing();
        Assert.assertTrue(en.isEuroNewsPageDisplayed(), "Euronews Home Page Has Not Appeared");
        en.clickNewsLetters();
        Assert.assertTrue(nl.isNewsLettersListDisplayed(), "Newsletter List Has Not Appeared");
       // Thread.sleep(20000);
        config.waitForPageLoad();
    }

	@AfterTest
	public void closeBrowser() {
		browser.quit();
	}
}
