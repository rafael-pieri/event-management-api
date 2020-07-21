package com.eventmanagement.model.projections;

import com.eventmanagement.model.Venue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@SuppressWarnings("unused")
@Projection(name = "virtual", types = {Venue.class})
public interface StreetAddressProjection {

    @Value("#{target.streetAddress} #{target.streetAddress2}")
    String getCompleteStreetAddress();
}