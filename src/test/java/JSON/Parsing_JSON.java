package JSON;


import java.io.FileReader;
import java.util.Iterator;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class Parsing_JSON {

	public static Object value;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		FileReader file = new FileReader(".\\JSON Files\\Read2.json");
		Object obj = new JSONParser().parse(file);
		System.out.println(obj);
		JSONObject inputobj = new JSONObject(obj.toString());
		System.out.println(inputobj);
		//getKey(inputobj, "street");
		
		//System.out.println(value);
		System.out.println(parseObjext(inputobj, "city"));
		
	}
	
	public static Object parseObjext(JSONObject json, String key) {
		//System.out.println(json.get(key));
		getKey(json, key);
		
		return value;
	}
	
	public static void getKey(JSONObject json, String key) {
		
		boolean exists = json.has(key);
		Iterator<?> keys;
		String nextKeys;
		
		if(!exists) {
			keys=json.keys();
			while(keys.hasNext()) {
				nextKeys=(String)keys.next();
				
				try {
					if(json.get(nextKeys) instanceof JSONObject) {
						if(exists == false) {
							getKey(json.getJSONObject(nextKeys), key);
						}
					}else if(json.get(nextKeys) instanceof org.json.JSONArray) {
						org.json.JSONArray jsonarray = json.getJSONArray(nextKeys);
						for(int i=0;i<jsonarray.length();i++) {
							String jsonarraystring = jsonarray.get(i).toString();
							JSONObject innerjson = new JSONObject(jsonarraystring);
				
							if(exists == false) {
								getKey(innerjson,key);
							}
						}
					}
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		}else {
			value=json.get(key);
		}
		
	}
}
