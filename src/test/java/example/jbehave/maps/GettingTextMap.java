package example.jbehave.maps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import static org.assertj.core.api.Assertions.assertThat; 
import example.pages.ArticlePage;
import example.pages.PortalPage;
import example.pages.WikiMainPage;

public class GettingTextMap
{

	WikiMainPage wikiHomePage;
	ArticlePage articlePage;
	
	@Given("i am on the '$string' article")
    public void givenISelectMainSideMenu(String string) 
    {
		wikiHomePage.open();
		wikiHomePage.searchFor(string);
    }
    
	@When("i click on the link on with text '$string'")
    public void whenISelectFromPortalTopMenu(String string) 
    {
		articlePage.clickLinkWithText(string);
    }
	
    
	@Then("the '$string' page should be displayed")
    public void whenIClickOnMenuItem(String string1) 
    {
		articlePage.verifyTitleEquals(string1);
    }
	


 
}