Narrative:
As a Test Engineer I want to run a repeatable set of tests on a deployed instance of the DBP
So that I am confident the DBP works.

Scenario: Can login
Given I opened the ADW login page
When I enter credential as <userId> and as <password>
And I submit
Then I should see the ADW page title as <title>

Examples:
|userId|password|title|
|admin|admin|Personal Files|