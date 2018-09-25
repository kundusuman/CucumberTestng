Feature: Flipkart Visit

Scenario: Flipkart Visit

Given visit Flipkart
When sucessfully Login
Then search mobile
Then visit cart
Then logout

