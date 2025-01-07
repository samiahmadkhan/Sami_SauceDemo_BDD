package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
  private static Properties prop;
  
  public static Properties initializeProp() {
		prop = new Properties();
		FileInputStream file = null;
		/// Users/sami/eclipse-workspace/BDD/sami_ui_api_bdd_framework/CucumberPOM/src/test/resource/config/config.properties
		try {
			file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
	  return prop;
  }
 
}
