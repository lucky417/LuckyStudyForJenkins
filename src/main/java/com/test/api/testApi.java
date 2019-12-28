package com.test.api;

import java.io.FileInputStream;
import java.util.Properties;

public class testApi {
	public Properties prop;
	public String excelPath;
	public String host;

	
	
	public testApi() throws Exception {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config.properties");
		prop.load(fis);
		host = prop.getProperty("Host");
		excelPath= prop.getProperty("testData");
	}
}
