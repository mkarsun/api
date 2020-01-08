package com.karsun.fema.gmm.marquess.utils;


import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ 
	"file:src/test/resources/propertyFiles/${environment}.properties" // mention the property file name
})
public interface ConfigProperties extends  Config{

	@Key("baseURI")
	String getBaseURI();
	
	@Key("basePath")
	String getBasePath();
	
	@Key("sheetName")
	String getSheetName();
	
	@Key("validsecretKey")
	String getValidKey();
	
	@Key("invalidsecretKey")
	String getInValidKey();
	
	@Key("filePath")
	String getfilePath(String filename);
	@Key("AccessToken_URI_Path")
	String getAccessToken_URI_Path();
	
	@Key("base_url_Path")
	String getBaseUrl_path();
	
}
