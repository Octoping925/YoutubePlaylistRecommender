package octoping.YoutubePlaylistRecommender.common.utility;

import java.util.HashMap;
import java.util.Map;

public class ResponseObject {
    Object data;
    String message;

    private ResponseObject(Object data, String message) {
        this.data = data;
        this.message = message;
    }

    public static Map<String, Object> create(Object data, String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", data);
        map.put("message", message);
        return map;
//        return Map.of("data", data, "message", message);
//        return new ResponseObject(data, message);
    }
}
