package com.kencook.sharpspring;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Build a Sharpspring Request.
 *
 * @since 0.1.0
 */
public class SharpspringRequestBuilder {

    private int id;
    private SharpspringMethod method;
    private List<Condition> conditions = new ArrayList<>();

    public SharpspringRequestBuilder(int id, SharpspringMethod method) {
        this.id = id;
        this.method = method;
    }

    /**
     * Build the {@link SharpspringRequest}
     * @return a {@link SharpspringRequest} object with the parameters provided by the builder.
     */
    public SharpspringRequest build() {

        SharpspringRequest request = new SharpspringRequest();
        request.setMethod(method.value());
        request.setId(id);

        Map<String, Object> where = new HashMap<>();

        for (Condition condition : conditions ) {
            where.put(condition.getKey(), condition.getArgument());
        }

        request.getParams().put("where", where);

        return request;
    }

    public Condition where(String key) {
        return new Condition(this, key);
    }

    @Getter
    public class Condition {

        private String key;
        private Object argument;
        private SharpspringRequestBuilder builder;

        public Condition(SharpspringRequestBuilder builder, String key) {
            this.key = key;
            this.builder = builder;
        }

        public SharpspringRequestBuilder is(Object argument) {
            this.argument = argument;
            builder.conditions.add(this);
            return builder;
        }

    }

    public static SharpspringRequestBuilder request(int id, SharpspringMethod method) {
        return new SharpspringRequestBuilder(id, method);
    }

}
