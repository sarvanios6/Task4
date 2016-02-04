

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
public static void main(String[] args) throws Exception {

		JSONParser parser = new JSONParser();

		try {
			System.out.println("Enter Product Name : \n");
			// read the input text
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String myProductName = br.readLine();
			System.out.println("Your Product Name :"+myProductName);
			String currentProduct = "";
			Object obj = parser.parse(new FileReader("/Users/Ramdhas/Desktop/data.json"));
			JSONArray jsonArray = (JSONArray) obj; // file read the json contents stored in jsonarray name
			for (int i = 0; i < jsonArray.size(); i++)// calculate the jsonarray value 
			{
				JSONObject jsonObjectRow = (JSONObject) jsonArray.get(i); // read the each content
				currentProduct = (String) jsonObjectRow.get("productname");// get the productl
				if(myProductName.contains(currentProduct)) //
				{
					System.out.println(jsonObjectRow.get("firstname") + " " + jsonObjectRow.get("lastname"));
				}
			}
			System.out.println("Enter Last Name : \n");
			String myLastName = br.readLine();// read SOP text from console
			System.out.println("Your Last Name :"+myLastName);
			String lastname = "";
		
			for (int i = 0; i < jsonArray.size(); i++) 
			{
				JSONObject jsonObjectRow = (JSONObject) jsonArray.get(i);
				lastname = (String) jsonObjectRow.get("lastname");
				if(myLastName.contains(lastname))
				{
					System.out.println(jsonObjectRow.get("productname") + " ");
				}
			}
			} 	catch (FileNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
