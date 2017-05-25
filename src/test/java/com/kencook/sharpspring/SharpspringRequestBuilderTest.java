package com.kencook.sharpspring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.kencook.sharpspring.SharpspringRequestBuilder.request;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the request builder.
 *
 * @since 0.1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SharpspringRequestBuilderTest {

    @Test
    public void requestConfigured() {

        SharpspringRequest request = request(1, SharpspringMethod.GET_EVENTS)
                .where("createTimestamp").is("2017-05-23")
                .build();

        assertThat(request.getMethod()).isEqualTo(SharpspringMethod.GET_EVENTS.value());

        assertThat(request.getId()).isEqualTo(1);

        assertThat(request.getParams().get("where").get("createTimestamp")).isEqualTo("2017-05-23");

    }

}
