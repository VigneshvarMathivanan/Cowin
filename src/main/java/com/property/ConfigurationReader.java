package com.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
		
	public static Properties p;
	
	
	public ConfigurationReader() throws IOException {
		File f = new File("C:\\Users\\91769\\eclipse-workspace\\Cowin\\src\\main\\java\\com\\property\\Cowin.properties");
		FileInputStream fis = new FileInputStream(f);
		p = new Properties();
		p.load(fis);
	}
	
	public String getBrowser() {
		String ref = p.getProperty("browser");
		return ref;
	}
	
	public String getUrl() {
		String ref = p.getProperty("url");
		return ref;
	}
	
	public String getSheetName() {
		String ref = p.getProperty("sheetName");
		return ref;
	}
	
}
