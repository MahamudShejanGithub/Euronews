package EuronewsPageObjects;

import aquality.selenium.forms.Form;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.actions.JsActions;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ITextBox;

public class NewsletterPageObject extends Form {

    public NewsletterPageObject() {
        super(By.xpath("//span[@class='h1 text-secondary']"),"Our newsletters");
    }
    Random r= new Random();
    private int randomValue;
    private int s;
    private final IButton ournewsletters = getElementFactory().getButton(By.xpath("//span[@class='h1 text-secondary']"), "Our newsletters");
    private final ITextBox mail1 = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Enter your email']"), "Email");
    private final IButton submit1 = getElementFactory().getButton(By.xpath("//input[@value='Submit']"), "Submit");
    private final IButton popupclose = getElementFactory().getButton(By.xpath("//a[@class='close-modal ']"), "Close Button From Pop-Up about Subscription");
    private final IButton unsubscribeLink = getElementFactory().getButton(By.xpath("//a[contains(text(),'clicking here')]"),"All newsLetter");
    private final ITextBox mail2 = getElementFactory().getTextBox(By.xpath("//input[@id='email']"), "Email");
    private final IButton submit2 = getElementFactory().getButton(By.xpath("//button[@type='submit']"),"Confirm Unsubscription");
    private final ITextBox msg = getElementFactory().getTextBox(By.xpath("//strong[normalize-space()='You are unsubscribed.']"),"Confirmation Text");

    private final ITextBox newsWatch = getElementFactory().getTextBox(By.xpath("//h2[normalize-space()='The Watch']"), "The Watch");
    private final ITextBox newsGreen = getElementFactory().getTextBox(By.xpath("//h2[normalize-space()='Green']"), "Green");
    private final ITextBox newsCulture = getElementFactory().getTextBox(By.xpath("//h2[normalize-space()='Culture']"), "Culture");

    private final ITextBox watchFrequency = getElementFactory().getTextBox(By.xpath("(//p[@class='text-gray-900 mt-2'][normalize-space()='Weekly'])[2]"), "The Watch Frequency");
    private final ITextBox greenFrequency = getElementFactory().getTextBox(By.xpath("(//p[@class='text-gray-900 mt-2'][normalize-space()='Weekly'])[5]"), "Green Frequency");
    private final ITextBox cultureFrequency = getElementFactory().getTextBox(By.xpath("(//p[@class='text-gray-900 mt-2'][normalize-space()='Weekly'])[3]"), "Culture Frequency");

    private final ITextBox watchDescription = getElementFactory().getTextBox(By.xpath("//p[contains(text(),'A selection of best videos of the week and direct access to our series.')]"), "The Watch Newsletter Description");
    private final ITextBox greenDescription = getElementFactory().getTextBox(By.xpath("//p[contains(text(),'Your weekly informed guide on eco news & green views.')]"), "Green Newsletter Description");
    private final ITextBox cultureDescription = getElementFactory().getTextBox(By.xpath("//p[contains(text(),'The best of Europe’s arts, gastronomy, traditions ')]"), "Culture Newsletter Description");

    private final IButton specialCoveragePreview = getElementFactory().getButton(By.xpath("//a[@href='#special-coverage_previews']"), "Special Coverage Newsletter Preview");
    private final IButton specialCoverageAppeared = getElementFactory().getButton(By.xpath("//div[@id='special-coverage_previews']"), "Special Coverage Newsletter Preview");

    private final ITextBox closePopUp = getElementFactory().getTextBox(By.xpath("//a[@class='close-modal ']"), "Closing Special Coverage Preview");
    private final IButton seeAllNewsletter = getElementFactory().getButton(By.xpath("//a[contains(text(),'See all our newsletters')]"),"All newsLetter");

    public boolean isNewsLettersListDisplayed() {
        return ournewsletters.state().isDisplayed();
    }

    public boolean isEmailFormOpen() {
        return mail1.state().isDisplayed();
    }

