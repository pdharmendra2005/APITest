@Test
  Feature: My Own Test
    @T1
  Scenario: API testing
  Given i have test data
  When i make a call to testworld api
  Then i should see status code 200
  And i validate response key "status" value "true"
  And i validate response key "msg" value "Add  data success"


    @T2
    Scenario Outline: API testing
      Given i have test data
      When i make a call to testworld api
      Then i should see status code 200
      And i validate response key "<keyheader>" value "<keyvalue>"
      Examples:
      |keyheader|keyvalue|
      |status|true|
      |msg|Add  data success|