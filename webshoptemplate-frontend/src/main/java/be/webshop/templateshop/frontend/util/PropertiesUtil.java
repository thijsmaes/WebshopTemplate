package be.webshop.templateshop.frontend.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author tmaes
 */
public class PropertiesUtil {
	public static Properties load(Class<?> type, String filePath) throws IOException {
		Properties properties = new Properties();
		InputStream input = type.getResourceAsStream(filePath);
		if (input == null) {
			throw new RuntimeException("'" + filePath + "' not found");
		}
		properties.load(input);
		input.close();
		return properties;
	}
}
