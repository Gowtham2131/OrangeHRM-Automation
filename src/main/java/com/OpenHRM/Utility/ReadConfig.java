package com.OpenHRM.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public static Properties proper;
	
	public static void ReadConfig() throws IOException {
		
		try {
			FileInputStream file = new FileInputStream("C:\\Users\\Msi\\eclipse-workspace\\OpenHRM\\src\\main\\resources\\Configaration\\Config.Properties");
		 proper = new Properties();
			proper.load(file);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	
		

		
	}
		
	}

