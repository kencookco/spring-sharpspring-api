package com.kencook.sharpspring;

import com.kencook.sharpspring.responses.GetEventsResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.kencook.sharpspring.SharpspringRequestBuilder.request;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SharpspringOperationsTest {

    @Autowired
    private SharpspringOperations operations;

    @Autowired
    private SharpspringProperties properties;

    @Test
    public void urlIsConfiguredCorrectly() {

        assertThat(operations.getURL()).isEqualTo(properties.getUrl()+"?accountID="+
                properties.getAccountId()+"&secretKey="+properties.getSecretKey());

    }

    /**
     * This test performs no assertions because we cannot know what content the server might have. and exists to test a query and ensure connection and that the response
     * is parsed correctly.
     */
    @Test
    public void queryIsSuccessful() {

        SharpspringRequest request = request(1, SharpspringMethod.GET_EVENTS)
                .where("createTimestamp").is("2017-05-23")
                .build();

        GetEventsResponse result = operations.query(request, GetEventsResponse.class);

    }

}
