package com.beacon.catalog.config;

import com.beacon.model.selialization.DefaultMapDeserializer;
import com.beacon.model.selialization.DefaultMapSerializer;
import com.beacon.model.shop.Shop;
import com.beacon.model.shop.WorkingHours;
import com.beacon.security.annotation.EnableBeaconSecurity;
import com.beacon.security.config.Application;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.type.MapType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.DayOfWeek;

@Configuration
@ComponentScan(basePackages = "com.beacon.catalog")
@EnableBeaconSecurity(application = Application.CATALOG)
public class ContextConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }

    @Bean(name = "customSimpleModule")
    public SimpleModule module() {
        SimpleModule module = new SimpleModule();
        module.setSerializerModifier(new BeanSerializerModifier() {
            @Override
            public JsonSerializer<?> modifyMapSerializer(SerializationConfig config, MapType valueType, BeanDescription beanDesc, JsonSerializer<?> serializer) {
                return new DefaultMapSerializer();
            }
        });

        module.setDeserializerModifier(new BeanDeserializerModifier() {
            @Override
            public JsonDeserializer<?> modifyMapDeserializer(DeserializationConfig config, MapType type, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
                if ((type.getKeyType().isTypeOrSubTypeOf(Shop.class) && type.getContentType().isTypeOrSubTypeOf(Double.class))
                || (type.getKeyType().isTypeOrSubTypeOf(DayOfWeek.class) && type.getContentType().isTypeOrSubTypeOf(WorkingHours.class))) {
                    return new DefaultMapDeserializer(type, config.getTypeFactory());
                } else {
                    return deserializer;
                }
            }
        });
        return module;
    }
}
