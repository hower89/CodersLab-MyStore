$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/cucumber/features/add-new-address.feature");
formatter.feature({
  "line": 1,
  "name": "log in and add a new address to the account with at least 1 address already defined",
  "description": "",
  "id": "log-in-and-add-a-new-address-to-the-account-with-at-least-1-address-already-defined",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "a logged in user can add another address",
  "description": "",
  "id": "log-in-and-add-a-new-address-to-the-account-with-at-least-1-address-already-defined;a-logged-in-user-can-add-another-address",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "the user is on the Addresses page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "the user clicks the New address button",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the user completes the Alias box with \u003calias\u003e, Address box with \u003caddress\u003e, City box with \u003ccity\u003e, Zip/postal code box with \u003cpostcode\u003e, Phone box with \u003cphone\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the user chooses a country \u003ccountry\u003e from the list",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the user submits changes",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "a success message is displayed",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the data is being verified: alias \u003calias\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the data is being verified: address \u003caddress\u003e, city \u003ccity\u003e, postcode \u003cpostcode\u003e, country \u003ccountry\u003e, phone \u003cphone\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "the user deletes newly added address; the deletion is being verified",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "the browser is being closed",
  "keyword": "And "
});
formatter.examples({
  "line": 17,
  "name": "",
  "description": "",
  "id": "log-in-and-add-a-new-address-to-the-account-with-at-least-1-address-already-defined;a-logged-in-user-can-add-another-address;",
  "rows": [
    {
      "cells": [
        "alias",
        "address",
        "city",
        "postcode",
        "phone",
        "country"
      ],
      "line": 18,
      "id": "log-in-and-add-a-new-address-to-the-account-with-at-least-1-address-already-defined;a-logged-in-user-can-add-another-address;;1"
    },
    {
      "cells": [
        "Anarchosyndykalista",
        "Mysikiszki 1",
        "Shire",
        "666-666",
        "0700",
        "United Kingdom"
      ],
      "line": 19,
      "id": "log-in-and-add-a-new-address-to-the-account-with-at-least-1-address-already-defined;a-logged-in-user-can-add-another-address;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 19,
  "name": "a logged in user can add another address",
  "description": "",
  "id": "log-in-and-add-a-new-address-to-the-account-with-at-least-1-address-already-defined;a-logged-in-user-can-add-another-address;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "the user is on the Addresses page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "the user clicks the New address button",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the user completes the Alias box with Anarchosyndykalista, Address box with Mysikiszki 1, City box with Shire, Zip/postal code box with 666-666, Phone box with 0700",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the user chooses a country United Kingdom from the list",
  "matchedColumns": [
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the user submits changes",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "a success message is displayed",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the data is being verified: alias Anarchosyndykalista",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the data is being verified: address Mysikiszki 1, city Shire, postcode 666-666, country United Kingdom, phone 0700",
  "matchedColumns": [
    1,
    2,
    3,
    4,
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "the user deletes newly added address; the deletion is being verified",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "the browser is being closed",
  "keyword": "And "
});
formatter.match({
  "location": "AddAddress.openAddressesPage()"
});
formatter.result({
  "duration": 10116618400,
  "status": "passed"
});
formatter.match({
  "location": "AddAddress.addNewAddress()"
});
formatter.result({
  "duration": 345616400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Anarchosyndykalista",
      "offset": 38
    },
    {
      "val": "Mysikiszki 1",
      "offset": 76
    },
    {
      "val": "Shire",
      "offset": 104
    },
    {
      "val": "666-666",
      "offset": 136
    },
    {
      "val": "0700",
      "offset": 160
    }
  ],
  "location": "AddAddress.fillUpBoxes(String,String,String,String,String)"
});
formatter.result({
  "duration": 539226000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "United Kingdom",
      "offset": 27
    }
  ],
  "location": "AddAddress.chooseCountryFromTheList(String)"
});
formatter.result({
  "duration": 72968400,
  "status": "passed"
});
formatter.match({
  "location": "AddAddress.submitChanges()"
});
formatter.result({
  "duration": 594327300,
  "status": "passed"
});
formatter.match({
  "location": "AddAddress.displayMessage()"
});
formatter.result({
  "duration": 123738900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Anarchosyndykalista",
      "offset": 34
    }
  ],
  "location": "AddAddress.verifyAlias(String)"
});
formatter.result({
  "duration": 63190900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Mysikiszki 1",
      "offset": 36
    },
    {
      "val": "Shire",
      "offset": 55
    },
    {
      "val": "666-666",
      "offset": 71
    },
    {
      "val": "United Kingdom",
      "offset": 88
    },
    {
      "val": "0700",
      "offset": 110
    }
  ],
  "location": "AddAddress.verifyteNewAddressData(String,String,String,String,String)"
});
formatter.result({
  "duration": 83931200,
  "status": "passed"
});
formatter.match({
  "location": "AddAddress.deleteNewAddress()"
});
formatter.result({
  "duration": 569301200,
  "status": "passed"
});
formatter.match({
  "location": "AddAddress.closeBrowser()"
});
formatter.result({
  "duration": 783779700,
  "status": "passed"
});
});