package com.eventmanagement.model.projections;

import com.eventmanagement.model.Event;

import java.time.Instant;
import java.time.ZonedDateTime;

import org.springframework.data.rest.core.config.Projection;

@SuppressWarnings("unused")
@Projection(name = "partial", types = {Event.class})
public interface PartialEventProjection {

    String getName();

    ZonedDateTime getStartTime();

    ZonedDateTime getEndTime();

    Instant getCreated();
}