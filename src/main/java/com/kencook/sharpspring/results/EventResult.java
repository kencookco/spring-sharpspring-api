package com.kencook.sharpspring.results;

import com.kencook.sharpspring.Event;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Result of an event request.
 *
 * @since 0.1.0
 */
@Getter @Setter
public class EventResult {

    private List<Event> event;

}
