package com.hxgfk.json;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

public class JSONParser {
    public static JSONObject parse(String json){
        return JSONObject.parse(json);
    }

    public static JSONArray parseArray(String json){
        return JSON.parseArray(json);
    }

    public static String toString(JSONObject json) {
        return JSON.toJSONString(json);
    }

    public static String toString(JSONArray json){
        return JSON.toJSONString(json);
    }
}
