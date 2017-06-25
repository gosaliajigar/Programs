package json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/**
 * JSON can be converted into Java objects in 3 ways ... <br>
 *  1. Gson Library<br>
 *  2. JSON Simple Library<br>
 *  3. Jackson Library<br>
 * <br>
 * 
 * @author jgosalia
 *
 */
public class MainClass {

	private static final String json = "{\"id\" : 1001,\"name\" : \"James\",\"tasks\":[13, 34, 34, 15, 67, 35, 12, 81],\"department\" : {\"name\" : \"HR\"}}";

	public static void main(String[] args) throws Exception {
		useGsonLibrary();
		System.out.println();
		useJSONSimpleLibrary();
		System.out.println();
		useJacksonLibrary();
	}

	private static void useGsonLibrary() {
		Gson gson = new Gson();
		Employee gsonEmployee = gson.fromJson(json, Employee.class);
		System.out.println("JSON -> Java: " + gsonEmployee);
		System.out.println("Java -> JSON: " + gson.toJson(gsonEmployee));
	}

	private static void useJSONSimpleLibrary() throws ParseException {
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
		long id = (Long) jsonObject.get("id");
		String name = (String) jsonObject.get("name");
		List<Long> tasksList = new ArrayList<Long>();
		JSONArray values = (JSONArray) jsonObject.get("tasks");
		Iterator<Long> iterator = values.iterator();
		while (iterator.hasNext()) {
			tasksList.add(iterator.next());
		}
		int[] tasks = new int[tasksList.size()];
		for (int index = 0; index < tasks.length; index++) {
			tasks[index] = tasksList.get(index).intValue();
		}
		String dname = (String) ((JSONObject) jsonObject.get("department")).get("name");
		Department department = new Department(dname);
		Employee jsonEmployee = new Employee(id, name, tasks, department);
		System.out.println("JSON -> Java: " + jsonEmployee);
		System.out.println("Java -> JSON: " + jsonObject);
	}

	private static void useJacksonLibrary() throws Exception {
		Employee jacksonEmployee = new ObjectMapper().readValue(json, Employee.class);
		System.out.println("JSON -> Java: " + jacksonEmployee);
		String jsonString = new ObjectMapper().writeValueAsString(jacksonEmployee);
		System.out.println("Java -> JSON: " + jsonString);
	}
}
