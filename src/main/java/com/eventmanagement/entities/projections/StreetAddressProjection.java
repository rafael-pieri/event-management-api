package com.eventmanagement.entities.projections;

import com.eventmanagement.entities.Venue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@SuppressWarnings("unused")
@Projection(name = "virtual", types = {Venue.class})
public interface StreetAddressProjection {

    @Value("#{target.streetAddress} #{target.streetAddress2}")
    String getCompleteStreetAddress();
}