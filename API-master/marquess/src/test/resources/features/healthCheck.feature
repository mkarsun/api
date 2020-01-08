@Iteration023
Feature: Health Check Test for ACE API Request Submission


Scenario: wbserivce Api health Check 
	Given Webservice post for api 2.0 in the Properties file and payload "testfile.json"
	#When Invoke GET method on ACE API 2.0 healthcheck URL 
	Then User validates the response code returned by ACE API 2.0 matches the expected value 200
	