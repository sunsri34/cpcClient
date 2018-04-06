package au.com.westpac.cpc.products.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
		 
	    private Properties prop = null;
	     
	    public PropertyLoader(){
	         
	        InputStream is = null;
	        try {
	            this.prop = new Properties();
	            is = this.getClass().getResourceAsStream("/db.properties");
	            prop.load(is);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	     
	    public String getPropertyValue(String key){
	        return this.prop.getProperty(key);
	    }
}