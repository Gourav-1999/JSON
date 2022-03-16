package JSON;


import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Read_JSON_File {

	public static void main(String[] args) throws Throwable {

		// create object for json parser class
		JSONParser jsonparser = new JSONParser();
		// load json file
		FileReader reader = new FileReader(".\\JSON Files\\Read1.json");
		// parse reader object and return object obj(java)
		Object obj = jsonparser.parse(reader);
		// convert object obj(java) into jason object
		JSONObject jsonObj1 = (JSONObject) obj;
		// extract simple values
		// create string variable for firstname
		String fname = (String) jsonObj1.get("firstName");
		// create string variable for lastname
		String lname = (String) jsonObj1.get("lastName");
		// print
		System.out.println("First Name: " + fname);
		System.out.println("Last Name: " + lname);

		// extract values from json array
		// create json array obj
		JSONArray array = (JSONArray) jsonObj1.get("address");

		for (int i = 0; i < array.size(); i++) {
			// convert into json object
			JSONObject jsonObj2 = (JSONObject) array.get(i);
			// create string variable for street,city and state
			String street = (String) jsonObj2.get("street");
			String city = (String) jsonObj2.get("street");
			String state = (String) jsonObj2.get("street");
			// print
			System.out.println("Address of " + i + " is...");
			System.out.println("Street: " + street);
			System.out.println("City: " + city);
			System.out.println("State: " + state);

		}

	}

}
