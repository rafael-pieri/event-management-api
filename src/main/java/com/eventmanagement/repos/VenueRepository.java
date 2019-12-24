package com.eventmanagement.repos;

import com.eventmanagement.entities.Venue;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

@SuppressWarnings("unused")
public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {

    Page<Venue> findByPostalCode(@Param("postalCode") String postalCode, Pageable pageable);
}