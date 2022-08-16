package com.beacon.model.selialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.Setter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Deserializer allows to deserialize the {@code Map} from the {@code List} of key-value, instead of JSON
 * key-value pairs (using the default deserializer {@code MapDeserializer})
 * <p>
 * The result {@code Map} from this JSON:
 *  [{
 *      "key": K,
 *      "value": V
 *  },
 *  {
 *      "key": K,
 *      "value": V
 *  }]
 * </p>
 *
 * @param <K> - the type of key
 * @param <V> - the type of value
 */
public class DefaultMapDeserializer<K, V> extends StdDeserializer<Map<K, V>> {

    private static final long serialVersionUID = 1L;

    private final CollectionType type;

    public DefaultMapDeserializer(MapType type, TypeFactory factory) {
        super(Map.class);
        this.type = factory.constructCollectionType(List.class,
                factory.constructParametricType(SimpleEntry.class, type.getKeyType(), type.getContentType()));
    }

    @Override
    public Map<K, V> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        List<SimpleEntry<K, V>> listValues = ctxt.readValue(p, type);
        Map<K, V> map = new HashMap<>();
        listValues.forEach(value -> map.put(value.key, value.value));
        return map;
    }

    @Setter
    protected static class SimpleEntry<K, V> {
        private K key;
        private V value;

        public SimpleEntry() {

        }
    }
}