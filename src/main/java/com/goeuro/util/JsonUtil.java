package com.goeuro.util;

import com.goeuro.dto.City;
import com.google.gson.Gson;

/**
 * Created by Zdenek Strbik
 */
public final class JsonUtil {

    private JsonUtil() {
    }

    /**
     * Deserializes Cities from json string
     * @param json Input json
     * @return Cities extracted from json
     */
    public static City[] deserialize(String json) {
        Gson gson = new Gson();

        return gson.fromJson(json, City[].class);
    }

}
