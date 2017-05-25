package com.kencook.sharpspring;

/**
 * Stores available Sharpspring methods.
 *
 * @since 0.1.0
 */
public enum SharpspringMethod {

    GET_EVENTS("getEvents");

    private String method;

    public String value() {
        return method;
    }

    SharpspringMethod(String method) {
        this.method = method;
    }

}
