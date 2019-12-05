package com.ct.utils;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConvertUtil {
    public static List<String> toList(JSONArray array){
        List<String> list = new ArrayList<>();
        for (int i = 0;i<array.size();i++){
            list.add(array.getString(i));
        }
        return list;
    }

    public static List<Map<String,Object>> toListMap(JSONArray array){
        List<Map<String,Object>> list = new ArrayList<>();
        for (int i = 0;i<array.size();i++){
            list.add(array.getJSONObject(i));
        }
        return list;
    }
}
