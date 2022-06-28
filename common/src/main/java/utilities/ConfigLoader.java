package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import utilities.ConfigLoader;


public class ConfigLoader {
	

	
	public static ThreadLocal<Properties> property = new ThreadLocal<Properties>();
	private static String configpath = "common/src/main/resources/Config.properties";
	

	
	public static void initializePropertyfile()  {
		Properties pr = new Properties();
		try {
			InputStream instm = new FileInputStream(configpath);
			pr.load(instm);
			property.set(pr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
