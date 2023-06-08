package EuronewsPageObjects;

import org.openqa.selenium.By;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;

public class EuroNewsPageObject extends Form {

    public EuroNewsPageObject() {
        super(By.xpath("//a[@aria-label='Euronews Logo']//h1//*[name()='svg']"),"EuroNews HomePage");
    }

    private final IButton agreement = getElementFactory().getButton(By.xpath("//span[@role='button']"), "Continue Without Agreeing");
    private final IButton newsletters = getElementFactory().getButton(By.xpath("//span[@class='u-margin-start-1'][normalize-space()='Newsletters']"), "Newsletters");
    private final IButton euronews = getElementFactory().getButton(By.xpath("//a[@aria-label='Euronews Logo']//h1//*[name()='svg']"), "euronews.");

    public void clickContinueWithoutAgreeing() {
        agreement.click();
    }

    public void clickNewsLetters() {
        newsletters.clickAndWait();
    }

    public boolean isEuroNewsPageDisplayed() {
        return euronews.state().isDisplayed();
    }

}
