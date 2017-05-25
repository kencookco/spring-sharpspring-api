package com.kencook.sharpspring;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple Sharpspring request for the API.
 *
 * @since 0.1.0
 */
@Getter @Setter
public class SharpspringRequest {

    public String method;
    public int id;
    public Map<String,Map<String,Object>> params = new HashMap<>();

}
