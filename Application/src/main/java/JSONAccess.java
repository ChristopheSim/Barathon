import java.lang.*

/**
*	Class used to save objects to JSON files and to extract objects from such files
*/
public final class JSONAccess {

	private Gson gson = new Gson();
	
	/**
	* This method is used to convert an object into a JSON string
	*
	* @param obj This is the object to convert into JSON
	* @param t This is the type of the object to convert into JSON
	* @return String This is the string containing the JSON formatted object
	*/
	public static String serialize(Object obj, Type t) {
		return this.gson.toJson(obj, t);
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
}
