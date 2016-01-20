Navigating to an article

Narrative:
a user should be able to navigate to different articles
					 
Scenario:  navigating to articles from menu
Given i am on the 'Contents' menu page
When i click on 'Mathematics' from portal menu
Then 'Portal:Contents/Mathematics and logic' should be displayed

Scenario:  navigating to a random article
Given i am on the 'Featured content' menu page
When i click on 'Random Article' from side menu
Then a random article should be displayed