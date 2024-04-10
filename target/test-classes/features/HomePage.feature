Feature: To verify Greetings to the user

 Scenario: To verify the URL for Demo_blaze on Google browser
 Given: The user is on  valid WebBrowse
 Then: Enter the DemoBlaze Url

  Scenario: To verify the Demo_blaze site showing Greetings to the user
    Given The user is on  valid WebBrowser
    Then Enter the DemoBlaze Url
    And Validate that the DemoBlaze displays Welcome Greeting to the user