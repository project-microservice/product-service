package com.project.product.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;

public class JsonAttributeConverter<T> implements AttributeConverter<T, String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final Class<T> targetType;

    public JsonAttributeConverter(Class<T> targetType) {
        this.targetType = targetType;
    }

    @Override
    public String convertToDatabaseColumn(T attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException jpe) {
            return null;
        }
    }

    @Override
    public T convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, targetType);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
