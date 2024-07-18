Feature: Search and Place the order for Products

Scenario: Sarch Experience for product search in both home and Offers page

Given User is on GreeCart Landing  Page
When user searched with Shortname "Tom" and extracted actual name of product
Then user searched for "Tom" shortname in offers page
And  validate product name in offers page matches with Landing Page
