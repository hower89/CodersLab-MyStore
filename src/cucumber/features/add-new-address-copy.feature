Feature: log in and add a new address to the account with at least 1 address already defined

  Scenario Outline: a logged in user can add another address
    Given the user is on the Addresses page
    And the user clicks the New address button
    When the user completes the Alias box with <alias>, Address box with <address>, City box with <city>, Zip/postal code box with <postalCode>, Phone box with <phone>
    And the user chooses a country <country> from the list
    And the user submits changes
    When a success message is displayed
    And the data is being verified: alias <alias>
    And print address box

    Then the user deletes newly added address; the deletion is being verified

    And the browser is being closed

    Examples:
      | alias               | address      | city  | postalCode | phone       | country        |
      | Anarchosyndykalista | Mysikiszki 1 | Shire | 666-666    | 666-666-666 | United Kingdom |



