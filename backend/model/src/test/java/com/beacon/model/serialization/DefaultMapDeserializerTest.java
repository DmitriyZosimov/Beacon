package com.beacon.model.serialization;

import com.beacon.model.builders.ShopBuilder;
import com.beacon.model.selialization.DefaultMapDeserializer;
import com.beacon.model.shop.Shop;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.type.MapType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class DefaultMapDeserializerTest {

    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        SimpleModule module = new SimpleModule();
        BeanDeserializerModifier modifier = new BeanDeserializerModifier() {
            @Override
            public JsonDeserializer<?> modifyMapDeserializer(DeserializationConfig config, MapType type, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
                return new DefaultMapDeserializer(type, config.getTypeFactory());
            }
        };

        module.setDeserializerModifier(modifier);
        mapper.registerModule(module);
    }

    @Test
    public void getSerializedMapAsListOfEntryMap() throws JsonProcessingException {
        String json = "[ {\n" +
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

        Map<Shop, Double> mapResult = mapper.readValue(json, new TypeReference<Map<Shop, Double>>() {
        });

        Assertions.assertEquals(map, mapResult);
    }
}