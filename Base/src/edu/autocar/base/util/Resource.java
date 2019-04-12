package edu.autocar.base.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;


public class Resource {
	public static Properties getProperties(String cpath) 
			throws FileNotFoundException, IOException {
		Properties properties  = new Properties();
		String path = Resource.class.getResource(cpath)
									.getPath();
		path = URLDecoder.decode(path, "utf-8");
		properties.load(new FileReader(path));
		return properties;
	}
}
