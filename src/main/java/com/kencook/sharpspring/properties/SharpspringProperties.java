package com.kencook.sharpspring.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Properties used to access Sharpspring.
 *
 * @since 0.1.0
 */
@Component
@ConfigurationProperties("sharpspring")
@Getter @Setter
public class SharpspringProperties {

    /**
     * Sharpspring Account ID.
     */
    private String accountId;
    /**
     * Secret key used to access API.
     */
    private String secretKey;
    /**
     * Sharpspring API URL
     */
    private String url;

}
