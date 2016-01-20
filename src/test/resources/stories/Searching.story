Searching for an article

Narrative:
when an article title matches search criteria given in the
search box then that wikipedia article should open immediately

Scenario:  open the Hello World Program article
Given i am on the wikipedia home page
When i search for the article '"Hello, World!" program'
Then the '"Hello, World!" program' article should be displayed

Scenario:  open the Foobar article
Given i am on the wikipedia home page
When i search for the article 'Foobar'
Then the 'Foobar' article should be displayed

Scenario:  open the Behavior-driven development article
Given i am on the wikipedia home page
When i search for the article 'Behavior-driven development'
Then the 'Behavior-driven development' article should be displayed
