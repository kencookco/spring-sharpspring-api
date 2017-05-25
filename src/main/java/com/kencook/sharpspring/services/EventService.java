package com.kencook.sharpspring.services;

import com.kencook.sharpspring.Event;
import com.kencook.sharpspring.SharpspringMethod;
import com.kencook.sharpspring.SharpspringOperations;
import com.kencook.sharpspring.SharpspringRequest;
import com.kencook.sharpspring.SharpspringException;
import com.kencook.sharpspring.responses.GetEventsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.kencook.sharpspring.SharpspringRequestBuilder.request;

/**
 * Service for Sharpspring events.
 *
 * @since 0.1.0
 */
@Component
public class EventService {

    private SharpspringOperations operations;

    @Autowired
    public EventService(SharpspringOperations operations) {
        this.operations = operations;
    }

    /**
     * Returns a list of events related to the provided timestamp string.
     * @param timestamp yyyy-MM-dd HH:mm:ss dates without time will pull events for the entire date.
     * @return a list of events associated with the timestamp
     */
    List<Event> getEvents(String timestamp) throws SharpspringException {
        SharpspringRequest request = request(1, SharpspringMethod.GET_EVENTS)
                .where("createTimestamp").is("2017-05-23")
                .build();

        GetEventsResponse result = operations.query(request, GetEventsResponse.class);

        if(result.getError() != null)
            throw new SharpspringException(result.getError());

        return result.getResult().getEvent();
    }

}
