package com.project.product.converter;

import java.util.HashMap;
import java.util.Map;
public class HashMapConverter extends JsonAttributeConverter<Map<String, Object>> {
    public HashMapConverter() {
        super(getMapClass());
    }

    private static Class<Map<String, Object>> getMapClass() {
        Map<String, Object> dummyMap = new HashMap<>();
        @SuppressWarnings("unchecked")
        Class<Map<String, Object>> mapClass = (Class<Map<String, Object>>) dummyMap.getClass();
        return mapClass;
    }
}