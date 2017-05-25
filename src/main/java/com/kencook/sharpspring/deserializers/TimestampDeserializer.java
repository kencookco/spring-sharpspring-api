package com.kencook.sharpspring.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Deserialize a timestamp from Sharpspring.
 *
 * @since 0.1.0
 */
public class TimestampDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        String timestamp = p.getText().trim();

        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(timestamp);
        } catch (ParseException e) {
            throw new IOException(e);
        }
    }

}
