package EuronewsTest;

import Configuaration.config;
import JSON.JSONFileReaderClass;
import EuronewsPageObjects.NewsletterPageObject;
import Utilities.UtilityClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseOne extends BaseTest {
    NewsletterPageObject nl = new NewsletterPageObject();
    @Test(priority=1)
    public void newsLetterSubscription() throws InterruptedException {
        nl.clickRandomNewsLetter();
        Assert.assertTrue(nl.isEmailFormOpen(), "Enter Email Form Has not Appeared");
        nl.sendEmail(JSONFileReaderClass.getJSONKeyValue("email", "UserData.json"));
        nl.clickSubmit();
        nl.waitForPopUpForm();
        Assert.assertTrue(nl.isPopUpFormDisplayed(), "Close Button From Pop Up Form About Subscription Has Not Appeared");
        nl.closeForm();
      //  Thread.sleep(20000);
        config.waitForPageLoad();
        nl.clickSeePreview();
        UtilityClass.switchToFrame(nl.insideRandomPreview());
        browser.goTo(nl.unsubscribeNewsletter());
        config.pageLoad();
        UtilityClass.switchToCurrentWindow();
        nl.enterEmailForUnsubscription(JSONFileReaderClass.getJSONKeyValue("email", "UserData.json"));
        Assert.assertTrue(nl.isEmailForUnsubscribetionOpen(),"Unsubscription Link Has Not Open");
        nl.clickConfirmEmailUnsubscription();
        Assert.assertEquals(nl.unsubscriptionConfirmationText(),"You are unsubscribed.","Texts Do not Match");
    }
}
