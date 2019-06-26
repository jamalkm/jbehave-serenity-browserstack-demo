package com.example;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * @author Jamal Kaabi-Mofrad
 */
public class IdentityServiceLoginSteps
{
    IdentityServiceLoginPage loginPage;

    @Given("I opened the ADW login page")
    public void givenIOpenedTheADWLoginPage()
    {
        loginPage.open();
    }

    @When("I enter credential as <userId> and as <password>")
    public void whenIEnterCredentialAsuserIdAndAspassword(@Named("userId") String userId, @Named("password") String password) throws Exception
    {
        loginPage.enterCredential(userId, password);
    }

    @When("I submit")
    public void whenISubmit() throws Exception
    {
        loginPage.signIn();
    }

    @Then("I should see the ADW page title as <title>")
    public void thenIShouldSeeTheADWPageTitleAstitle(@Named("title") String title)
    {
        loginPage.titleShouldMatch(title);
    }
}
