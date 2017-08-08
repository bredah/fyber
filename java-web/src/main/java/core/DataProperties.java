package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class DataProperties {

	private Properties properties;

	public Map<String, String> getValues() throws IOException {
		Map<String, String> values = new HashMap<String, String>();

		// Get caller properties
		String caller = Thread.currentThread().getStackTrace()[2].getClassName();
		caller = caller.substring(caller.indexOf('.') + 1);

		// Load properties file
		try {
			properties = new Properties();
			FileInputStream file = new FileInputStream(String.format("%s/%s.properties", Utils.getPathResourceTest(), caller));
			properties.load(file);
		} catch (IOException e) {

			throw new IOException(String.format("File '%s' not found", ""), e);
		}

		// Fill hash with values founded
		Set<Object> keys = properties.keySet();
		for (Object key : keys) {
			values.put(key.toString(), properties.getProperty(key.toString()));
		}

		return values;
	}

}
