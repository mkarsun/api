@SITTEST
Feature: Developer Portal  API Access Token

  Scenario Outline: User sends API Access Token Request
  
  Given User post LoginApi Access Token Request
  And ContentType<  > for the Dev portal
  And passing grantType is < >
      Given Developer Portal  API Access Token request
    And content type is "<content_type>" for APIGEE Developer Portal
    And passing granttype "<grant_type>" parameter
    And passing clientid "<client_id>" parameter
    And passing clientsecret "<client_secret>" parameter
    And passing username "<username>" parameter
    And passing pwd "<password>" parameter
    When Request is performing "<operation>" on APIGEE Gateway
    Then Service sends back Access Token
    Then Store the "<accesstoken>" in ACE API Local

    Examples: 
      | content_type     | grant_type | client_id                        | client_secret    | username              | password             | operation | accesstoken    |
      | application/json | password   | m3qmWiMPGc1egD0py4KcDp1aTqCpKPO7 | TFLuyrXWf3n16GCE | baofam_lasapisys2sys4 | fJ6%@9o=[EwB2Pr$VjUp | POST      | $.access_token |
  