package com.kencook.sharpspring;

import lombok.Getter;

import java.util.Map;

/**
 * An exception due to errors in the Sharpspring response
 *
 * @since 0.1.0
 */
@Getter
public class SharpspringException extends Exception {

    private Map<String, Object> error;

    public SharpspringException(Map<String, Object> error) {
        this.error = error;
    }

}
