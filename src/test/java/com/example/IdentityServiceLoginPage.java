package com.example;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

/**
 * @author Jamal Kaabi-Mofrad
 */
@DefaultUrl("http://localhost:8080/workspace/")
public class IdentityServiceLoginPage extends PageObject
{

    @FindBy(id = "username")
    WebElementFacade usernameElement;

    @FindBy(id = "password")
    WebElementFacade passwordElement;

    @FindBy(xpath = "//input[@value='Sign in']")
    WebElementFacade signInElement;

    public void enterCredential(String userId, String password)
    {
        usernameElement.sendKeys(userId);
        passwordElement.sendKeys(password);
    }

    public void signIn() throws Exception
    {
        signInElement.click();
        Thread.sleep(5000);
    }

    public void titleShouldMatch(String matchTitle)
    {
        assertTrue("Page titles don't match.", this.getTitle().toLowerCase().contains(matchTitle.toLowerCase()));
    }
}
