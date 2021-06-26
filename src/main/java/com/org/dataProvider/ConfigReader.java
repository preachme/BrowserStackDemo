package com.org.dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties properties;
	private final String propertyFilePath = System.getProperty("user.dir")+"//configs//configuration.properties";
	String driverPath = null;
	
	public ConfigReader(){
		BufferedReader reader;
		try{
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try{
				properties.load(reader);
				reader.close();
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("Configuartion.properties file not found.");
		}
		
	}
	public String getDriverPath(String drivername){
		
		if(drivername.equalsIgnoreCase("chromeDriver")){
			driverPath = System.getProperty("user.dir") + properties.getProperty("chromeDriverPath");
		}
		return driverPath;
	}
	
	public String getDriverName() {
		String driverName = properties.getProperty("driverName");
		if(driverName != null) return driverName;
		else throw new RuntimeException("driverName not specified in configuration.properties file.");
	}
	
	public String getURL() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("URL not specified in configuration.properties file.");
	}
	public String getWindowMaximize() {
		String maximize = properties.getProperty("windowMaximize");
		if(maximize != null) return maximize;
		else throw new RuntimeException("Window Maximize not specified in configuration.properties file.");
	}
	public String getValue(String key) {
		String value = properties.getProperty(key);
		if(value != null) return value;
		else throw new RuntimeException(key + "not specified in configuration.properties file.");
	}
	
}
