package com.beacon.model.selialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.Getter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Serializer allows to serialize the {@code Map} as {@code List} of key-value, instead of as a list of JSON
 * key-value pairs (using the default serializer {@code MapSerializer})
 * <p>
 * The result of this serialization can look like:
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
 * @param <K>
 * @param <V>
 */
public class DefaultMapSerializer<K, V> extends StdSerializer<Map<K, V>> {

    private static final long serialVersionUID = 1L;

    public DefaultMapSerializer() {
        super(Map.class, true);
    }

    @Override
    public void serialize(Map<K, V> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        List<SimpleEntry<K, V>> listValues = value.entrySet()
                .stream()
                .map(SimpleEntry::new)
                .collect(Collectors.toList());
        provider.defaultSerializeValue(listValues, gen);
    }

    @Getter
    protected static class SimpleEntry<K, V> {
        private K key;
        private V value;

        public SimpleEntry(Map.Entry<K, V> entry) {
            key = entry.getKey();
            value = entry.getValue();
        }
    }
}