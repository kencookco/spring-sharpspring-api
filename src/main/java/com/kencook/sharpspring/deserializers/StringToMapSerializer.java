package com.kencook.sharpspring.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Parse a string that is Json into a map.
 *
 * @since 0.1.0
 */
public class StringToMapSerializer extends JsonDeserializer<Map<String,Object>> {

    @Override
    public Map<String, Object> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // the data comes with attributes single quoted. We are replacing these values, though I have not see
        // enough data to know if this will cause other problems.
        String text = p.getText().trim().replace("'", "\"");

        TypeReference<HashMap<String,Object>> typeRef
                = new TypeReference<HashMap<String,Object>>() {};

        return mapper.readValue(text, typeRef);
    }
}
