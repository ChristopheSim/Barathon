import java.lang.*

public final class JSONAccess {

	private Gson gson = new Gson();

	public static String serialize(Object obj, Type t) {
		return this.gson.toJson(obj, t);
	}

	public static Object deserialize(Object obj, Type t) {
		return this.gson.fromJson(obj, t)
	}
}
