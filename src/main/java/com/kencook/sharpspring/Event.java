package com.kencook.sharpspring;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kencook.sharpspring.deserializers.StringToMapSerializer;
import com.kencook.sharpspring.deserializers.TimestampDeserializer;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

/**
 * Representation of a Sourcespring event.
 *
 * @since 0.1.0
 */
@Getter @Setter
public class Event {

    private long id;
    @JsonProperty("leadID")
    private long leadId;
    @JsonProperty("eventName")
    private String name;
    @JsonProperty("whatID")
    private String whatId;
    private String whatType;
    @JsonDeserialize(using = StringToMapSerializer.class)
    @JsonProperty("eventData")
    private Map<String, Object> data;
    @JsonProperty("eventSource")
    private String source;
    @JsonDeserialize(using= TimestampDeserializer.class)
    @JsonProperty("createTimestamp")
    private Date created;

}
