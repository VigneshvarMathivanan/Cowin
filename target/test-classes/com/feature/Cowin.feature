Feature: Searching Of Hospitals For CovidVaccination

Scenario: CovidVaccination Hospitals For Required Conditions

Given user Launch The Url
When user Click The Required State
And user Click The Required District
And user Click The Required Age Dose Payment Vaccine
And user Verify The Age Dose Payment Vaccine
Then user Get The Hospital Names For Required Condiiton