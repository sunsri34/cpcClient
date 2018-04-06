package au.com.westpac.cpc.products.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<String,xString> extends LinkedHashMap<String, String> {
  private int cacheSize;

  public LRUCache(int cacheSize) {
   // super(16, 0.75, true);
    this.cacheSize = cacheSize;
  }

  protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
    return size() >= cacheSize;
  }
  
  /*protected java.lang.String getValue(String key) {
	  return new java.lang.String("");
  }*/
}
