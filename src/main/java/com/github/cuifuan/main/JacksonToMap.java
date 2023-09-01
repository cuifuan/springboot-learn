package com.github.cuifuan.main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class JacksonToMap {
    public static void main(String[] args) {
        String json = "{\"id\": 1,\"name\": \"张三\",\"age\": 30}";

        Map<String, Object> map = new HashMap<String, Object>();

        ObjectMapper mapper = new ObjectMapper();
        try {
            // 转换 json 为 Map
            map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
            });

            // 输出 Map
            System.out.println(map);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
