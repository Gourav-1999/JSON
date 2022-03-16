package JSON;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonParser;

public class Write_JsonFile {
	public static void main(String[] args) throws Exception {
		File file1 = new File(".\\JSON Files\\write1.json");
		Reader read = new FileReader(file1);
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		if (file1.length() == 0) {

			object.put("cartoonName1", "Johnny bravo");
			object.put("cartoonName2", "Popeye the sailor man");
			object.put("cartoonName3", "BenTen");
			object.put("cartoonName4", "Ostwald");
			object.put("cartoonName5", "Bob the builder");
			object.put("cartoonName6", "He Man");
			array.put("Schinchan");
			array.put("Doraemon");
			object.put("cartoonName7", array);

		} else {
			Object ob = new JsonParser().parse(read);
			String txt = new String(ob.toString());
			object = new JSONObject(txt);
			getKey(object, "cartoonName6", "Ostwald");
		}
		write(object);
	}

	public static JSONObject getKey(JSONObject json, String keys, String value) {

		String[] keyMain = keys.split("\\.");
		for (String keym : keyMain) {
			Iterator iter = json.keys();
			String key = null;
			while (iter.hasNext()) {
				key = (String) iter.next();
				if (json.optJSONArray(key) == null && (json.optJSONObject(key) == null)) {
					if (json.keySet().contains(keym)) {
						if (key.equals(keym)) {
							json.put(key, value);
							return json;
						}
					} else {
						json.put(key, value);
						return json;
					}
				}
				if (json.optJSONObject(key) != null) {
					if ((key.equals(keym))) {
						json = json.getJSONObject(key);
						break;
					}
				}
				if (json.optJSONArray(key) != null) {
					JSONArray jarray = json.getJSONArray(key);
					for (int i = 0; i < jarray.length(); i++) {
						json = jarray.getJSONObject(i);
					}
					break;
				}
			}

		}
		return json;

	}

	public static void write(JSONObject object) throws Exception {
		FileWriter file = new FileWriter(".\\JSON Files\\write1.json");
		file.write(object.toString());
		file.flush();
		file.close();
	}
}
