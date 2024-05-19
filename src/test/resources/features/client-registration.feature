Feature: the client registration endpoint
  Scenario: client makes call to POST to registration
    Given client wants to register
    When client calls registration endpoint
    Then client receives success confirmation