package EuronewsTest;

import Configuaration.config;
import JSON.JSONFileReaderClass;
import EuronewsPageObjects.NewsletterPageObject;
import Utilities.UtilityClass;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseTwo extends BaseTest {

    NewsletterPageObject nl = new NewsletterPageObject();
    @Test(priority=2)
    public void newsLettersCheck() throws InterruptedException {
        JSONObject newsletterDataOne=(JSONObject) JSONFileReaderClass.getJSONArray("data", "NewsLettersData.json").get(0);
        Assert.assertEquals(nl.theWatch(),(String) newsletterDataOne.get("name"),"NewsLetter The Watch is not present");
        Assert.assertEquals(nl.frequencyOfWatch(),(String) newsletterDataOne.get("frequency"),"Frequency of The Watch is not present");
        Assert.assertEquals(nl.descriptionOfWatch(),(String) newsletterDataOne.get("description"),"NewsLetter The Watch is not present");

        JSONObject newsletterDataTwo=(JSONObject) JSONFileReaderClass.getJSONArray("data", "NewsLettersData.json").get(1);
        Assert.assertEquals(nl.green(),(String) newsletterDataTwo.get("name"),"NewsLetter Green is not present");
        Assert.assertEquals(nl.frequencyOfGreen(),(String) newsletterDataTwo.get("frequency"),"Frequency of Green is not present");
        Assert.assertEquals(nl.descriptionOfGreen(),(String) newsletterDataTwo.get("description"),"NewsLetter Green is not present");

        JSONObject newsletterDataThree=(JSONObject) JSONFileReaderClass.getJSONArray("data", "NewsLettersData.json").get(2);
        Assert.assertEquals(nl.culture(),(String) newsletterDataThree.get("name"),"NewsLetter Culture is not present");
        Assert.assertEquals(nl.frequencyOfCulture(),(String) newsletterDataThree.get("frequency"),"Frequency of Culture is not present");
        Assert.assertEquals(nl.descriptionOfCulture(),(String) newsletterDataThree.get("description"),"NewsLetter Culture is not present");

        nl.specialCoverageNewsLetter();
        nl.closePopUp();
      //  Thread.sleep(20000);
        config.waitForPageLoad();
        nl.clickOtherRandomSeePreview();
        UtilityClass.switchToFrame(nl.insideRandomPreview());
        browser.goTo(nl.seeAllNewsLetter());
    }
}
