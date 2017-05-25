package com.kencook.sharpspring;

import com.kencook.sharpspring.properties.SharpspringProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

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

}
