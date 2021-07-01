package untils;

import java.util.HashMap;
import java.util.Map;

public class Stash {

    public static Map<String, String> map = new HashMap<>();

    public static void put (String key,String value) {
        map.put(key,value);
    }

    public static String getValue (String key) {
        return map.get(key);
    }
}
