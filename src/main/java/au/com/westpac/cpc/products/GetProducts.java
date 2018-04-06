package au.com.westpac.cpc.products;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import au.com.westpac.cpc.products.util.LRUCache;
import au.com.westpac.cpc.products.util.PropertyLoader;
import au.com.westpac.cpc.products.util.ResourceMap;

public class GetProducts {
	
	final static LRUCache<String, String> cache = new LRUCache<String, String>(250);
	

	public static void main(String[] args) {
		// fist check static map contains CPCs or not. 
		
		// if few are not found prepare a cpsNotFound List and prepare inputString. 
		String jsonInputBody = "{\"products\":{\"canonicalProductCode\":[\"ec1ebdcaf41148f2ad00cfadee4be0a9\",\"ec2702c180924abbb8f05315630ac8ff\"]}}";
		ResourceMap propertyMap = new ResourceMap();
		Map<String,String> mapofelements = propertyMap.getResouceMap();
		String key = mapofelements.get("cache.env");
		String endPointUrl = mapofelements.get(key);
		GetProducts getProducts = new GetProducts();
		String response = getProducts.loadCPCs(endPointUrl,jsonInputBody);
		// Stub the HTTP Client POST method
		
		

	}
	
	
	protected String loadCPCs(String endPointUrl, String myJsonObject) {
	    HttpClient httpClient = new DefaultHttpClient();
	    HttpPost httpPost = new HttpPost(endPointUrl);
	    ResponseHandler<String> responseHandler = new BasicResponseHandler();
	    String responseBody = null;
	    try {
	        StringEntity stringEntity = new StringEntity(myJsonObject);
	        httpPost.setEntity(stringEntity);
	        httpPost.setHeader("Content-type", "application/json");
	        ResponseHandler<String> responseHandler2 = new BasicResponseHandler();
	        responseBody = httpClient.execute(httpPost, responseHandler);
	    } catch (IOException e) {
	       // throw e;
	    }catch(Exception e) {
	    	
	    } finally {
	        httpClient.getConnectionManager().shutdown();
	    }
	    return responseBody;
	}

}
