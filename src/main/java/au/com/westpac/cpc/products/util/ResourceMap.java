package au.com.westpac.cpc.products.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ResourceMap {

	public Map<String,String> getResouceMap(){
		Map<String,String> propertyMap = new HashMap<String,String>();
		ResourceBundle rb = ResourceBundle.getBundle("env");
		Enumeration<String> keys = rb.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = rb.getString(key);
			propertyMap.put(key, value);
			System.out.println(key + ": " + value);
		}
		return propertyMap;
	}
	
}
