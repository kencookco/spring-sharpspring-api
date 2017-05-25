package com.kencook.sharpspring.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Response from the Sharpspring API
 *
 * @since 0.1.0
 */
@Getter @Setter
public class SharpspringResponse<T> {

    private long id;
    private T result;
    private Map<String, Object> error;

}
