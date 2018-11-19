import java.lang.*
import java.utils.FileUtils

/**
*	Class used to save objects to JSON files and to extract objects from such files
*/
public final class JSONAccess {

	private Gson gson = new Gson();
	
	/**
	* This method is used to convert an object into a JSON string
	*
	* @param obj This is the object to convert into JSON
	* @return String This is the string containing the JSON formatted object
	*/
	public static String serialize(Object obj) {
		return this.gson.toJson(obj);
	}

	/**
	* This method is used to parse an object from a JSON string
	*
	* @param json This is the JSON string to be parsed
	* @param t This is the type of the object
	* @return Object This is the parsed object
	*/
	public static Object deserialize(String json, Type t) {
		return this.gson.fromJson(json, t)
	}

	/**
	* Read a JSON file and return an object
	*
	* @param path The path of the file to be read
	* @return Object The object from the JSON file
	*/
	public static Object ReadJSON(String path, Type t) {
		String str = FileUtils.readFileToString(path, "utf-8");
		return this.deserialize(str, t);
	}

	/**
	* Read a list of Places from a JSON file
	*
	* @param path The path of the fileto be read
	* @return ArrayList<Place> List of places from the JSON file
	*/
	public static ArrayList<Place> ReadPlacesJSON(String path) {
		Type t = new TypeToken<ArrayList<Place>>(){}.getType();
		return this.ReadJSON(path, t);
	}

	/**
	* Read a list of Users from a JSON file
	*
	* @param path The path of the fileto be read
	* @return ArrayList<User> List of users from the JSON file
	*/
	public static ArrayList<User> ReadUsersJSON(String path) {
		Type t = new TypeToken<ArrayList<User>>(){}.getType();
		return this.ReadJSON(path, t);
	}

	/**
	* Write an object to a JSON file - can be used to write a List
	*
	* @param path Path of the file to be written 
	* @param obj This is the object to convert into JSON
	*/
	public static void WriteJSON(String path, Object obj) {
		//try-with-resources
		try (FileWriter file = new FileWriter(path)) {
			file.write(this.serialize(obj));
		}
	}

}
