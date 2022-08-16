package com.beacon.model.serialization;

import com.beacon.model.builders.ShopBuilder;
import com.beacon.model.selialization.DefaultMapSerializer;
import com.beacon.model.shop.Shop;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.type.MapType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class DefaultMapSerializerTest {

    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        SimpleModule module = new SimpleModule();
        BeanSerializerModifier modifier = new BeanSerializerModifier() {
            @Override
            public JsonSerializer<?> modifyMapSerializer(SerializationConfig config, MapType valueType, BeanDescription beanDesc, JsonSerializer<?> serializer) {
                return new DefaultMapSerializer();
            }
        };

        module.setSerializerModifier(modifier);
        mapper.registerModule(module);
    }

    @Test
    public void getSerializedMapAsListOfEntryMap() throws JsonProcessingException {
        String rightAnswer = "[ {\n" +
                "  \"key\" : {\n" +
                "    \"shopId\" : null,\n" +
                "    \"name\" : \"test1\",\n" +
                "    \"description\" : \"desc1\",\n" +
                "    \"workingHoursMap\" : null,\n" +
                "    \"paymentMethods\" : null,\n" +
                "    \"logo\" : null\n" +
                "  },\n" +
                "  \"value\" : 4500.5\n" +
                "}, {\n" +
                "  \"key\" : {\n" +
                "    \"shopId\" : null,\n" +
                "    \"name\" : \"test2\",\n" +
                "    \"description\" : \"desc2\",\n" +
                "    \"workingHoursMap\" : null,\n" +
                "    \"paymentMethods\" : null,\n" +
                "    \"logo\" : null\n" +
                "  },\n" +
                "  \"value\" : 2500.5\n" +
                "} ]";

        Map<Shop, Double> map = new HashMap<>();
        map.put(ShopBuilder.create().name("test1").description("desc1").build(), 4500.5);
        map.put(ShopBuilder.create().name("test2").description("desc2").build(), 2500.5);

        String jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        Assertions.assertEquals(rightAnswer, jsonResult);
    }
}