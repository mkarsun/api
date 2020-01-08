package com.karsun.fema.gmm.marquess.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.MapCreator;
import io.restassured.response.Response;

public class TestClass{

	
	public static void main(String[] args) {
		
	
		
	//TestBase testapipost = new TestBase();
	//public HashMap<String, Object> mapCreate(){
		
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("name", "Sean Thorson");
			map.put("studentid", "23232323");
			ArrayList<Integer> listofNumbers = new ArrayList<Integer>();
			listofNumbers.add(22343434);
			listofNumbers.add(323243423);
			map.put("mobilenumber", listofNumbers);
			HashMap<String, String> address = new HashMap<String, String>();
			address.put("StreetNumer", "121");
			address.put("streetName", "Byrd drive");
			address.put("city", "fairfax");
			address.put("state", "VA");
			map.put("address", address);
			
			System.out.println(map);
			
			
			
	
		
		}
		
	
		
//		Properties prop = new Properties();
//		FileInputStream fis = new FileInputStream("/Users/seanthorson/localRepo/Duke_API/Duke_API/duke_maven-seed/src/test/resources/config/Application.properties");	
//		prop.load(fis);
	
//		System.out.println(prop.getProperty("web.url"));
//		
//		System.out.println(System.getProperty("user.dir").concat("src/test/resources/config/Application.properties"));
//		
		

		
		
		
		
		
		
	}
	
	

