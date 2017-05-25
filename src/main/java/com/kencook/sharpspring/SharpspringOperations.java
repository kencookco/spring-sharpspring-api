package com.kencook.sharpspring;

import com.kencook.sharpspring.responses.SharpspringResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Passes requests to Sharpspring
 */
@Component
public class SharpspringOperations {

    private RestOperations operations;
    private String url;

    @Autowired
    public SharpspringOperations(SharpspringProperties properties) {
        operations = new RestTemplate();

        url = UriComponentsBuilder.fromHttpUrl(properties.getUrl())
                .queryParam("accountID", properties.getAccountId())
                .queryParam("secretKey", properties.getSecretKey())
                .toUriString();
    }

    public String getURL() {
        return url;
    }

    /**
     * Query Sharpspring accepts a request.
     * @param request request
     * @param clazz class of the return type
     * @param <T> return type of the request
     * @return list of results from the query
     */
    @SuppressWarnings("unchecked")
    public <T> T query(SharpspringRequest request, Class<T> clazz) {
        return operations.postForObject(url, request, clazz);
    }


}
