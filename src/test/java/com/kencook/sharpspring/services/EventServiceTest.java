package com.kencook.sharpspring.services;

import com.kencook.sharpspring.SharpspringException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Integration test of the event service.
 *
 * @since 0.1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EventServiceTest {

    @Autowired
    private EventService eventService;

    @Test
    public void getEventsWithTimestamp() throws SharpspringException {
        eventService.getEvents("2017-05-23");
    }

}
