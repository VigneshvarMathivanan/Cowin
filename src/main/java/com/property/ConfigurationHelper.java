package com.property;

import java.io.IOException;

public class ConfigurationHelper {

	
	private ConfigurationHelper() {

	}
	
	public static ConfigurationReader getInstance() throws IOException {
		ConfigurationReader cr = new ConfigurationReader();
		return cr;
	}
	
}
