package bodyinfo;

import io.restassured.path.json.JsonPath;

public class Reuse {
    public static JsonPath path;

    public static JsonPath rawtoJson(String response) {
        path = new JsonPath(response);
        return path;
    }
}
