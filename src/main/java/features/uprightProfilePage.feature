Feature: Profile Page Validation

  Background: user logs in and lands on the profile page
    Given user launches the application
    When user enter username
    When user enter password
    When user click on LoginButton
    Then verify user should be navigated to the profile page

    @smoke
    Scenario: Verify profile page URL and title
      Then profile page URL should contain "/profile/"
      And profile page title should be "Upright Tech | Upright Tech Solutions"

    @smoke
    Scenario: Verify profile header UI elements
      Then profile photo should be displayed
      And profile display name should be "Upright Tech"
      And profile settings icon should be displayed


    Scenario: Verify profile navigation tabs
      Then About tab should be displayed
      And Class Notes tab should be displayed
      And About tab should be the active tab by default

    Scenario: Verify About tab content
      When user click on About tab
      Then profile page URL should contain "?profiletab=main"
      And E-mail Address field label should be displayed
      And E-mail Address field value should be "upright@gmail.com"
      And email value should be a mailto link

    Scenario: Verify Class Notes tab navigation
      When user click on Class Notes tab
      Then profile page URL should contain "?profiletab=class-notes"
      And Class Notes tab should be the active tab

    Scenario: Verify empty profile note is displayed
      Then empty profile note should be displayed
      And empty profile note should contain text "Your profile is looking a little empty"
      And empty profile note should have an "add" link pointing to "?um_action=edit"

    Scenario: Verify settings dropdown options
      When user click on profile settings icon
      Then settings dropdown should be displayed
      And settings dropdown should contain the following options
        | Edit Profile |
        | My Account   |
        | Logout       |
        | Cancel       |

    Scenario: Verify profile photo upload dropdown options
      When user click on profile photo
      Then photo dropdown should be displayed
      And photo dropdown should contain the following options
        | Upload photo |
        | Cancel       |

    Scenario: Verify navigation to Edit Profile page
      When user click on profile settings icon
      And user select "Edit Profile" from settings dropdown
      Then profile page URL should contain "?um_action=edit"

    Scenario: Verify navigation to My Account page
      When user click on profile settings icon
      And user select "My Account" from settings dropdown
      Then profile page URL should contain "/my-account/"

    Scenario: Verify user can logout from the profile page
      When user click on profile settings icon
      And user select "Logout" from settings dropdown
      Then user should be on the login page