    public void sendEmail(String email) {
        mail1.sendKeys(email);
    }

    public void clickSubmit() {
        submit1.clickAndWait();
    }

    public boolean isPopUpFormDisplayed() {
        return popupclose.state().isDisplayed();
    }

    public void waitForPopUpForm() {
        popupclose.state().waitForDisplayed();
    }

    public void closeForm() {
        popupclose.click();
    }

    public void clickRandomNewsLetter() {
        List<IButton> chooseNewsLetter = getElementFactory().findElements(By.xpath("//label[contains(text(),' Choose this newsletter ')]"), "Randomly Selected Newsletter", ElementType.BUTTON);
        s = chooseNewsLetter.size();
        randomValue = r.nextInt(s);
        chooseNewsLetter.get(randomValue).clickAndWait();
    }
    public void clickSeePreview() {
        List<IButton> seepreview = getElementFactory().findElements(By.xpath("//i[contains(@class,'far fa-eye mr-1')]"),"Preview Of chosen Newsletter",ElementType.BUTTON);
        IElement randomPreview=seepreview.get(randomValue);
        JsActions js=new JsActions(randomPreview,"");
        js.scrollIntoView();
        js.click();
    }

    public WebElement insideRandomPreview() {
        IElement randomPreview = getElementFactory().getButton(By.xpath("//iframe[@class='iframe-preview']"),"Preview Of chosen Newsletter");
        randomPreview.click();
        JsActions js = new JsActions(randomPreview, "");
        js.scrollBy(0,2000);
        WebElement preview=randomPreview.getElement();
        return preview;
    }

    public boolean isEmailForUnsubscribetionOpen() {
        return mail2.state().isDisplayed();
    }

    public void enterEmailForUnsubscription(String email) {
        mail2.clearAndType(email);
    }

    public void clickConfirmEmailUnsubscription() {
        submit2.click();
    }

    public String unsubscriptionConfirmationText() {
        String msg1=msg.getText();
        return msg1;
    }

    public String unsubscribeNewsletter() {
        String unsubscribe=unsubscribeLink.getAttribute("href");
        return unsubscribe;
    }

    public String theWatch() {
        String watch=newsWatch.getText();
        return watch;
    }

    public String green() {
        String green=newsGreen.getText();
        return green;
    }

    public String culture() {
        String culture=newsCulture.getText();
        return culture;
    }

    public String frequencyOfWatch() {
        String frequencyOfWatch=watchFrequency.getText();
        return frequencyOfWatch;
    }

    public String frequencyOfGreen() {
        String frequencyOfGreen=greenFrequency.getText();
        return frequencyOfGreen;
    }

    public String frequencyOfCulture() {
        String frequencyOfCulture=cultureFrequency.getText();
        return frequencyOfCulture;
    }

    public String descriptionOfWatch() {
        String descriptionOfWatch=watchDescription.getText();
        return descriptionOfWatch;
    }

    public String descriptionOfGreen() {
        String descriptionOfGreen=greenDescription.getText();
        return descriptionOfGreen;
    }

    public String descriptionOfCulture() {
        String frequencyOfCulture=cultureDescription.getText();
        return frequencyOfCulture;
    }

    public void specialCoverageNewsLetter() {
        specialCoveragePreview.clickAndWait();
    }

    public void closePopUp() {
        closePopUp.click();
    }

    public void clickOtherRandomSeePreview() {
        List<IButton> seepreview = getElementFactory().findElements(By.xpath("//i[contains(@class,'far fa-eye mr-1')]"),"Preview Of chosen Newsletter",ElementType.BUTTON);
        randomValue = r.nextInt(seepreview.size());
        IElement randomPreview=seepreview.get(randomValue);
        JsActions js=new JsActions(randomPreview,"");
        js.scrollIntoView();
        js.click();
        System.out.println(seepreview.size());

    }
    public String seeAllNewsLetter() {
        String link=seeAllNewsletter.getAttribute("href");
        return link;
    }
}
